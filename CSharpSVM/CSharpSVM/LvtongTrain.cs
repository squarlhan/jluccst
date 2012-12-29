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
        public List<SortedDictionary<int, int>> weights{get;set;}

        public LvtongTrain()
        {
            SqlConnection con = new SqlConnection(Properties.Settings.Default.绿通数据ConnectionString1);
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
                              ",cast([E04] as float)/100 as [E04]" +
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
                lv.ruguan = double.Parse(mDr[12].ToString());
                lv.shijiancha = int.Parse(mDr[13].ToString());
                lv.shijiancha = lv.shijiancha < 0 ? lv.shijiancha + 1440 : lv.shijiancha;
                //Console.WriteLine(lv);
                lvdata.Add(lv);

            }
            //Console.WriteLine(lvdata.Count);
            //Console.ReadLine();
            con.Close();
            
        }

        public void Load_LvData()
        {

            int nr_samples = lvdata.Count;

            Problem = new libSVM_Problem();
            Problem.samples = null;
            Problem.labels = null;

            Problem.samples = new SortedDictionary<int, double>[nr_samples];
            Problem.labels = new double[nr_samples];

            for(int i = 0;i<=nr_samples-1;i++)
            {

                SortedDictionary<int, double> sample = new SortedDictionary<int, double>();
                sample.Add(1, lvdata[i].in_M);
                sample.Add(2, lvdata[i].in_D);
                sample.Add(3, lvdata[i].in_H);
                sample.Add(4, lvdata[i].out_M);
                sample.Add(5, lvdata[i].out_D);
                sample.Add(6, lvdata[i].out_H);
                sample.Add(7, lvdata[i].jianmian);
                sample.Add(8, lvdata[i].chezhou);
                sample.Add(9, lvdata[i].chezhong);
                sample.Add(10, lvdata[i].zaihuo);
                sample.Add(11, lvdata[i].bianhao);
                sample.Add(12, lvdata[i].ruguan);
                sample.Add(13, lvdata[i].shijiancha);

                Problem.samples[i] = sample;
                Problem.labels[i] = 1;
            }

        }

        public void doTrian()
        {
            libSVM_Parameter Parameter = new libSVM_Parameter();
            svm = new libSVM();
            Parameter.svm_type = SVM_TYPE.ONE_CLASS;
            Parameter.kernel_type = KERNEL_TYPE.RBF;
            Parameter.gamma = 0.00003571;
            Parameter.nu = 0.0381;
            svm.Train(Problem, Parameter);
            //svm.TrainAuto(10, Problem, Parameter);
            //libSVM_Grid grid_c = new libSVM_Grid();
            //svm.TrainAuto(10, Problem, Parameter, grid_c, null, null, null, null, null);
            //libSVM_Grid grid_c = new libSVM_Grid();
            //libSVM_Grid grid_g = new libSVM_Grid();
            //libSVM_Grid grid_n = new libSVM_Grid();
            //svm.TrainAuto(10, Problem, Parameter, grid_c, grid_g, null, grid_n, null, null);
            int size = Problem.samples.Length;
            int wc= 0;
            for (int i = 0; i <= size - 1; i++)
            {
                if (Problem.labels[i] != svm.Predict(Problem.samples[i]))
                {
                    wc++;
                    Console.WriteLine("Wrong Prediction @" + (i + 1));
                }
            }
            Console.WriteLine(1-(double)wc/size);
        }

        public void doTrainbyWeight()
        {
            if(weights == null||weights.Count <= 0)doTrian();

        
        }
        public bool doPredictbyWeight(LvtongTrainData lv)
        {
            if (weights == null || weights.Count <= 0) doPredict(lv);

            return true;
        }

        public bool doPredict(LvtongTrainData lv)
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
            if (svm.Predict(sample)!=1)
            {
                return false;
            }
            return true;
        }

    }
}
