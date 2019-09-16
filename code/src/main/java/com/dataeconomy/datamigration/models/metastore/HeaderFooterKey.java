package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class HeaderFooterKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "entityfiletypeid")
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;

	@Column(name = "rectype")
	@JsonProperty("RecType")
	private String recType;

	@Column(name = "seqnum")
	@JsonProperty("SeqNum")
	private Integer seqNum;
	
	

	public HeaderFooterKey() {
		super();
	}

	public HeaderFooterKey(Integer entityFileTypeID, String recType, Integer seqNum) {
		super();
		this.entityFileTypeID = entityFileTypeID;
		this.recType = recType;
		this.seqNum = seqNum;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityFileTypeID == null) ? 0 : entityFileTypeID.hashCode());
		result = prime * result + ((recType == null) ? 0 : recType.hashCode());
		result = prime * result + ((seqNum == null) ? 0 : seqNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeaderFooterKey other = (HeaderFooterKey) obj;
		if (entityFileTypeID == null) {
			if (other.entityFileTypeID != null)
				return false;
		} else if (!entityFileTypeID.equals(other.entityFileTypeID))
			return false;
		if (recType == null) {
			if (other.recType != null)
				return false;
		} else if (!recType.equals(other.recType))
			return false;
		if (seqNum == null) {
			if (other.seqNum != null)
				return false;
		} else if (!seqNum.equals(other.seqNum))
			return false;
		return true;
	}

}
