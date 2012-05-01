/*
 * @(#)ThresholdJudgeImpl.java 1.1 2012-4-28
 */

package com.boan.rees.expertsystem.threshold.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.threshold.service.IThresholdJudgeService;

/**
 * 阈值范围判断接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Service("thresholdJudgeService")
public class ThresholdJudgeServiceImpl implements IThresholdJudgeService {

	/**
	 * 判断参数数据是否在表达式范围内
	 * @param expression
	 * @param paramValue
	 * @return
	 */
	public boolean compare(String expression, double paramValue) {
		//返回结果
		boolean result = false;
		if(StringUtils.trimToNull(expression)!=null){
			String[] expressionSplit = expression.split("<");
			if(paramValue>Double.parseDouble(expressionSplit[0]) && paramValue< Double.parseDouble(expressionSplit[2])){
				result = true;
			}else{
				result = false;
			}
		}
		return result;
	}

	@Override
	public boolean judgeInThresholdArea(String expression, double paramValue) {
		return this.compare(expression, paramValue);
	}

	@Override
	public boolean judgeInAlarmArea(String expression, double paramValue) {
		boolean result = false;
		if(this.compare(expression, paramValue))
			result = true;
		else{
			//需要判断是否大于最小的警告阈值
			if(StringUtils.trimToNull(expression)!=null){
				String[] expressionSplit = expression.split("<");
				if(paramValue>Double.parseDouble(expressionSplit[0])){
					result = true;
				}else{
					result = false;
				}
			}
		}
		return false;
	}
}

