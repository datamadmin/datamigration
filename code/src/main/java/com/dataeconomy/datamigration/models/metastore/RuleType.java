package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.dataeconomy.framework.util.ExcelHeader;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ruletype", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name="ruleType")

public class RuleType implements AbstractModel {


	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ruletypeid", nullable = false)
	@JsonProperty("RuleTypeID")
	private Integer ruleTypeID;
	
	@JsonProperty("RuleType")
	private String ruleType;
	
	@JsonProperty("RuleTypeDesc")
	private String ruleTypeDesc;
	
	
	@Column(name = "releasenum", nullable = false)
	@ExcelHeader(name="ReleaseNum")
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;
	
	@Transient
	@JsonIgnore
	private boolean addMode;


	public RuleType(boolean addMode,Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo; 
	}
	
	public RuleType(){
		
	}

	public Integer getRuleTypeID() {
		return ruleTypeID;
	}

	public void setRuleTypeID(Integer ruleTypeID) {
		this.ruleTypeID = ruleTypeID;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleTypeDesc() {
		return ruleTypeDesc;
	}

	public void setRuleTypeDesc(String ruleTypeDesc) {
		this.ruleTypeDesc = ruleTypeDesc;
	}
    @XmlTransient
	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}
	
	

}
