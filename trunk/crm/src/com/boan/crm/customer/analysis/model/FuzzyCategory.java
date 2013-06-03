/**
 * 
 */
package com.boan.crm.customer.analysis.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author luojx
 *
 */
public class FuzzyCategory {
	
	public static String TOTAL_CONSUMPTION = "TOTAL_CONSUMPTION";
	public static String CONSUMPTION_TIMERS = "CONSUMPTION_TIMERS";
	public static String INTRODUCE_COSTOMER = "INTRODUCE_COSTOMER";
	public static String PAYMENTS = "PAYMENTS";
	public static String DEVOLOP_DEGREE = "DEVOLOP_DEGREE";
	public static String RESULT = "RESULT";
	private static List<IdCaption> list = new ArrayList<IdCaption>();
	/**
	 * 取所有分类
	 * @return List<IdCaption>
	 */
	public static List<IdCaption> getFuzzyCatetory()
	{
		list.clear();
		IdCaption i1 = new IdCaption(TOTAL_CONSUMPTION,"消费总额");
		list.add(i1);
		IdCaption i2 = new IdCaption(CONSUMPTION_TIMERS,"消费次数");
		list.add(i2);
		IdCaption i3 = new IdCaption(INTRODUCE_COSTOMER,"转介绍客户情况");
		list.add(i3);
		IdCaption i4 = new IdCaption(DEVOLOP_DEGREE,"开发程度");
		list.add(i4);
		IdCaption i5 = new IdCaption(PAYMENTS,"回款情况");
		list.add(i5);
		IdCaption i6= new IdCaption(RESULT,"结论");
		list.add(i6);
		return list;
	}
	/**
	 * 取所有分类
	 * @return List<IdCaption>
	 */
	public static List<IdCaption> getFuzzyCatetoryNoResult()
	{
		List<IdCaption> listNoResult = new ArrayList<IdCaption>();
		IdCaption i1 = new IdCaption(TOTAL_CONSUMPTION,"消费总额");
		listNoResult.add(i1);
		IdCaption i2 = new IdCaption(CONSUMPTION_TIMERS,"消费次数");
		listNoResult.add(i2);
		IdCaption i3 = new IdCaption(INTRODUCE_COSTOMER,"转介绍客户情况");
		listNoResult.add(i3);
		IdCaption i4 = new IdCaption(DEVOLOP_DEGREE,"开发程度");
		listNoResult.add(i4);
		IdCaption i5 = new IdCaption(PAYMENTS,"回款情况");
		listNoResult.add(i5);
		return listNoResult;
	}
	
	/**
	 * 取所有分类
	 * @return List<IdCaption>
	 */
	public static List<IdCaption> getResultFuzzyCatetory()
	{
		List<IdCaption> listResult = new ArrayList<IdCaption>();
		IdCaption i6= new IdCaption(RESULT,"结论");
		listResult.add(i6);
		return listResult;
	}
	/**
	 * 根据id取类别名称
	 * @param id
	 * @return　String
	 */
	public static String getCategoryNameById(String id)
	{
		String result = "";
		list = getFuzzyCatetory();
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
		
}
