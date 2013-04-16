using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;

namespace CSharpSVM
{
    class LvtongTrainNew
    {
        public DataSet lvds { get; set; }
        public List<LvtongTrainData> lvdata { get; set; }
        public libSVM_Problem Problem { get; set; }
        public libSVM svm { get; set; }
        libSVM_Parameter Parameter { get; set; }
        public SortedDictionary<int, int> weights { get; set; }
        public SortedDictionary<String, int> zaihuomap { get; set; }

        /// <summary>
        /// 把定义的数据结构类转化成SVM需要的类型
        /// </summary>
        /// <param name="lv">输入的自定义数据结构</param>
        /// <returns>输出SVM要求的数据结构</returns>
        public SortedDictionary<int, double> toSample(LvtongTrainData lv)
        {
            SortedDictionary<int, double> sample = new SortedDictionary<int, double>();
            sample.Add(1, lv.in_M);
            sample.Add(2, lv.in_D);
            sample.Add(3, lv.in_H);
            sample.Add(4, lv.out_M);
            sample.Add(5, lv.out_D);
            sample.Add(6, lv.out_H);
            sample.Add(7, lv.jianmian);
            sample.Add(8, lv.chezhou);
            sample.Add(9, lv.chezhong);

            string[] zaihuos = lv.zaihuo.Split(',');
            int[] zaihuoint = new int[10];
            for (int i = 0; i <= 9; i++)
            {
                if (i <= zaihuos.Length - 1)
                {
                    zaihuoint[i] = zaihuomap[zaihuos[i]];
                }
                else
                {
                    zaihuoint[i] = 0;
                }
            }

            sample.Add(10, zaihuoint[0]);
            sample.Add(11, zaihuoint[1]);
            sample.Add(12, zaihuoint[2]);
            sample.Add(13, zaihuoint[3]);
            sample.Add(14, zaihuoint[4]);
            sample.Add(15, zaihuoint[5]);
            sample.Add(16, zaihuoint[6]);
            sample.Add(17, zaihuoint[7]);
            sample.Add(18, zaihuoint[8]);
            sample.Add(19, zaihuoint[9]);
            sample.Add(20, lv.bianhao);
            sample.Add(21, lv.ruguan);
            sample.Add(22, lv.shijiancha);
            return sample;
        }
        /// <summary>
        /// 构造方法设置一些SVM的参数
        /// </summary>
        public LvtongTrainNew()
        {

            Parameter = new libSVM_Parameter();
            svm = new libSVM();
            Problem = new libSVM_Problem();

            this.zaihuo2bno();
            Parameter.svm_type = SVM_TYPE.ONE_CLASS;
            Parameter.kernel_type = KERNEL_TYPE.RBF;
            Parameter.gamma = 0.00003571;
            Parameter.nu = 0.0381;

        }
        private SortedDictionary<String, int> zaihuo2bno()
        {
            const string FILE_NAME = "zaihuo.txt";
            zaihuomap = new SortedDictionary<String, int>();

            if (!File.Exists(FILE_NAME))
            {
                Console.WriteLine("{0} does not exist.", FILE_NAME);
                return null;
            }

            using (StreamReader sr = File.OpenText(FILE_NAME))
            {
                String line;
                while ((line = sr.ReadLine()) != null)
                {
                    String[] lines = line.Split(',');
                    if (lines.Length == 2)
                    {
                        zaihuomap.Add(lines[1].Trim(), int.Parse(lines[0].Trim()));
                    }
                }
                //Console.WriteLine("The end of the stream has been reached.");
                sr.Close();
            }
            return zaihuomap;
        }
        /// <summary>
        /// 把数据从数据库读出来,对应于第一版的数据库
        /// </summary>
        public void read_db_data_new()
        {
            SqlConnection con = new SqlConnection(Properties.Settings.Default.LTConnectionString);
            if (con.State == ConnectionState.Closed)
                con.Open();
            String str = "SELECT distinct " +
                              " [Number]" +
                              ", [InTime]" +
                              ", [OutTime]" +
                              ", [ReduceMoney]" +
                              ", [AxleCount]" +
                              ", [Weight]" +
                              ", [Cargo]" +
                              ", [TollCollector]" +
                              ", [InStation]" +
                              ", datediff(minute,[InTime], [OutTime]) as [Duation]" +
                          "FROM [LT].[dbo].[AccessRecord] where [AxleCount]<=6";
            SqlCommand cmd = new SqlCommand(str, con);
            SqlDataAdapter adp = new SqlDataAdapter(cmd);
            lvds = new DataSet();
            adp.Fill(lvds);

            lvdata = new List<LvtongTrainData>();
            foreach (DataRow mDr in lvds.Tables[0].Rows)
            {
                //foreach (DataColumn mDc in lvds.Tables[0].Columns)
                //{
                //    Console.Write(mDr[mDc].ToString() + "\t");
                //}
                //Console.WriteLine();
                LvtongTrainData lv = new LvtongTrainData();
                if (mDr[1].ToString().Trim().Length < 1)
                {
                    continue;
                }
                DateTime intime = DateTime.Parse(mDr[1].ToString());
                DateTime outtime = DateTime.Parse(mDr[2].ToString());
                lv.in_M = intime.Month;
                lv.in_D = intime.Day;
                lv.in_H = intime.Hour;
                lv.out_M = outtime.Month;
                lv.out_D = outtime.Day;
                lv.out_H = outtime.Hour;
                lv.jianmian = double.Parse(mDr[3].ToString());
                lv.chezhou = int.Parse(mDr[4].ToString());
                lv.chezhong = double.Parse(mDr[5].ToString());
                lv.zaihuo = mDr[6].ToString().Trim();
                String bh = mDr[7].ToString().Trim();
                if (bh != null && bh.Length > 2)
                {
                    lv.bianhao = int.Parse(bh.Substring(bh.Length-3));
                }
                else
                {
                    lv.bianhao = 0;
                }
                
                if (Char.IsNumber(mDr[8].ToString(), 2))
                {
                    lv.ruguan = double.Parse(mDr[8].ToString());
                }
                else
                {
                    lv.ruguan = double.Parse(mDr[8].ToString().Substring(0, 2)) * 10;
                }
                lv.ruguan = lv.ruguan / 100;
                lv.shijiancha = int.Parse(mDr[9].ToString());
                lv.shijiancha = lv.shijiancha < 0 ? lv.shijiancha + 1440 : lv.shijiancha;
                //Console.WriteLine(lv);
                lvdata.Add(lv);

            }
            //Console.WriteLine(lvdata.Count);
            //Console.ReadLine();
            con.Close();
        }
        /// <summary>
        /// 把数据转化成SVM训练需要的数据格式
        /// </summary>
        public void Load_LvData()
        {

            int nr_samples = lvdata.Count;

            Problem.samples = null;
            Problem.labels = null;

            Problem.samples = new SortedDictionary<int, double>[nr_samples];
            Problem.labels = new double[nr_samples];

            for (int i = 0; i <= nr_samples - 1; i++)
            {

                SortedDictionary<int, double> sample = toSample(lvdata[i]);
                Problem.samples[i] = sample;
                Problem.labels[i] = 1;
            }

        }
        /// <summary>
        /// 把加权的数据转化成SVM训练需要的数据
        /// </summary>
        public void Load_WightedLvData()
        {

            int nr_samples = lvdata.Count;

            Problem.samples = null;
            Problem.labels = null;

            Problem.samples = new SortedDictionary<int, double>[nr_samples];
            Problem.labels = new double[nr_samples];

            for (int i = 0; i <= nr_samples - 1; i++)
            {

                SortedDictionary<int, double> sample = toWeightedSample(lvdata[i]);
                Problem.samples[i] = sample;
                Problem.labels[i] = 1;
            }

        }
        /// <summary>
        /// 训练SVM，产生一个模型文件lv_model_file
        /// </summary>
        public void doTrian()
        {
            svm.Train(Problem, Parameter);
            //svm.TrainAuto(10, Problem, Parameter);
            //libSVM_Grid grid_c = new libSVM_Grid();
            //svm.TrainAuto(10, Problem, Parameter, grid_c, null, null, null, null, null);
            //libSVM_Grid grid_c = new libSVM_Grid();
            //libSVM_Grid grid_g = new libSVM_Grid();
            //libSVM_Grid grid_n = new libSVM_Grid();
            //svm.TrainAuto(10, Problem, Parameter, grid_c, grid_g, null, grid_n, null, null);
            //int size = Problem.samples.Length;
            //int wc= 0;
            //for (int i = 0; i <= size - 1; i++)
            //{
            //    if (Problem.labels[i] != svm.Predict(Problem.samples[i]))
            //    {
            //        wc++;
            //        Console.WriteLine("Wrong Prediction @" + (i + 1));
            //    }
            //}
            //Console.WriteLine(1-(double)wc/size);
            Console.WriteLine("train Accuracy is " + svm.GetAccuracy(Problem));
            svm.Save("lv_model_file");
        }

        /// <summary>
        /// 通过加载已存在的模型文件，初始化SVM
        /// </summary>
        /// <param name="filename"></param>
        public void reloadSVM(String filename)
        {
            svm.Reload("lv_model_file");
        }
        /// <summary>
        /// 通过模型来预测
        /// </summary>
        /// <param name="lv">输入的数据</param>
        /// <returns>返回是否为绿通车辆</returns>
        public bool doPredict(LvtongTrainData lv)
        {
            SortedDictionary<int, double> sample = toSample(lv);
            if (svm.Predict(sample) != 1)
            {
                return false;
            }
            return true;
        }
        /// <summary>
        /// 把加权的自定义的数据结构转化成SVM训练需要的格式
        /// </summary>
        /// <param name="lv">自定义数据结构的数据</param>
        /// <returns>SVM训练需要的格式数据</returns>
        private SortedDictionary<int, double> toWeightedSample(LvtongTrainData lv)
        {
            SortedDictionary<int, double> ws = toSample(lv);
            int isize = ws.Count;
            if (weights == null || weights.Count <= 0) return ws;
            int wsize = weights.Count;
            foreach (KeyValuePair<int, int> kvp in weights)
            {
                if (kvp.Key >= 1 && kvp.Key <= isize)
                {
                    for (int i = 0; i <= kvp.Value - 2; i++)
                    {
                        ws.Add(ws.Count + 1, ws[kvp.Key]);

                    }
                }
            }

            return ws;

        }

        /// <summary>
        /// 预测加权的数据的结果
        /// </summary>
        /// <param name="lv">输入的数据</param>
        /// <returns>是否为绿通车辆</returns>
        public bool doPredictbyWeight(LvtongTrainData lv)
        {
            if (weights == null || weights.Count <= 0) doPredict(lv);
            SortedDictionary<int, double> sample = toWeightedSample(lv);
            if (svm.Predict(sample) != 1)
            {
                return false;
            }
            return true;
        }

    }
}
