package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileFormatId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("FileFormatID")
	private Integer fileFormatID;

	public Integer getFileFormatID() {
		return fileFormatID;
	}

	public void setFileFormatID(Integer fileFormatID) {
		this.fileFormatID = fileFormatID;
	}
	
	
}
