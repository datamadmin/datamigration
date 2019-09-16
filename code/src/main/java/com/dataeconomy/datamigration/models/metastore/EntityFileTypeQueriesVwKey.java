package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class EntityFileTypeQueriesVwKey implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "entityfiletypeid")
	@JsonProperty("entityfiletypeid")
	private Integer entityFileTypeID;
	
	@Column(name = "StepID")
	@JsonProperty("StepID")
	private Integer stepID;
	
	@Column(name = "SeqOrder")
	@JsonProperty("SeqOrder")
	private Integer  seqOrder;
	
	@Column(name ="entityname")
	@JsonProperty("entityname")
	private String entityName;
	
	@Column(name ="hsfiletype")
	@JsonProperty("hsfiletype")
	private String hsFileType;
	
	@Column(name ="filemask")
	@JsonProperty("filemask")
	private String fileMask;
	
	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

	public Integer getSeqOrder() {
		return seqOrder;
	}

	public void setSeqOrder(Integer seqOrder) {
		this.seqOrder = seqOrder;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getHsFileType() {
		return hsFileType;
	}

	public void setHsFileType(String hsFileType) {
		this.hsFileType = hsFileType;
	}

	public String getFileMask() {
		return fileMask;
	}

	public void setFileMask(String fileMask) {
		this.fileMask = fileMask;
	}


}
