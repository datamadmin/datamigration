package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HSFileTypeId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("FileTypeID")
	private Integer fileTypeID;

	public Integer getFileTypeID() {
		return fileTypeID;
	}

	public void setFileTypeID(Integer fileTypeID) {
		this.fileTypeID = fileTypeID;
	}
	
	

}
