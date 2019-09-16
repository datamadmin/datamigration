package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class SourceToWebServiceMappingVwKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "entityname")
	@JsonProperty("EntityName")
	private String entityName;

	@Column(name = "hsfiletype")
	@JsonProperty("HSFileType")
	private String hSFileType;

	@Column(name = "filemask")
	@JsonProperty("FileMask")
	private String fileMask;

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

	public String gethSFileType() {
		return hSFileType;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public void sethSFileType(String hSFileType) {
		this.hSFileType = hSFileType;
	}

	public String getFileMask() {
		return fileMask;
	}

	public void setFileMask(String fileMask) {
		this.fileMask = fileMask;
	}

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
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		result = prime * result + ((fileMask == null) ? 0 : fileMask.hashCode());
		result = prime * result + ((hSFileType == null) ? 0 : hSFileType.hashCode());
		result = prime * result + ((sourceEntityFileTypeID == null) ? 0 : sourceEntityFileTypeID.hashCode());
		result = prime * result + ((targetColumnID == null) ? 0 : targetColumnID.hashCode());
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
		SourceToWebServiceMappingVwKey other = (SourceToWebServiceMappingVwKey) obj;
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
		if (hSFileType == null) {
			if (other.hSFileType != null)
				return false;
		} else if (!hSFileType.equals(other.hSFileType))
			return false;
		if (sourceEntityFileTypeID == null) {
			if (other.sourceEntityFileTypeID != null)
				return false;
		} else if (!sourceEntityFileTypeID.equals(other.sourceEntityFileTypeID))
			return false;
		if (targetColumnID == null) {
			if (other.targetColumnID != null)
				return false;
		} else if (!targetColumnID.equals(other.targetColumnID))
			return false;
		if (webServiceID == null) {
			if (other.webServiceID != null)
				return false;
		} else if (!webServiceID.equals(other.webServiceID))
			return false;
		return true;
	}

}
