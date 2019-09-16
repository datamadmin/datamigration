package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityFileTypeXrefId implements Serializable{
	

	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}
	
	
}
