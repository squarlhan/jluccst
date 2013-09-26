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
        //private HashSet items;

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
    }
}