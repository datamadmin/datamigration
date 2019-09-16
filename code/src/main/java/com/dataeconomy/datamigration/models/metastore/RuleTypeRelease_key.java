package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class RuleTypeRelease_key implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Column(name = "RuleTypeID", nullable = false)
	@JsonProperty("RuleTypeID")
	private Integer ruleTypeID;
	
	@Column(name = "Release_Package_Id")
	@JsonProperty("Release_Package_Id")
	private String releasePackageId;

	public Integer getRuleTypeID() {
		return ruleTypeID;
	}

	public void setRuleTypeID(Integer ruleTypeID) {
		this.ruleTypeID = ruleTypeID;
	}

	public String getReleasePackageId() {
		return releasePackageId;
	}

	public void setReleasePackageId(String releasePackageId) {
		this.releasePackageId = releasePackageId;
	}
	
	
}
