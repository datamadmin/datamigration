package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourceToServiceCriteriaKey implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Column(name = "sourceentityfiletypeid")
	@JsonProperty("SourceEntityFileTypeID")
	private Integer sourceEntityFileTypeID;
	
	@Column(name = "webserviceid")
	@JsonProperty("WebServiceID")
	private Integer webServiceID;

	
	

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sourceEntityFileTypeID == null) ? 0 : sourceEntityFileTypeID.hashCode());
		result = prime * result + ((webServiceID == null) ? 0 : webServiceID.hashCode());
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
		SourceToServiceCriteriaKey other = (SourceToServiceCriteriaKey) obj;
		if (sourceEntityFileTypeID == null) {
			if (other.sourceEntityFileTypeID != null)
				return false;
		} else if (!sourceEntityFileTypeID.equals(other.sourceEntityFileTypeID))
			return false;
		if (webServiceID == null) {
			if (other.webServiceID != null)
				return false;
		} else if (!webServiceID.equals(other.webServiceID))
			return false;
		return true;
	}
	
	
}
