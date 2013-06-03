/**
 * 
 */
package com.boan.crm.customer.analysis.utils;

import java.util.ArrayList;
import java.util.List;

import com.boan.crm.customer.analysis.model.IdCaption;

/**
 * @author luojx
 *　数学函数操作
 */
public class MathFunction {
	
	public static String SIGMOID = "SIGMOID";
	public static String TRIANGLE = "TRIANGLE";
	public static String TRAPEZOID = "TRAPEZOID";
	public static String DISTRIBUTE = "DISTRIBUTE";
	private static List<IdCaption> list = new ArrayList<IdCaption>();
	public MathFunction (){}
	
	public static List<IdCaption> getFuzzyFunction()
	{
		//IdCaption i1 = new IdCaption(SIGMOID,"SIGMOID形隶属度函数");
		//list.add(i1);
		list.clear();
		IdCaption i2 = new IdCaption(TRIANGLE,"三角形隶属度函数");
		list.add(i2);
		IdCaption i3 = new IdCaption(TRAPEZOID,"梯形隶属度函数");
		list.add(i3);
		//IdCaption i4 = new IdCaption(DISTRIBUTE,"正态形隶属度函数");
		//list.add(i4);
		return list;
	}
	/**
	 * 根据id取类别名称
	 * @param id
	 * @return　String
	 */
	public static String getFunctionNameById(String id)
	{
		String result = "";
		for(int i=0;i<list.size();i++)
		{
			IdCaption obj = list.get(i);
			if(obj.getId().equals(id))
			{
				result = obj.getCaption();
			}
		}
		return result;
	}
	/**
	 * sigmoid形
	 * @param x
	 * 输入数据
	 * @return
	 * sigmoid形隶属度
	 */
    public static double sigmoid(double x)
    {
        return (double)(1 / (1 + Math.exp(-x)));
    }
    /**
     * 三角函数,0,b,a,c
     * @param x
     * 输入数据
     * @param a
     * 输入参数
     * @param b
     * 输入参数
     * @param c
     * 输入参数
     * @return
     * 三角形隶属度
     */
    public static double triangle(double x, double a, double b, double c)
    {
        if (x >= b && x <= a)
        {
            return (x - b) / (a - b);
        }
        else if (x > a && x <= c)
        {
            return (c - x) / (c - a);
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * 梯形函数,x,a,b,c,d
     * @param x
     * 输入数据
     * @param a
     * 输入参数
     * @param b
     * 输入参数
     * @param c
     * 输入参数
     * @param d
     * 输入参数
     * @return
     * 梯形隶属度
     */
    public static double trapezoid(double x, double a, double b, double c, double d)
    {
        if (x >= a && x <= b)
        {
            return (x - a) / (b - a);
        }
        else if (x > b && x <= c)
        {
            return 1;
        }
        else if (x > c && x <= d)
        {
            return (d - x) / (d - c);
        }
        else
        {
            return 0;
        }
    }
    
   
    /**
     * 正态形0,a,b>0,a为平均数 b为标准差
     * @param x
     * 输入数据
     * @param a
     * 输入参数
     * @param b
     * 输入参数
     * @return
     * 正态形隶属度
     */
    public static double distribute(double x, double a, double b)
    {
        return (double)(Math.exp(-((x - a) / b) * ((x - a) / b)));
    }
    
    /**
     * Sugeno-style 输出
     * @param u 
     * 输入参数
     * @param k
     * 输入参数
     * @return
     * Sugeno-style 输出值
     */
    public static double SugenoOut(double[] u, double[] k)
    {
        double u1, k1;
        u1 = 0;
        k1 = 0;
        for (int i = 0; i < u.length; i++)
        {
            u1 = u1 + u[i] * k[i];

            k1 = k1 + u[i];
        }

        return u1 / k1;
    }
    /**
     * Gravity-style 输出 ,重心法
     * @param u
     * 输入参数
     * @param k
     * 输入参数
     * @return
     * Gravity-style 输出值
     */
    public static double GravityOut(double[] u, double[] k)
    {
        double u1, k1;
        u1 = 0;
        k1 = 0;
        for (int i = 0; i < u.length; i++)
        {
            u1 = u1 + u[i] * k[i];

            k1 = k1 + u[i];
        }
        return u1 / k1;
    }
    /**
     * 与操作输出
     * @param x
     * 输入数据
     * @return
     * Sugeno-AndOperate 输出值
     */
    public static double AndOperate(double[] x)
    {
        double u1;
        u1 = 0;
        u1 = x[0];
        for (int i = 0; i < x.length; i++)
        {
            if (i != x.length - 1)
            {
                if (u1 >= x[i + 1])
                {
                    u1 = x[i + 1];
                }
            }
        }
        return u1;
    }
}
