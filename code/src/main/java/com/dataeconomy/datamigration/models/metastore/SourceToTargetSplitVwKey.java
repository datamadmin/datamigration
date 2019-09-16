package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class SourceToTargetSplitVwKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "sourceentityfiletypeid")
	@JsonProperty("SourceEntityFileTypeID")
	private Long sourceEntityFileTypeID;
	
	@Column(name = "sourceentityname")
	@JsonProperty("SourceEntityName")
	private String sourceEntityName;
	
	@Column(name = "sourcehsfiletype")
	@JsonProperty("SourceHsFileType")
	private String sourceHsFileType;
	
	@Column(name = "sourcefilemask")
	@JsonProperty("SourceFileMask")
	private String sourceFileMask;
	
	@Column(name = "targetentityfiletypeid")
	@JsonProperty("TargetEntityFileTypeID")
	private Long targetEntityFileTypeID;
	
	@Column(name = "targetentityname")
	@JsonProperty("TargetEntityName")
	private String targetEntityName;
	
	@Column(name = "targethsfiletype")
	@JsonProperty("TargetHsFileType")
	private String targetHsFileType;
	
	@Column(name = "targetfilemask")
	@JsonProperty("TargetFileMask")
	private String targetFileMask;

	
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

	public String getSourceEntityName() {
		return sourceEntityName;
	}

	public void setSourceEntityName(String sourceEntityName) {
		this.sourceEntityName = sourceEntityName;
	}

	public String getSourceHsFileType() {
		return sourceHsFileType;
	}

	public void setSourceHsFileType(String sourceHsFileType) {
		this.sourceHsFileType = sourceHsFileType;
	}

	public String getSourceFileMask() {
		return sourceFileMask;
	}

	public void setSourceFileMask(String sourceFileMask) {
		this.sourceFileMask = sourceFileMask;
	}

	public String getTargetEntityName() {
		return targetEntityName;
	}

	public void setTargetEntityName(String targetEntityName) {
		this.targetEntityName = targetEntityName;
	}

	public String getTargetHsFileType() {
		return targetHsFileType;
	}

	public void setTargetHsFileType(String targetHsFileType) {
		this.targetHsFileType = targetHsFileType;
	}

	public String getTargetFileMask() {
		return targetFileMask;
	}

	public void setTargetFileMask(String targetFileMask) {
		this.targetFileMask = targetFileMask;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sourceEntityFileTypeID == null) ? 0 : sourceEntityFileTypeID.hashCode());
		result = prime * result + ((sourceEntityName == null) ? 0 : sourceEntityName.hashCode());
		result = prime * result + ((sourceFileMask == null) ? 0 : sourceFileMask.hashCode());
		result = prime * result + ((sourceHsFileType == null) ? 0 : sourceHsFileType.hashCode());
		result = prime * result + ((targetEntityFileTypeID == null) ? 0 : targetEntityFileTypeID.hashCode());
		result = prime * result + ((targetEntityName == null) ? 0 : targetEntityName.hashCode());
		result = prime * result + ((targetFileMask == null) ? 0 : targetFileMask.hashCode());
		result = prime * result + ((targetHsFileType == null) ? 0 : targetHsFileType.hashCode());
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
		SourceToTargetSplitVwKey other = (SourceToTargetSplitVwKey) obj;
		if (sourceEntityFileTypeID == null) {
			if (other.sourceEntityFileTypeID != null)
				return false;
		} else if (!sourceEntityFileTypeID.equals(other.sourceEntityFileTypeID))
			return false;
		if (sourceEntityName == null) {
			if (other.sourceEntityName != null)
				return false;
		} else if (!sourceEntityName.equals(other.sourceEntityName))
			return false;
		if (sourceFileMask == null) {
			if (other.sourceFileMask != null)
				return false;
		} else if (!sourceFileMask.equals(other.sourceFileMask))
			return false;
		if (sourceHsFileType == null) {
			if (other.sourceHsFileType != null)
				return false;
		} else if (!sourceHsFileType.equals(other.sourceHsFileType))
			return false;
		if (targetEntityFileTypeID == null) {
			if (other.targetEntityFileTypeID != null)
				return false;
		} else if (!targetEntityFileTypeID.equals(other.targetEntityFileTypeID))
			return false;
		if (targetEntityName == null) {
			if (other.targetEntityName != null)
				return false;
		} else if (!targetEntityName.equals(other.targetEntityName))
			return false;
		if (targetFileMask == null) {
			if (other.targetFileMask != null)
				return false;
		} else if (!targetFileMask.equals(other.targetFileMask))
			return false;
		if (targetHsFileType == null) {
			if (other.targetHsFileType != null)
				return false;
		} else if (!targetHsFileType.equals(other.targetHsFileType))
			return false;
		return true;
	}

}
