package cn.edu.jlu.ccst.service;

import java.io.BufferedReader;
/**
 * 推理机服务类
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.jlu.ccst.model.Backward;
import cn.edu.jlu.ccst.model.BackwardandReason;
import cn.edu.jlu.ccst.model.BackwardandResult;
@Component("inferenceEngine")
public class InferenceEngine {
	 /**
	    *输入现象列表
	    */
	private  List<BackwardandResult> enter;
	/**
    *原因列表
    */
	private  List<BackwardandReason> process;
	/**
    *规则列表
    */
	private  List<Backward> backwardrule;
	/**
    *输出现象列表
    */
	private  List<BackwardandReason> ending;
	

	public List<BackwardandReason> getEnding() {
		return ending;
	}
	@Resource
	public void setEnding(List<BackwardandReason> ending) {
		this.ending = ending;
	}

	public List<BackwardandResult> getEnter() {
		return enter;
	}
	@Resource
	public void setEnter(List<BackwardandResult> enter) {
		this.enter = enter;
	}

	public List<BackwardandReason> getProcess() {
		return process;
	}
	@Resource
	public void setProcess(List<BackwardandReason> process) {
		this.process = process;
	}

	public List<Backward> getBackwardrule() {
		return backwardrule;
	}
	@Resource
	public void setBackwardrule(List<Backward> backwardrule) {
		this.backwardrule = backwardrule;
	}

	public static void main(String[] args) {
		
//		ie.Inference("result to reason","fulfill");
//		Inference("result to reason","step");

	}
	/**
    *推理过程主函数：选择推理方式进行推理
    *@param rule 推理规则
    *@param way 推理方式
    */
	public  void Inference(String rule,String way){
	ending = new ArrayList();
		String temp;
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader bufin = new BufferedReader(stdin);
		while(step(rule))
		{
			if(way.equals("step")){
				//System.out.print("按\"Enter\"键下一步");
				try{
					temp = bufin.readLine();
				}
				catch (IOException E){
					//System.out.println("发生I/O错误!!! ");
				}
			}
		}
	}
	/**
    *单步推理过程：查找规则库进行规则匹配
    *@param rule 要匹配规则
    */
	public  boolean step(String rule){
		//System.out.println("--------------------");
		int count = 0;
		boolean flag = false;
		if(rule.equals("reason to result")){
			//反向推理暂时不用实现
		}
		if(rule.equals("result to reason")){
			//for(int i=0;i<=bs.length-1;i++)
			for(int i=0;i<=backwardrule.size()-1;i++)
            {
				count = 0;
				//for(int k=0;k<=bs[i].getResults().size()-1;k++)
				for(int k=0;k<=backwardrule.get(i).getResults().size()-1;k++)
	            {
					for(int j=0;j<=process.size()-1;j++)
					{
						//boolean flag1 = bs[i].getResults().get(k).getNouns().equals(process.get(j).getNouns());
						//boolean flag2 = bs[i].getResults().get(k).getVerb().equals(process.get(j).getVerb());
						boolean flag1 = backwardrule.get(i).getResults().get(k).getNouns().equals(process.get(j).getNouns());
						boolean flag2 = backwardrule.get(i).getResults().get(k).getVerb().equals(process.get(j).getVerb());
						if(flag1&&flag2)
						{
							count++;
							break;
						}
					}
	            }
				//if (count == bs[i].getResults().size())
				if (count == backwardrule.get(i).getResults().size())
                {
					boolean isadd = true;
				    //for(int k=0;k<=bs[i].getReasons().size()-1;k++)
					for(int k=0;k<=backwardrule.get(i).getReasons().size()-1;k++)
		            {
						isadd = true;
						for(int j=0;j<=process.size()-1;j++)
						{
							//boolean flag1 = bs[i].getReasons().get(k).getNouns().equals(process.get(j).getNouns());
							//boolean flag2 = bs[i].getReasons().get(k).getVerb().equals(process.get(j).getVerb());
							boolean flag1 = backwardrule.get(i).getReasons().get(k).getNouns().equals(process.get(j).getNouns());
							boolean flag2 = backwardrule.get(i).getReasons().get(k).getVerb().equals(process.get(j).getVerb());
							if(flag1&&flag2){
								isadd = false;
								break;
							}
						}
						if(isadd==true){
							BackwardandReason newreason = new BackwardandReason();
							//newreason.setCf_reason(bs[i].getReasons().get(k).getCf_reason());
							//newreason.setNouns(bs[i].getReasons().get(k).getNouns());
							//newreason.setVerb(bs[i].getReasons().get(k).getVerb());
							//newreason.setSugg(bs[i].getReasons().get(k).getSugg());
							newreason.setCf_reason(backwardrule.get(i).getReasons().get(k).getCf_reason());
							newreason.setNouns(backwardrule.get(i).getReasons().get(k).getNouns());
							newreason.setVerb(backwardrule.get(i).getReasons().get(k).getVerb());
							newreason.setSugg(backwardrule.get(i).getReasons().get(k).getSugg());
							process.add(newreason);
							ending.add(newreason);
							//System.out.println("推出：");
							//System.out.println("名词："+bs[i].getReasons().get(k).getNouns()+"  动词："+bs[i].getReasons().get(k).getVerb());
							/*System.out.println("名词："+backwardrule.get(i).getReasons().get(k).getNouns()
									+"  动词："+backwardrule.get(i).getReasons().get(k).getVerb()
									+"  建议："+backwardrule.get(i).getReasons().get(k).getSugg());*/
							flag = true;
							return true;
						}
		            }
                }
            }
		}
		//System.out.println("推理结束！");
		return flag;
	}
}
