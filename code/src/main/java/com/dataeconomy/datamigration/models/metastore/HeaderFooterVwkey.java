
package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeaderFooterVwkey implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@JsonProperty("filemask")
	private String fileMask;

	@JsonProperty("entityname")
	private String entityName;

	@JsonProperty("hsfiletype")
	private String hSFileType;

	@JsonProperty("rectype")
	private String recType;

	@JsonProperty("seqnum")
	private int seqnum;

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

	public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}

	public int getSeqnum() {
		return seqnum;
	}

	public void setSeqnum(int seqnum) {
		this.seqnum = seqnum;
	}

}
