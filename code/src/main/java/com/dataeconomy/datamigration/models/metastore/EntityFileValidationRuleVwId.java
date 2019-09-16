package com.dataeconomy.datamigration.models.metastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityFileValidationRuleVwId {
	
	@JsonProperty("efvrid")
	private Integer efvrid;

	public Integer getEfvrid() {
		return efvrid;
	}

	public void setEfvrid(Integer efvrid) {
		this.efvrid = efvrid;
	}
	
	
}
