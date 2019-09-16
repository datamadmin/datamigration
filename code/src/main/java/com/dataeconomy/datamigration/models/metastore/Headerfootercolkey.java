package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class Headerfootercolkey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "EntityFileTypeID")
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeId;
	
	@Column(name = "RecType")
	@JsonProperty("RecType")
	private String recType;
	
	@Column(name = "SeqNum")
	@JsonProperty("SeqNum")
	private Integer seqNum;
	
	@Column(name = "ColumnID")
	@JsonProperty("ColumnID")
	private Integer columnID;

	public Integer getEntityFileTypeId() {
		return entityFileTypeId;
	}

	public void setEntityFileTypeId(Integer entityFileTypeId) {
		this.entityFileTypeId = entityFileTypeId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columnID == null) ? 0 : columnID.hashCode());
		result = prime * result + ((entityFileTypeId == null) ? 0 : entityFileTypeId.hashCode());
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
		Headerfootercolkey other = (Headerfootercolkey) obj;
		if (columnID == null) {
			if (other.columnID != null)
				return false;
		} else if (!columnID.equals(other.columnID))
			return false;
		if (entityFileTypeId == null) {
			if (other.entityFileTypeId != null)
				return false;
		} else if (!entityFileTypeId.equals(other.entityFileTypeId))
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
