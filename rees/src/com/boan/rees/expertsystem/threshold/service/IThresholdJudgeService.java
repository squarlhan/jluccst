/*
 * @(#)IThresholdJudge.java 1.1 2012-4-28
 */

package com.boan.rees.expertsystem.threshold.service;

/**
 * 阈值范围判断接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IThresholdJudgeService {

	/**
	 * 判断参数值是否在阈值内
	 * @param thresholdId 阈值Id
	 * @param paramValue  参数值
	 * @return true：在阈值范围内  false：不在阈值范围内 
	 */
	public boolean judgeInThresholdArea(String thresholdId,String paramValue);
	
	/**
	 * 获取超出阈值参数取值区间的 阈值参数Id
	 * @param thresholdId 阈值Id
	 * @param paramValue  参数值
	 * @return 阈值参数Id
	 */
	public String judgeNotInThresholdAreaReturnParamId(String thresholdId,String paramValue);
}

