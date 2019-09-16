package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityFileTypeScheduleXrefId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("EntityFileTypeSchedID")
	private Integer  entityFileTypeSchedID;

	public Integer getEntityFileTypeSchedID() {
		return entityFileTypeSchedID;
	}

	public void setEntityFileTypeSchedID(Integer entityFileTypeSchedID) {
		this.entityFileTypeSchedID = entityFileTypeSchedID;
	}
	
	
}
