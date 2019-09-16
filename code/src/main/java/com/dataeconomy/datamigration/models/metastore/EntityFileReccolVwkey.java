package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityFileReccolVwkey implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@JsonProperty("fileMask")
	private String fileMask;

	@JsonProperty("fntityName")
	private String entityName;

	@JsonProperty("hSFileType")
	private String hSFileType;

	@JsonProperty("columnID")
	private int columnID;

	@JsonProperty("entityFileTypeID")
	private Integer entityFileTypeID;

	public String getFileMask() {
		return fileMask;
	}

	public void setFileMask(String fileMask) {
		this.fileMask = fileMask;
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

	public int getColumnID() {
		return columnID;
	}

	public void setColumnID(int columnID) {
		this.columnID = columnID;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

}
