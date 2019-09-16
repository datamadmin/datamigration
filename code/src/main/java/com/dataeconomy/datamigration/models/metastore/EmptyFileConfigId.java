package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmptyFileConfigId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@JsonProperty("EmptyFileConfigID")
	private Integer emptyFileConfigID;


	public Integer getEmptyFileConfigID() {
		return emptyFileConfigID;
	}


	public void setEmptyFileConfigID(Integer emptyFileConfigID) {
		this.emptyFileConfigID = emptyFileConfigID;
	}
	
	
	
}
