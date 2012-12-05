package com.boan.crm.utils.strategy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.cfg.DefaultNamingStrategy;


/**
 *     sessionFactory 中添加一个这个属性
 * 		<property name="namingStrategy"> 
			<bean class="com.boan.crm.utils.strategy.ProvinceCustomerTableNamingStrategy" /> 
		</property> 
 */

/**
 * @author YF
 *
 */
public class ProvinceCustomerTableNamingStrategy extends DefaultNamingStrategy {

	private static final long serialVersionUID = 1L;   
	  
	public static final ProvinceCustomerTableNamingStrategy INSTANCE = new ProvinceCustomerTableNamingStrategy();   
    private static final DecimalFormat df = new DecimalFormat();   
    private static ArrayList<String> rollingTables = new ArrayList<String>();   
    static {   
        rollingTables.add("TIME_PLAN");   //那些表需要动态创建
        df.applyPattern("00");   
    }
    
	@Override
	public String tableName(String tableName) {
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBb");
		 String stroeTable = tableName;   
	        // 对指定的表名计算月表的实际存储表名   
	        if (rollingTables.contains(tableName.toUpperCase())) {   
	            stroeTable += "_" + df.format(Calendar.getInstance().get(Calendar.YEAR) % 100)   + df.format(Calendar.getInstance().get(Calendar.MONTH) + 1);   
	            System.out.println("store record into [" + stroeTable + "]");   
	        }   
	  
	        return stroeTable;   

	}

}
