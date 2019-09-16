package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class SourceToServiceCriteriaVwKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "sourceentityfiletypeid")
	@JsonProperty("SourceEntityFileTypeID")
	private Integer sourceEntityFileTypeID;

	@Column(name = "webserviceid")
	@JsonProperty("WebServiceID")
	private Integer webServiceID;

	@Column(name = "entityname")
	@JsonProperty("EntityName")
	private String entityName;

	@Column(name = "hsfiletype")
	@JsonProperty("HsFileType")
	private String hsFileType;

	@Column(name = "filemask")
	@JsonProperty("FileMask")
	private String fileMask;

	// getters and setters

	

	
	public Integer getWebServiceID() {
		return webServiceID;
	}

	public Integer getSourceEntityFileTypeID() {
		return sourceEntityFileTypeID;
	}

	public void setSourceEntityFileTypeID(Integer sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		result = prime * result + ((fileMask == null) ? 0 : fileMask.hashCode());
		result = prime * result + ((hsFileType == null) ? 0 : hsFileType.hashCode());
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
		SourceToServiceCriteriaVwKey other = (SourceToServiceCriteriaVwKey) obj;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		if (fileMask == null) {
			if (other.fileMask != null)
				return false;
		} else if (!fileMask.equals(other.fileMask))
			return false;
		if (hsFileType == null) {
			if (other.hsFileType != null)
				return false;
		} else if (!hsFileType.equals(other.hsFileType))
			return false;
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
