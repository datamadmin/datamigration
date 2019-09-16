package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class SourceToTargetMappingKey implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "sourceentityfiletypeid")
	@JsonProperty("SourceEntityFileTypeID")
	private int sourceEntityFileTypeID;
	
	@Column(name = "targetentityfiletypeid")
	@JsonProperty("TargetEntityFileTypeID")
	private int targetEntityFileTypeID;
	
	@Column(name = "targetcolumnid")
	@JsonProperty("TargetColumnID")
	private int targetColumnID;
	
	public int getSourceEntityFileTypeID() {
		return sourceEntityFileTypeID;
	}
	public void setSourceEntityFileTypeID(int sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
	}
	public int getTargetEntityFileTypeID() {
		return targetEntityFileTypeID;
	}
	public void setTargetEntityFileTypeID(int targetEntityFileTypeID) {
		this.targetEntityFileTypeID = targetEntityFileTypeID;
	}
	public int getTargetColumnID() {
		return targetColumnID;
	}
	public void setTargetColumnID(int targetColumnID) {
		this.targetColumnID = targetColumnID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sourceEntityFileTypeID;
		result = prime * result + targetColumnID;
		result = prime * result + targetEntityFileTypeID;
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
		SourceToTargetMappingKey other = (SourceToTargetMappingKey) obj;
		if (sourceEntityFileTypeID != other.sourceEntityFileTypeID)
			return false;
		if (targetColumnID != other.targetColumnID)
			return false;
		if (targetEntityFileTypeID != other.targetEntityFileTypeID)
			return false;
		return true;
	}
	
	

}
