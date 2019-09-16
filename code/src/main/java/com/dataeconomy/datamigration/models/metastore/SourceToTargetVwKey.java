package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceToTargetVwKey implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@JsonProperty("inputFileMask")
	private String inputFileMask;

	@JsonProperty("entityName")
	private String entityName;

	@JsonProperty("hSFileType")
	private String hSFileType;

	@JsonProperty("targetEntityFileMask")
	private String targetEntityFileMask;

	@JsonProperty("targetEntityName")
	private String targetEntityName;

	@JsonProperty("columnID")
	private Integer columnID;

	public String getInputFileMask() {
		return inputFileMask;
	}

	public void setInputFileMask(String inputFileMask) {
		this.inputFileMask = inputFileMask;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String gethSFileType() {
		return hSFileType;
	}

	public void sethSFileType(String hSFileType) {
		this.hSFileType = hSFileType;
	}

	public String getTargetEntityFileMask() {
		return targetEntityFileMask;
	}

	public void setTargetEntityFileMask(String targetEntityFileMask) {
		this.targetEntityFileMask = targetEntityFileMask;
	}

	public String getTargetEntityName() {
		return targetEntityName;
	}

	public void setTargetEntityName(String targetEntityName) {
		this.targetEntityName = targetEntityName;
	}

	public Integer getColumnID() {
		return columnID;
	}

	public void setColumnID(Integer columnID) {
		this.columnID = columnID;
	}

}
