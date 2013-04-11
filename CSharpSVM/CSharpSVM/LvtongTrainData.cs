using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CSharpSVM
{
    class LvtongTrainData
    {
        //车牌号分解
        public int chepai1 { get; set; }
        public int chepai2 { get; set; }
        public int chepai3 { get; set; }
        public int chepai4 { get; set; }
        public int chepai5 { get; set; }
        public int chepai6 { get; set; }
        public int chepai7 { get; set; }
        //入关的月日小时
        public int in_M{ get; set; }
        public int in_D{ get; set; }
        public int in_H{ get; set; }
        //出关的月日小时
        public int out_M{ get; set; }
        public int out_D{ get; set; }
        public int out_H{ get; set; }
        //减免金额
        public double jianmian{ get; set; }
        //车轴数
        public int chezhou{ get; set; }
        //车重
        public double chezhong{ get; set; }
        //货物类型
        public string zaihuo { get; set; }
        //收费员编号
        public int bianhao{ get; set; }
        //入关网点
        public double ruguan{ get; set; }
        //运行时间
        public int shijiancha{ get; set; }

        public LvtongTrainData()
        {
             
        }

        public override string ToString()
        {
            double rg = ruguan * 100;
            return "入关" + in_M + "月" + in_D + "日" + in_H + "点," +
                "出关" + out_M + "月" + out_D + "日" + out_H + "点," +
                "可减免" + jianmian + "元," + "车轴数为" + chezhou +
                "车重为" + chezhong + "吨," + "货物类型为" + zaihuo +
                "等,收费员编号为" + bianhao + ",入关网点为" + rg +
                ",运行时间为" + shijiancha + "分钟";
        }
        

    }
}
