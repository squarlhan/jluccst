using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using OPCAutomation;

namespace OPCClient
{
    class DBAction
    {
        private MySqlConnection conn;
        private MySqlCommand cmd;
        private OPCServer Server;
        private OPCGroups Groups;
        private OPCGroup G;
        private OPCItems Items;
        private OPCBrowser brow;
        private ClientConfig clientConfig;

        private List<int> clientHandles;
        private List<int> serverHandles ;
        private List<OPCItem> selectedItems;

        public DBAction()
        {
            clientConfig = new ClientConfig();
            clientHandles = new List<int>();
            serverHandles = new List<int>();
            selectedItems = new List<OPCItem>();
            serverHandles.Add(0);
            connect2DB();
            connect2OPC();
        }

        public DBAction(ClientConfig clientConfig, List<int> clientHandles, List<int> serverHandles, List<OPCItem> selectedItems)
        {
            this.clientConfig = clientConfig;
            this.clientHandles = clientHandles;
            this.serverHandles = serverHandles;
            this.selectedItems = selectedItems;
            connect2DB();
            connect2OPC();
        }

        /// <summary>
        /// 每当项数据有变化时执行的事件
        /// </summary>
        /// <param name="TransactionID">处理ID</param>
        /// <param name="NumItems">项个数</param>
        /// <param name="ClientHandles">项客户端句柄</param>
        /// <param name="ItemValues">TAG值</param>
        /// <param name="Qualities">品质</param>
        /// <param name="TimeStamps">时间戳</param>1    `
        void GroupDataChange(int TransactionID, int NumItems, ref Array ClientHandles, ref Array ItemValues, ref Array Qualities, ref Array TimeStamps)
        {
            //若想使用订阅方式，则取消此注释，并注释掉timer事件里的代码
            //listBox3.Items.Clear();
            //for (int i = 1; i <= NumItems; i++)
            //{
            //    string s = ClientHandles.GetValue(i).ToString() + ":" + ItemValues.GetValue(i).ToString();
            //    listBox3.Items.Add(s);
            //}
        }

        private void connect2OPC()
        {
            try
            {
                Server = new OPCServer();
                Server.Connect(clientConfig.OpcName, clientConfig.OpcAddr);
                Groups = Server.OPCGroups;
                Groups.DefaultGroupIsActive = true;
                Groups.DefaultGroupDeadband = 0;
                G = Groups.Add("TestGroup");
                G.IsActive = true;
                G.IsSubscribed = true;
                G.DeadBand = 0;
                G.UpdateRate = 1000;
                G.DataChange += new DIOPCGroupEvent_DataChangeEventHandler(GroupDataChange); //订阅
                Items = G.OPCItems;
                int c = clientConfig.ItemNames.Count;
                if (c > 0)
                {
                    for (int i = 0; i <= c - 1; i++)
                    {
                        OPCItem item = Items.AddItem(clientConfig.ItemNames[i], i);
                        clientHandles.Add(i);
                        serverHandles.Add(item.ServerHandle);
                        selectedItems.Add(item);
                    }
                }
                else
                {
                    brow = Server.CreateBrowser();
                    brow.ShowBranches();
                    int kk = 0;
                    TreeNode root = new TreeNode();
                    for (int i = 1; i <= brow.Count; i++)
                    {
                        root.Nodes.Add(brow.Item(i));
                    }

                    for (int i = 0; i < root.Nodes.Count; i++)
                    {
                        brow.MoveDown(root.Nodes[i].Text);
                        brow.ShowBranches();
                        for (int j = 1; j <= brow.Count; j++)
                        {
                            root.Nodes[i].Nodes.Add(brow.Item(j));
                        }
                        brow.MoveUp();
                    }

                    //如需要第三层结点，则取消此注释
                    for (int i = 0; i < root.Nodes.Count; i++)
                    {
                        brow.MoveDown(root.Nodes[i].Text);
                        for (int j = 0; j < root.Nodes[i].Nodes.Count; j++)
                        {
                            brow.MoveDown(root.Nodes[i].Nodes[j].Text);
                            brow.ShowLeafs(false);
                            for (int k = 1; k <= brow.Count; k++)
                            {
                                OPCItem item = Items.AddItem(brow.Item(k), kk);
                                clientHandles.Add(kk);
                                serverHandles.Add(item.ServerHandle);
                                selectedItems.Add(item);
                                kk++;
                            }
                            brow.MoveUp();
                        }
                        brow.MoveUp();
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

      
        private void connect2DB()
        {
            string connStr = String.Format("server={0};uid={1};pwd={2};database={3}",
                clientConfig.DbAddr , clientConfig.DbUser,
                clientConfig.DbPasw, clientConfig.DbName);
            conn = new MySqlConnection(connStr);
        }

        public void dosth()
       {
           //try
           {
               conn.Open();
               string sql_tr = "truncate table motodcsdata";
               cmd = new MySqlCommand(sql_tr, conn);
               cmd.ExecuteNonQuery();

               Array SH = serverHandles.ToArray();
               Array V;
               Array E;
               object Q, T;
               G.SyncRead((short)OPCDataSource.OPCDevice, selectedItems.Count, ref SH, out V, out E, out Q, out T);
               for (int i = 1; i <= V.Length; i++)
               {
                   string sqld = "";
                   string sqlh = "";
                   double value = 0;
                   if (V.GetValue(i) != null)
                   {
                       string temp = V.GetValue(i).ToString().Trim();
                       temp = temp.Equals("True") ? "0" : temp;
                       temp = temp.Equals("False") ? "1" : temp;
                       value = double.Parse(temp);
                   }
                   else
                   {
                       value = -9999;
                   }
                   string name = selectedItems[i - 1].ItemID;
                   string item = selectedItems[i - 1].ItemID;
                   sqld = "insert into motodcsdata(equipment, item, value) values('"+ name+ "','" + item + "',"+ value + ")";
                   string mytime = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");
                   sqlh = "insert into motodcshistory(equipment, item, seqno,value) values('" + name+ "','" + item  + "','"+ mytime + "'," + value + ")";
                   cmd = new MySqlCommand(sqld, conn);
                   cmd.ExecuteNonQuery();
                   cmd = new MySqlCommand(sqlh, conn);
                   cmd.ExecuteNonQuery();
               }
               conn.Close();
           }
           //catch (Exception ex)
           //{
           //    MessageBox.Show("Exception: " + ex.Message);
           //}

       }
    }
}
