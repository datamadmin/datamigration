package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class SourceToWebServiceMappingKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "sourceentityfiletypeid")
	@JsonProperty("SourceEntityFileTypeID")
	private Integer sourceEntityFileTypeID;
	
	@Column(name = "webserviceid")
	@JsonProperty("WebServiceID")
	private Integer webServiceID;
	
	@Column(name = "targetcolumnid")
	@JsonProperty("TargetColumnID")
	private Integer targetColumnID;
	
	// getters and setters

	public Integer getSourceEntityFileTypeID() {
		return sourceEntityFileTypeID;
	}

	public void setSourceEntityFileTypeID(Integer sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
	}

	public Integer getWebServiceID() {
		return webServiceID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
	}

	public Integer getTargetColumnID() {
		return targetColumnID;
	}

	public void setTargetColumnID(Integer targetColumnID) {
		this.targetColumnID = targetColumnID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sourceEntityFileTypeID;
		result = prime * result + targetColumnID;
		result = prime * result + webServiceID;
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
		SourceToWebServiceMappingKey other = (SourceToWebServiceMappingKey) obj;
		if (sourceEntityFileTypeID != other.sourceEntityFileTypeID)
			return false;
		if (targetColumnID != other.targetColumnID)
			return false;
		if (webServiceID != other.webServiceID)
			return false;
		return true;
	}

}
