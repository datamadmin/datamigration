package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ventityfiletypeschedulexref", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class EntityFileTypeScheduleXrefVw implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@JsonProperty("entityFileTypeSchedID")
	private Integer entityFileTypeSchedID;

	@JsonProperty("entityname")
	private String entityName;

	@JsonProperty("entityfiletypeid")
	private Integer entityfiletypeid;

	@JsonProperty("hsfiletype")
	private String hSFileType;

	@JsonProperty("filemask")
	private String fileMask;

	@JsonProperty("scheduleFequencyType")
	private String scheduleFequencyType;

	@JsonProperty("schFrequencyValue")
	private Integer schFrequencyValue;

	@JsonProperty("scheduleOffsetType")
	private String scheduleOffsetType;

	@JsonProperty("scheduleOffsetValue")
	private Integer scheduleOffsetValue;

	@JsonProperty("fileDirection")
	private String fileDirection;

	@JsonProperty("active")
	private String active;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("releaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private boolean addMode;

	@Transient
	private Integer entityId;

	@Transient
	private Integer fileTypeId;

	public EntityFileTypeScheduleXrefVw() {

	}

	public EntityFileTypeScheduleXrefVw(boolean addMode, Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
	}

	public Integer getEntityFileTypeSchedID() {
		return entityFileTypeSchedID;
	}

	public void setEntityFileTypeSchedID(Integer entityFileTypeSchedID) {
		this.entityFileTypeSchedID = entityFileTypeSchedID;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Integer getEntityfiletypeid() {
		return entityfiletypeid;
	}

	public void setEntityfiletypeid(Integer entityfiletypeid) {
		this.entityfiletypeid = entityfiletypeid;
	}

	public String gethSFileType() {
		return hSFileType;
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

	public String getScheduleFequencyType() {
		return scheduleFequencyType;
	}

	public void setScheduleFequencyType(String scheduleFequencyType) {
		this.scheduleFequencyType = scheduleFequencyType;
	}

	public Integer getSchFrequencyValue() {
		return schFrequencyValue;
	}

	public void setSchFrequencyValue(Integer schFrequencyValue) {
		this.schFrequencyValue = schFrequencyValue;
	}

	public String getScheduleOffsetType() {
		return scheduleOffsetType;
	}

	public void setScheduleOffsetType(String scheduleOffsetType) {
		this.scheduleOffsetType = scheduleOffsetType;
	}

	public Integer getScheduleOffsetValue() {
		return scheduleOffsetValue;
	}

	public void setScheduleOffsetValue(Integer scheduleOffsetValue) {
		this.scheduleOffsetValue = scheduleOffsetValue;
	}

	public String getFileDirection() {
		return fileDirection;
	}

	public void setFileDirection(String fileDirection) {
		this.fileDirection = fileDirection;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

}
