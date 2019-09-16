package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RuleTypeId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("RuleTypeID")
	private Integer ruleTypeID;

	public Integer getRuleTypeID() {
		return ruleTypeID;
	}

	public void setRuleTypeID(Integer ruleTypeID) {
		this.ruleTypeID = ruleTypeID;
	}

	
}
