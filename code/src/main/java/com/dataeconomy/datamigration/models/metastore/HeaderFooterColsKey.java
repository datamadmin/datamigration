package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class HeaderFooterColsKey   implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer entityFileTypeID;
	
	@NotNull
	@JsonProperty("RecType")
	private String  recType;
	
	@JsonProperty("SeqNum")
	private Integer  seqNum;
	
	@JsonProperty("ColumnID")
	private Integer columnID;
	

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}
	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}
	public String getRecType() {
		return recType;
	}
	public void setRecType(String recType) {
		this.recType = recType;
	}
	public Integer getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}
	public Integer getColumnID() {
		return columnID;
	}
	public void setColumnID(Integer columnID) {
		this.columnID = columnID;
	}

	

	
	
}
