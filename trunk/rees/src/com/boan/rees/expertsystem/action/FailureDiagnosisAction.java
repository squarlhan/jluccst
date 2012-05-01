/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)FailureDiagnosisAction.java 1.1 May 1, 2012
 */
package com.boan.rees.expertsystem.action;

import org.springframework.stereotype.Controller;

import com.boan.rees.utils.action.BaseActionSupport;

/**
 * 故障诊断类
 * @author XXX
 * @version 1.1, May 1, 2012
 */
@Controller("failureDiagnosisAction")
public class FailureDiagnosisAction extends BaseActionSupport
{

	
	/**
	 * 显示故障诊断的查询页面
	 * @return
	 */
	public String showFailureDiagnosisInfo()
	{
		return "show-failure-diagnosis-info";
	}
	
	/**
	 * 显示故障诊断的结果建议页面
	 * @return
	 */
	public String showFailureDiagnosisResult()
	{
		return "show-failure-diagnosis-result";
	}
}

