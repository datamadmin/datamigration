package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class SourceToTargetSplitKey implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "sourceentityfiletypeid")
	@JsonProperty("SourceEntityFileTypeID")
	private Long sourceEntityFileTypeID;
	
	@Column(name = "targetentityfiletypeid")
	@JsonProperty("TargetEntityFileTypeID")
	private Long targetEntityFileTypeID;

	public Long getSourceEntityFileTypeID() {
		return sourceEntityFileTypeID;
	}

	public void setSourceEntityFileTypeID(Long sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
	}

	public Long getTargetEntityFileTypeID() {
		return targetEntityFileTypeID;
	}

	public void setTargetEntityFileTypeID(Long targetEntityFileTypeID) {
		this.targetEntityFileTypeID = targetEntityFileTypeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sourceEntityFileTypeID == null) ? 0 : sourceEntityFileTypeID.hashCode());
		result = prime * result + ((targetEntityFileTypeID == null) ? 0 : targetEntityFileTypeID.hashCode());
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
		SourceToTargetSplitKey other = (SourceToTargetSplitKey) obj;
		if (sourceEntityFileTypeID == null) {
			if (other.sourceEntityFileTypeID != null)
				return false;
		} else if (!sourceEntityFileTypeID.equals(other.sourceEntityFileTypeID))
			return false;
		if (targetEntityFileTypeID == null) {
			if (other.targetEntityFileTypeID != null)
				return false;
		} else if (!targetEntityFileTypeID.equals(other.targetEntityFileTypeID))
			return false;
		return true;
	}

}
