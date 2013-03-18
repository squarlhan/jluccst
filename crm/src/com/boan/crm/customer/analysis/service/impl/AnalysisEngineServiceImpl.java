/**
 * 
 */
package com.boan.crm.customer.analysis.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.analysis.model.AnalysisCustomer;
import com.boan.crm.customer.analysis.model.AnalysisFuzzyValue;
import com.boan.crm.customer.analysis.model.AnalysisResult;
import com.boan.crm.customer.analysis.model.FuzzyCategory;
import com.boan.crm.customer.analysis.model.FuzzyInfo;
import com.boan.crm.customer.analysis.model.IdCaption;
import com.boan.crm.customer.analysis.model.RuleInfo;
import com.boan.crm.customer.analysis.service.IAnalysisEngineService;
import com.boan.crm.customer.analysis.service.IAnalysisResultService;
import com.boan.crm.customer.analysis.service.IFuzzyInfoService;
import com.boan.crm.customer.analysis.service.IFuzzyRuleInfoService;
import com.boan.crm.customer.analysis.utils.MathFunction;

/**
 * @author luojx
 *
 */
@Service("analysisEngineService")
public class AnalysisEngineServiceImpl implements IAnalysisEngineService{
	private AnalysisCustomer enter = null;
	private List<FuzzyInfo> resultList = null;
	private String companyId = "";

	@Autowired
	@Qualifier("fuzzyInfoService")
	private IFuzzyInfoService fuzzyInfoService;
	@Autowired
	@Qualifier("fuzzyRuleInfoService")
	private IFuzzyRuleInfoService fuzzyRuleInfoService;
	
	@Autowired
	@Qualifier("analysisResultService")
	private IAnalysisResultService analysisResultService;
	
	public double analysisResult()
	{
		if(enter != null)
		{
			List<AnalysisFuzzyValue> listFuzzyValue = new ArrayList<AnalysisFuzzyValue>();
			//模糊化开始
			//模糊化:消费总额
			if(enter.getTotalConsumption() != null && !enter.getTotalConsumption().equals(BigDecimal.ZERO)) //是否等于0)
			{
				double totalConsumption = Double.parseDouble(enter.getTotalConsumption().toString());
				List<FuzzyInfo> listTotalConsumption =  fuzzyInfoService.findAllFuzzyInfoByCategory(FuzzyCategory.TOTAL_CONSUMPTION,companyId);
				for(int i=0;i<listTotalConsumption.size();i++)
				{
					FuzzyInfo obj = listTotalConsumption.get(i);
					AnalysisFuzzyValue fuzzy = new AnalysisFuzzyValue();
					fuzzy.setFuzzyId(obj.getId());
					fuzzy.setId(FuzzyCategory.TOTAL_CONSUMPTION);
					fuzzy.setSugeno(obj.getSugeno());
					double fuzzyValue = 0;
					if(obj.getFunctionName().equals(MathFunction.TRIANGLE))
					{
						fuzzyValue = MathFunction.triangle(totalConsumption, obj.getFirstValue(), obj.getSecondValue(), obj.getThirdValue());
					}else if(obj.getFunctionName().equals(MathFunction.TRAPEZOID))
					{
						fuzzyValue = MathFunction.trapezoid(totalConsumption, obj.getFirstValue(), obj.getThirdValue(),obj.getFourthValue(), obj.getSecondValue());
					}
					fuzzy.setFuzzyValue(fuzzyValue);
					
					if(fuzzyValue != 0)
						listFuzzyValue.add(fuzzy);
				}
			}
			//模糊化:消费总额
			if(enter.getPayments()!= null && !enter.getPayments().equals(BigDecimal.ZERO)) //是否等于0)
			{
				double payments = Double.parseDouble(enter.getPayments().toString());
				List<FuzzyInfo> listPayments =  fuzzyInfoService.findAllFuzzyInfoByCategory(FuzzyCategory.PAYMENTS,companyId);
				for(int i=0;i<listPayments.size();i++)
				{
					FuzzyInfo obj = listPayments.get(i);
					AnalysisFuzzyValue fuzzy = new AnalysisFuzzyValue();
					fuzzy.setFuzzyId(obj.getId());
					fuzzy.setId(FuzzyCategory.PAYMENTS);
					fuzzy.setSugeno(obj.getSugeno());
					double fuzzyValue = 0;
					if(obj.getFunctionName().equals(MathFunction.TRIANGLE))
					{
						fuzzyValue = MathFunction.triangle(payments, obj.getFirstValue(), obj.getSecondValue(), obj.getThirdValue());
					}else if(obj.getFunctionName().equals(MathFunction.TRAPEZOID))
					{
						fuzzyValue = MathFunction.trapezoid(payments, obj.getFirstValue(), obj.getThirdValue(),obj.getFourthValue(), obj.getSecondValue());
					}
					fuzzy.setFuzzyValue(fuzzyValue);
					
					if(fuzzyValue != 0)
						listFuzzyValue.add(fuzzy);
				}
			}
			//模糊化:消费次数
			if(enter.getConsumptionTimes() > 0)
			{
				double consumptionTimes = Double.parseDouble(String.valueOf(enter.getConsumptionTimes()));
				List<FuzzyInfo> listConsumptionTimes =  fuzzyInfoService.findAllFuzzyInfoByCategory(FuzzyCategory.TOTAL_CONSUMPTION,companyId);
				for(int i=0;i<listConsumptionTimes.size();i++)
				{
					FuzzyInfo obj = listConsumptionTimes.get(i);
					AnalysisFuzzyValue fuzzy = new AnalysisFuzzyValue();
					fuzzy.setFuzzyId(obj.getId());
					fuzzy.setId(FuzzyCategory.CONSUMPTION_TIMERS);
					fuzzy.setSugeno(obj.getSugeno());
					double fuzzyValue = 0;
					if(obj.getFunctionName().equals(MathFunction.TRIANGLE))
					{
						fuzzyValue = MathFunction.triangle(consumptionTimes, obj.getFirstValue(), obj.getSecondValue(), obj.getThirdValue());
					}else if(obj.getFunctionName().equals(MathFunction.TRAPEZOID))
					{
						fuzzyValue = MathFunction.trapezoid(consumptionTimes, obj.getFirstValue(), obj.getThirdValue(),obj.getFourthValue(), obj.getSecondValue());
					}
					fuzzy.setFuzzyValue(fuzzyValue);
					
					if(fuzzyValue != 0)
						listFuzzyValue.add(fuzzy);
				}
			}
			//模糊化:转介绍客户数
			if(enter.getIntroduceCustomerTime() > 0)
			{
				double introduceTimes = Double.parseDouble(String.valueOf(enter.getIntroduceCustomerTime()));
				List<FuzzyInfo> listIntroduceTimes =  fuzzyInfoService.findAllFuzzyInfoByCategory(FuzzyCategory.INTRODUCE_COSTOMER,companyId);
				for(int i=0;i<listIntroduceTimes.size();i++)
				{
					FuzzyInfo obj = listIntroduceTimes.get(i);
					AnalysisFuzzyValue fuzzy = new AnalysisFuzzyValue();
					fuzzy.setFuzzyId(obj.getId());
					fuzzy.setId(FuzzyCategory.INTRODUCE_COSTOMER);
					double fuzzyValue = 0;
					fuzzy.setSugeno(obj.getSugeno());
					if(obj.getFunctionName().equals(MathFunction.TRIANGLE))
					{
						fuzzyValue = MathFunction.triangle(introduceTimes, obj.getThirdValue(), obj.getFirstValue(), obj.getSecondValue() );
					}else if(obj.getFunctionName().equals(MathFunction.TRAPEZOID))
					{
						fuzzyValue = MathFunction.trapezoid(introduceTimes, obj.getFirstValue(), obj.getThirdValue(),obj.getFourthValue(), obj.getSecondValue());
					}
					fuzzy.setFuzzyValue(fuzzyValue);
					fuzzy.setSugeno(obj.getSugeno());
					if(fuzzyValue != 0)
						listFuzzyValue.add(fuzzy);
				}
			}
			//模糊化:开发程度
			if(enter.getDevelopDegree() > 0)
			{
				double devopDegree = Double.parseDouble(String.valueOf(enter.getDevelopDegree()));
				List<FuzzyInfo> listDevopDegree =  fuzzyInfoService.findAllFuzzyInfoByCategory(FuzzyCategory.DEVOLOP_DEGREE,companyId);
				for(int i=0;i<listDevopDegree.size();i++)
				{
					FuzzyInfo obj = listDevopDegree.get(i);
					AnalysisFuzzyValue fuzzy = new AnalysisFuzzyValue();
					fuzzy.setFuzzyId(obj.getId());
					fuzzy.setId(FuzzyCategory.DEVOLOP_DEGREE);
					fuzzy.setSugeno(obj.getSugeno());
					double fuzzyValue = 0;
					if(obj.getFunctionName().equals(MathFunction.TRIANGLE))
					{
						fuzzyValue = MathFunction.triangle(devopDegree, obj.getFirstValue(), obj.getSecondValue(), obj.getThirdValue());
					}else if(obj.getFunctionName().equals(MathFunction.TRAPEZOID))
					{
						fuzzyValue = MathFunction.trapezoid(devopDegree, obj.getFirstValue(), obj.getThirdValue(),obj.getFourthValue(), obj.getSecondValue());
					}
					fuzzy.setFuzzyValue(fuzzyValue);
					
					if(fuzzyValue != 0)
						listFuzzyValue.add(fuzzy);
				}
			}
			//模糊化结束
			//对比规则
			double finalValue = 0;
			if(listFuzzyValue != null && listFuzzyValue.size() > 0)
			{
				List<IdCaption> listRule = fuzzyRuleInfoService.findAllFuzzyRuleInfo(companyId);
				
				List<AnalysisFuzzyValue> list = calculate(listFuzzyValue,listRule);
				if(list != null && list.size() > 0)
				{
					double[] fuzzyValue = new double[list.size()];
					double[] sugeno = new double[list.size()];
					
					for(int n=0;n<list.size();n++)
					{
						fuzzyValue[n] = list.get(n).getFuzzyValue();
						sugeno[n] = list.get(n).getSugeno();
					}
					
					//根据重心法取值
					finalValue = MathFunction.GravityOut(fuzzyValue, sugeno);
				}else
				{
					finalValue = 0;
				}
			}
			return finalValue;
		}
		return 0;
	}
	/**
	 * 根据计算出的值，取结论
	 * @param value
	 * @return　String
	 */
	public String getResultByValue(double value)
	{
		String result = "";
		
		//取结论
		AnalysisResult analysisResult = analysisResultService.findAnalysisResult(value);
		if(analysisResult != null)
		{
			result =  analysisResult.getResult();
		}
		return result;
	}
	/**
	 * 根据模糊化的值的模糊规则，计算结果
	 * @param listFuzzy
	 * @param listRule
	 * @return
	 */
	private List<AnalysisFuzzyValue> calculate(List<AnalysisFuzzyValue> listFuzzy,List<IdCaption> listRule)
	{
		List<AnalysisFuzzyValue> calculateResultList = new ArrayList<AnalysisFuzzyValue>();
		for(int i=0;i<listRule.size();i++)
		{
			IdCaption idCaption = listRule.get(i);
			List<RuleInfo> rulelist = (List<RuleInfo>)idCaption.getAttachObject();
			if(rulelist.size() == 1)
			{
				for(int j=0;j<listFuzzy.size();j++)
				{
					if(rulelist.get(0).getIfFuzzyId() == listFuzzy.get(j).getFuzzyId())
					{
						for(int k=0;k<resultList.size();k++)
						{
							if(resultList.get(k).getId() == rulelist.get(0).getResultFuzzyId())
							{
								listFuzzy.get(j).setSugeno(resultList.get(k).getSugeno());
								continue;
							}
						}
						calculateResultList.add(listFuzzy.get(j));
						continue;
					}
				}
			}else if(rulelist.size() > 1)
			{
				int iCount = 0;
				int iTotalCount = rulelist.size();
				
				List<AnalysisFuzzyValue> tempFuzzyList = new ArrayList<AnalysisFuzzyValue>();
				for(int j=0;j<rulelist.size();j++)
				{
					AnalysisFuzzyValue tempObj = new AnalysisFuzzyValue();
					
					for(int k=0;k<listFuzzy.size();k++)
					{
						if(rulelist.get(j).getIfFuzzyId() == listFuzzy.get(k).getFuzzyId())
						{
							tempFuzzyList.add(listFuzzy.get(k));
							iCount = iCount + 1;
							continue;
						}
					}
					if(iCount == iTotalCount)
					{
						int resultId = rulelist.get(j).getResultFuzzyId();
						for(int k=0;k<resultList.size();k++)
						{
							if(resultList.get(k).getId() == resultId)
							{
								double[] dValue = new double[tempFuzzyList.size()];
								for(int m = 0;m< dValue.length;m++)
								{
									dValue[m] = tempFuzzyList.get(m).getFuzzyValue();
								}
								double value = MathFunction.AndOperate(dValue);
								tempObj.setFuzzyId(resultList.get(k).getId());
								tempObj.setFuzzyValue(value);
								tempObj.setSugeno(resultList.get(k).getSugeno());
								calculateResultList.add(tempObj);
								continue;
							}
						}
					}
				}
				
			}
		}
		return calculateResultList;
	}

	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public AnalysisCustomer getEnter() {
		return enter;
	}

	public void setEnter(AnalysisCustomer enter) {
		this.enter = enter;
		this.companyId = enter.getCompanyId();
		resultList = fuzzyInfoService.findAllFuzzyInfoByCategory(FuzzyCategory.RESULT,companyId);
	}

	public List<FuzzyInfo> getResultList() {
		return resultList;
	}
	public void setResultList(List<FuzzyInfo> resultList) {
		this.resultList = resultList;
	}
}
