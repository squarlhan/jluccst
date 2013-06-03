/**
 * 
 */
package com.boan.crm.customer.analysis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author luojx
 *
 */
@Entity
@Table(name = "RULE_INFO")
public class RuleInfo implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2418887473669077209L;
	
	public RuleInfo(){  }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id=0;
	@Transient
	private String fuzzyCategoryName = "";
	@Column(name = "FUZZY_CATEGROY" , length = 100)
	private String fuzzyCategory = "";
	@Column(name = "RESULT_FUZZYNAME" , length = 100)
	private String resultFuzzyName = "";
	@Column(name = "RESULT_FUZZYID")
	private int resultFuzzyId = 0;
	@Column(name = "IF_FUZZYNAME" , length = 100)
	private String ifFuzzyName = "";
	@Column(name = "IF_FUZZYID")
	private int ifFuzzyId = 0;
	@Column(name = "COMPANY_ID")
	private String companyId = "";
	@Column(name = "group_ID")
	private int groupId = 0;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResultFuzzyName() {
		return resultFuzzyName;
	}
	public void setResultFuzzyName(String resultFuzzyName) {
		this.resultFuzzyName = resultFuzzyName;
	}
	public int getResultFuzzyId() {
		return resultFuzzyId;
	}
	public void setResultFuzzyId(int resultFuzzyId) {
		this.resultFuzzyId = resultFuzzyId;
	}
	public String getIfFuzzyName() {
		return ifFuzzyName;
	}
	public void setIfFuzzyName(String ifFuzzyName) {
		this.ifFuzzyName = ifFuzzyName;
	}
	public int getIfFuzzyId() {
		return ifFuzzyId;
	}
	public void setIfFuzzyId(int ifFuzzyId) {
		this.ifFuzzyId = ifFuzzyId;
	}
	public String getFuzzyCategory() {
		return fuzzyCategory;
	}
	public void setFuzzyCategory(String fuzzyCategory) {
		this.fuzzyCategory = fuzzyCategory;
	}
	public String getFuzzyCategoryName() {
		return fuzzyCategoryName;
	}
	public void setFuzzyCategoryName(String fuzzyCategoryName) {
		this.fuzzyCategoryName = fuzzyCategoryName;
	}
}
