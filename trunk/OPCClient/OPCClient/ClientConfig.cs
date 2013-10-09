using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;

namespace OPCClient
{
    public class ClientConfig
    {
        private string opc_addr;
        private string opc_name;
        private string db_addr;
        private string db_name;
        private string db_port;
        private string db_user;
        private string db_pasw;
        private int timespan;
        private List<string> item_names;

        public string OpcAddr
        {
            get { return opc_addr; }
            set { opc_addr = value; }
        }

        public string DbAddr
        {
            get { return db_addr; }
            set { db_addr = value; }
        }

        public string OpcName
        {
            get { return opc_name; }
            set { opc_name = value; }
        }

        public string DbName
        {
            get { return db_name; }
            set { db_name = value; }
        }

        public string DbPort
        {
            get { return db_port; }
            set { db_port = value; }
        }

        public string DbUser
        {
            get { return db_user; }
            set { db_user = value; }
        }

        public string DbPasw
        {
            get { return db_pasw; }
            set { db_pasw = value; }
        }

        public int Timespan
        {
            get { return timespan; }
            set { timespan = value; }
        }

        public List<string> ItemNames
        {
            get { return item_names; }
            set { item_names = value; }
        }

        public ClientConfig()
        {
            ItemNames = new List<string>();
            string str = System.Windows.Forms.Application.StartupPath;
            StreamReader objReader = new StreamReader(str+"\\opcConfig.ini");
            string row = "";
            ArrayList LineList = new ArrayList();
            while (row != null)
            {
                row = objReader.ReadLine();
                if (row != null && !row.Equals(""))
                {
                    if (row.Trim().StartsWith("host"))
                    {
                        String[] ns = row.Trim().Split('=');
                        OpcAddr = ns[1].Trim();
                    }
                    if (row.Trim().StartsWith("name"))
                    {
                        String[] ns = row.Trim().Split('=');
                        OpcName = ns[1].Trim();
                    }
                    if (row.Trim().StartsWith("dbname"))
                    {
                        String[] ns = row.Trim().Split('=');
                        DbName = ns[1].Trim();
                    }
                    if (row.Trim().StartsWith("dbhost"))
                    {
                        String[] ns = row.Trim().Split('=');
                        DbAddr = ns[1].Trim();
                    }
                    if (row.Trim().StartsWith("dbport"))
                    {
                        String[] ns = row.Trim().Split('=');
                        DbPort = ns[1].Trim();
                    }
                    if (row.Trim().StartsWith("dbuser"))
                    {
                        String[] ns = row.Trim().Split('=');
                        DbUser = ns[1].Trim();
                    }
                    if (row.Trim().StartsWith("dbpsw"))
                    {
                        String[] ns = row.Trim().Split('=');
                        DbPasw = ns[1].Trim();
                    }
                    if (row.Trim().StartsWith("timespan"))
                    {
                        String[] ns = row.Trim().Split('=');
                        Timespan = int.Parse(ns[1].Trim());
                    }
                    if (row.Trim().IndexOf('=') < 0)
                    {
                        ItemNames.Add(row.Trim());
                    }
                }


            }
            objReader.Close();
        }
    }
}