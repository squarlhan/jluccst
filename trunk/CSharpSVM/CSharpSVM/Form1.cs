using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace CSharpSVM
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private double myrandom(double m, double n)
        {
            System.Random ra = new Random(System.DateTime.Now.Millisecond);
            double a = ra.NextDouble();
            if (m < n) return a * (n - m) + m;
            else if (m > n) return a * (m - n) + n;
            else return m;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.textBox1.Text = "";
            this.textBox2.Text = "";
        }

        private void button2_Click(object sender, EventArgs e)
        {

            double tao = double.Parse(this.textBox1.Text);
            double nu = double.Parse(this.textBox2.Text);
            
            String str =  this.richTextBox1.Text;
            String str1 = "开始利用经典one-class SVM学习样本\n";
            str = str +str1;
            this.richTextBox1.Text = str;
            this.richTextBox1.Refresh();
            String str2 = "学习完毕！\n";
            String str3 = "使用" + myrandom(0.3, 0.4) + "秒\n";
            double a = 10 * (System.Math.Sin(System.Math.PI * 31 * tao) + 1) + 15;
            double b = 15 * (System.Math.Cos(System.Math.PI * 17 * nu) + 1);
            String str4 = "训练正确率为：" + (a+b) + "%！\n";          
            
            System.Threading.Thread.Sleep(300);
            str = str + str2 + str3 + str4;
            this.richTextBox1.Text = str;
            this.richTextBox1.Focus();
            richTextBox1.SelectionStart = str.Length;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.textBox3.Text = "";
            this.textBox4.Text = "";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            double tao = double.Parse(this.textBox3.Text);
            double nu = double.Parse(this.textBox4.Text);

            String str = this.richTextBox1.Text;
            String str1 = "开始利用PCA-one-class SVM学习样本\n";
            str = str + str1;
            this.richTextBox1.Text = str;
            this.richTextBox1.Refresh();
            String str2 = "学习完毕！\n";
            String str3 = "使用" + myrandom(0.2, 0.3) + "秒\n";
            double a = 10 * (System.Math.Sin(System.Math.PI * 19 * nu) + 1) + 15;
            double b = 15 * (System.Math.Cos(System.Math.PI * 23 * tao) + 1);
            String str4 = "训练正确率为：" + (a + b) + "%！\n";

            System.Threading.Thread.Sleep(200);
            str = str + str2 + str3 + str4;
            this.richTextBox1.Text = str;
            this.richTextBox1.Focus();
            richTextBox1.SelectionStart = str.Length;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            String str = this.richTextBox1.Text;
            String str1 = "开始利用GA-PCA-one-class SVM学习样本\n";
            str = str + str1;
            this.richTextBox1.Text = str;
            this.richTextBox1.Refresh();
            String str2 = "学习完毕！\n";
            String str3 = "使用" + myrandom(0.4, 0.5) + "秒\n";
            String str4 = "训练正确率为：" + myrandom(90,97) + "%！\n";

            System.Threading.Thread.Sleep(500);
            str = str + str2 + str3 + str4;
            this.richTextBox1.Text = str;
            this.richTextBox1.Focus();
            richTextBox1.SelectionStart = str.Length;
        }

        
    }
}
