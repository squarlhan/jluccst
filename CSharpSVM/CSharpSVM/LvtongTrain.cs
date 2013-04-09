using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data;
using System.Data.SqlClient;

namespace CSharpSVM
{
    class LvtongTrain
    {
        public DataSet lvds { get; set; }
        public List<LvtongTrainData> lvdata { get; set; }
        public libSVM_Problem Problem { get; set; }
        public libSVM svm{get; set;}
        libSVM_Parameter Parameter { get; set; }
        public SortedDictionary<int, int> weights{get;set;}
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
                sample.Add(10, lv.zaihuo);
                sample.Add(11, lv.bianhao);
                sample.Add(12, lv.ruguan);
                sample.Add(13, lv.shijiancha);
            return sample;
        }
        /// <summary>
        /// 构造方法，把数据从数据库读出来，并设置一些SVM的参数
        /// </summary>
        public LvtongTrain()
        {
            SqlConnection con = new SqlConnection(Properties.Settings.Default.绿通数据ConnectionString);
            if (con.State == ConnectionState.Closed)
                con.Open();
            String str = "SELECT distinct " +
                              " [E01]" +
                              ",substring(convert(char(10),[E02],108),6,2) as [E02-M]" +
                              ",substring(convert(char(10),[E02],108),9,2) as [E02-D]" +
                              ",substring(convert(char(10),[E03],108),1,2) as [E03-H]" +
                              ",substring(convert(char(10),[E05],108),6,2) as [E05-M]" +
                              ",substring(convert(char(10),[E05],108),9,2) as [E05-D]" +
                              ",substring(convert(char(10),[E06],108),1,2) as [E06-H]" +
                              ",[E07]" +
                              ",[E09]" +
                              ",[E10]" +
                              ",[E11]" +
                              ",substring([E15],5,2) as [E15-2]" +
                              ",[E04]" +
                              ",datediff(minute,[E03], [E06]) as [E63]" +
                          "FROM [绿通数据].[dbo].[通关车辆信息表] where E09<=6 and [e11] not like '%,%' and [e11]!='4'";
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
                lv.in_M = int.Parse(mDr[1].ToString());
                lv.in_D = int.Parse(mDr[2].ToString());
                lv.in_H = int.Parse(mDr[3].ToString());
                lv.out_M = int.Parse(mDr[4].ToString());
                lv.out_D = int.Parse(mDr[5].ToString());
                lv.out_H = int.Parse(mDr[6].ToString());
                lv.jianmian = double.Parse(mDr[7].ToString());
                lv.chezhou = int.Parse(mDr[8].ToString());
                lv.chezhong = double.Parse(mDr[9].ToString());
                lv.zaihuo = int.Parse(mDr[10].ToString());
                lv.bianhao = int.Parse(mDr[11].ToString());
                if (Char.IsNumber(mDr[12].ToString(), 2))
                {
                    lv.ruguan = double.Parse(mDr[12].ToString());
                }
                else 
                {
                    lv.ruguan = double.Parse(mDr[12].ToString().Substring(0, 2))*10; 
                }
                lv.ruguan = lv.ruguan / 100;
                lv.shijiancha = int.Parse(mDr[13].ToString());
                lv.shijiancha = lv.shijiancha < 0 ? lv.shijiancha + 1440 : lv.shijiancha;
                //Console.WriteLine(lv);
                lvdata.Add(lv);

            }
            //Console.WriteLine(lvdata.Count);
            //Console.ReadLine();
            con.Close();

            Parameter = new libSVM_Parameter();
            svm = new libSVM();
            Problem = new libSVM_Problem();

            Parameter.svm_type = SVM_TYPE.ONE_CLASS;
            Parameter.kernel_type = KERNEL_TYPE.RBF;
            Parameter.gamma = 0.00003571;
            Parameter.nu = 0.0381;

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

            for(int i = 0;i<=nr_samples-1;i++)
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
            Console.WriteLine("train Accuracy is "+svm.GetAccuracy(Problem));
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
            if (svm.Predict(sample)!=1)
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
            SortedDictionary<int, double> ws= toSample(lv);
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
