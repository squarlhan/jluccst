using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
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


        List<int> clientHandles = new List<int>();
        List<int> serverHandles = new List<int>();
        List<OPCItem> selectedItems = new List<OPCItem>();

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
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
                Server.Connect(textBox1.Text,textBox2.Text);

                brow = Server.CreateBrowser();
                brow.ShowBranches();
                TreeNode root=treeView1.Nodes.Add("root");
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
            int k = clientHandles.Count;
            string id = brow.GetItemID(listBox1.SelectedItem.ToString());
            OPCItem item = Items.AddItem(id, k);
            clientHandles.Add(k);
            serverHandles.Add(item.ServerHandle);
            selectedItems.Add(item);
            listBox2.Items.Add(listBox1.SelectedItem.ToString());
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
                string[] path ={"",e.Node.Parent.Text,e.Node.Text };
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

    }
}