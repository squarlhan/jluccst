/*
 * @(#)IThresholdJudge.java 1.1 2012-4-28
 */

package com.boan.rees.expertsystem.threshold.service;

/**
 * 阈值范围判断接口
 * @author leon
 * @version 1.0.0
 */
public interface IThresholdJudgeService {

	/**
	 * 判断参数值是否在指定的阈值区间
	 * @param expression 表达式（10<x<20）
	 * @param paramValue 监测点参数数据
	 * @return
	 */
	public boolean judgeInThresholdArea(String expression, double paramValue);
	
	/**
	 * 判断参数值是否在警告的阈值区间
	 * @param expression 表达式（10<x<20）
	 * @param paramValue 监测点参数数据
	 * @return
	 */
	public boolean judgeInAlarmArea(String expression, double paramValue);
}

