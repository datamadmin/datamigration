package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dataeconomy.datamigration.models.metastore.AbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "RuleType_Rel", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class RuleTypeRelease implements AbstractModel {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@JsonProperty("Key")
	private RuleTypeRelease_key ruleTypeRelease_key;

	@JsonProperty("ruleType")
	private String ruleType;

	@JsonProperty("ruleTypeDesc")
	private String ruleTypeDesc;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public RuleTypeRelease() {

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

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}
}