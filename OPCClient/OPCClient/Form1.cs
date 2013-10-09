using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Windows.Forms;
using OPCAutomation;


namespace OPCClient
{
    public partial class Form1 : Form
    {

        private OPCServer Server;
        private OPCGroups Groups;
        private OPCGroup G;
        private OPCItems Items;
        private OPCBrowser brow;
        private ClientConfig clientConfig;

        private List<int> clientHandles ;
        private List<int> serverHandles ;
        private List<OPCItem> selectedItems ;

        public Form1()
        {
            InitializeComponent();
            clientConfig = new ClientConfig();
            readini();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            clientHandles = new List<int>();
            serverHandles = new List<int>();
            selectedItems = new List<OPCItem>();
            serverHandles.Add(0);
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (Groups != null && Groups.Count > 0)
            {
                Groups.Remove("TestGroup");
            }
            if (Server != null && Server.ServerState != (int)OPCServerState.OPCDisconnected)
            {
                Server.Disconnect();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                Server = new OPCServer();
                Server.Connect(textBox1.Text, textBox2.Text);

                brow = Server.CreateBrowser();
                brow.ShowBranches();
                TreeNode root = treeView1.Nodes.Add("root");
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
                //for (int i = 0; i < root.Nodes.Count; i++)
                //{
                //    brow.MoveDown(root.Nodes[i].Text);
                //    for (int j = 0; j < root.Nodes[i].Nodes.Count; j++)
                //    {
                //        brow.MoveDown(root.Nodes[i].Nodes[j].Text);
                //        brow.ShowLeafs(false);
                //        for (int k = 1; k <= brow.Count; k++)
                //        {
                //            root.Nodes[i].Nodes[j].Nodes.Add(brow.Item(k));
                //        }
                //        brow.MoveUp();
                //    }
                //    brow.MoveUp();
                //}


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
                button2.Enabled = true;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            timer1.Enabled = true;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if(listBox1.SelectedItems.Count>0&&!listBox2.Items.Contains(listBox1.SelectedItem))
            {
                int k = clientHandles.Count;
                string id = brow.GetItemID(listBox1.SelectedItem.ToString());
                OPCItem item = Items.AddItem(id, k);
                clientHandles.Add(k);
                serverHandles.Add(item.ServerHandle);
                selectedItems.Add(item);
                listBox2.Items.Add(listBox1.SelectedItem.ToString());
            }
        }


        private void timer1_Tick(object sender, EventArgs e)
        {
            //单项同步读取
            //object Va, Qu, Ti;
            //listBox3.Items.Clear();
            //foreach (OPCItem item in selectedItems)
            //{
            //    item.Read((short)OPCDataSource.OPCDevice, out Va, out Qu, out Ti);
            //    if (Va != null)
            //    {
            //        listBox3.Items.Add(Va);
            //    }
            //    else
            //    {
            //        listBox3.Items.Add("null");
            //    }
            //}


            Array SH = serverHandles.ToArray();
            Array V;
            Array E;
            object Q, T;
            //组同步读取
            G.SyncRead((short)OPCDataSource.OPCDevice, selectedItems.Count, ref SH, out V, out E, out Q, out T);
            listBox3.Items.Clear();
            //object[] values = new object[selectedItems.Count];
            //V.CopyTo(values, 0);
            for (int i = 1; i <= V.Length; i++)
            {
                if (V.GetValue(i) != null)
                {
                    listBox3.Items.Add(V.GetValue(i).ToString());
                }
                else
                {
                    listBox3.Items.Add("null");
                }
            }
        }



        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            listBox1.Items.Clear();
            if (e.Node.Level == 2)
            {
                string[] path = { "", e.Node.Parent.Text, e.Node.Text };
                Array aPath = path as Array;
                brow.MoveTo(ref aPath);
                brow.ShowLeafs(false);
                for (int k = 1; k <= brow.Count; k++)
                {
                    listBox1.Items.Add(brow.Item(k));
                }
            }
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

        private void readini()
        {
            textBox2.Text = clientConfig.OpcAddr;
            textBox1.Text = clientConfig.OpcName;
            textBox3.Text = clientConfig.DbAddr;
            textBox4.Text = clientConfig.DbName;
            textBox5.Text = clientConfig.DbPort;
            textBox6.Text = clientConfig.DbUser;
            textBox7.Text = clientConfig.DbPasw;
            textBox8.Text = clientConfig.Timespan.ToString();
            listBox2.Items.AddRange(clientConfig.ItemNames.ToArray());
        }

        private void saveini()
        {
            clientConfig.OpcAddr = textBox2.Text.Trim();
            clientConfig.OpcName = textBox1.Text.Trim();
            clientConfig.DbAddr = textBox3.Text.Trim();
            clientConfig.DbName = textBox4.Text.Trim();
            clientConfig.DbPort = textBox5.Text.Trim();
            clientConfig.DbUser = textBox6.Text.Trim();
            clientConfig.DbPasw = textBox7.Text.Trim();
            clientConfig.Timespan = Int32.Parse(textBox8.Text.Trim());
            clientConfig.ItemNames.Clear();
            
            FileStream fs = new FileStream("opcConfig.ini", FileMode.Truncate);
            StreamWriter output = new StreamWriter(fs);
            //开始写入
            output.Write("host="+textBox2.Text+"\r\n");
			output.Write("name="+textBox1.Text+"\r\n");
			output.Write("dbhost="+textBox3.Text+"\r\n");
			output.Write("dbname="+textBox4.Text+"\r\n");
			output.Write("dbuser="+textBox6.Text+"\r\n");
			output.Write("dbpsw="+textBox7.Text+"\r\n");
			output.Write("dbport="+textBox5.Text+"\r\n");
			output.Write("timespan="+textBox8.Text+"\r\n");            
            foreach(object o in listBox2.Items)
            {
                string temp_str = o.ToString();
                clientConfig.ItemNames.Add(temp_str);
                output.Write(temp_str + "\r\n");
            }
            
            //清空缓冲区
            output.Flush();
            //关闭流
            output.Close();
            fs.Close();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            saveini();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            listBox2.Items.Clear();
            selectedItems.Clear();
            clientHandles.Clear();
            serverHandles.Clear();
        }

        private void button7_Click(object sender, EventArgs e)
        {
            int si = listBox2.SelectedIndex;    
            if (si > -1)
            {
                listBox2.Items.RemoveAt(si);
                if (selectedItems.Count == listBox2.Items.Count+1)
                {
                    selectedItems.RemoveAt(si);
                    clientHandles.RemoveAt(si);
                    serverHandles.RemoveAt(si);
                }  
            }
                    
        }

        private void button5_Click(object sender, EventArgs e)
        {
            foreach (object o in listBox1.Items)
            {
                if (!listBox2.Items.Contains(o))
                {
                    int k = clientHandles.Count;
                    string id = brow.GetItemID(o.ToString());
                    OPCItem item = Items.AddItem(id, k);
                    clientHandles.Add(k);
                    serverHandles.Add(item.ServerHandle);
                    selectedItems.Add(item);
                    listBox2.Items.Add(o.ToString());
                }
            }          
        }
    }
}