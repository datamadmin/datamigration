package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "vSourceToTargetSplit", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class SourceToTargetSplitVw implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SourceToTargetSplitVwKey sourceToTargetSplitVwKey;

	@Column(name = "sourceentityfiletypeid", insertable = false, updatable = false)
	@JsonProperty("SourceEntityFileTypeID")
	private Long sourceEntityFileTypeID;

	@Column(name = "sourceentityname", insertable = false, updatable = false)
	@JsonProperty("SourceEntityName")
	private String sourceEntityName;

	@Column(name = "sourcehsfiletype", insertable = false, updatable = false)
	@JsonProperty("SourceHsFileType")
	private String sourceHsFileType;

	@Column(name = "sourcefilemask", insertable = false, updatable = false)
	@JsonProperty("SourceFileMask")
	private String sourceFileMask;

	@Column(name = "targetentityfiletypeid", insertable = false, updatable = false)
	@JsonProperty("TargetEntityFileTypeID")
	private Long targetEntityFileTypeID;

	@Column(name = "targetentityname", insertable = false, updatable = false)
	@JsonProperty("TargetEntityName")
	private String targetEntityName;

	@Column(name = "targethsfiletype", insertable = false, updatable = false)
	@JsonProperty("TargetHsFileType")
	private String targetHsFileType;

	@Column(name = "targetfilemask", insertable = false, updatable = false)
	@JsonProperty("TargetFileMask")
	private String targetFileMask;

	@JsonProperty("SplitCriteria")
	private String splitCriteria;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("ReleaseNum")
	private Integer releaseNum;

	@Transient
	@JsonIgnore
	private boolean addMode;

	@Transient
	@JsonIgnore
	private String effectiveDtstring;

	public SourceToTargetSplitVw() {

	}

	public SourceToTargetSplitVw(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.effectiveDate = effectiveDate;
		this.addMode = addMode;
		this.releaseNum = releaseNo;
	}

	// getters and setters

	public Long getSourceEntityFileTypeID() {
		return sourceEntityFileTypeID;
	}

	public void setSourceEntityFileTypeID(Long sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
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

	public Long getTargetEntityFileTypeID() {
		return targetEntityFileTypeID;
	}

	public void setTargetEntityFileTypeID(Long targetEntityFileTypeID) {
		this.targetEntityFileTypeID = targetEntityFileTypeID;
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

	public String getSplitCriteria() {
		return splitCriteria;
	}

	public void setSplitCriteria(String splitCriteria) {
		this.splitCriteria = splitCriteria;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Integer getReleaseNum() {
		return releaseNum;
	}

	public void setReleaseNum(Integer releaseNum) {
		this.releaseNum = releaseNum;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public String getEffectiveDtstring() {
		return effectiveDtstring;
	}

	public void setEffectiveDtstring(String effectiveDtstring) {
		this.effectiveDtstring = effectiveDtstring;
	}

	public SourceToTargetSplitVwKey getSourceToTargetSplitVwKey() {
		return sourceToTargetSplitVwKey;
	}

	public void setSourceToTargetSplitVwKey(SourceToTargetSplitVwKey sourceToTargetSplitVwKey) {
		this.sourceToTargetSplitVwKey = sourceToTargetSplitVwKey;
	}

}
