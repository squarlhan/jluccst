using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace OPCClient
{
    static class Program
    {
        /// <summary>
        /// 应用程序的主入口点。
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Form1 form1 = new Form1();          
            Application.Run(form1);
            form1.Visible = false;
            form1.Hide();

            //DBAction dba = new DBAction();
            //dba.dosth();
        }
    }
}