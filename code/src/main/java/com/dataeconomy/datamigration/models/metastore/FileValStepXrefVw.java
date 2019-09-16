package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "vfilevalstepxref", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@IdClass(FileValStepVwkey.class)
public class FileValStepXrefVw implements AbstractModel{
	private static final long serialVersionUID = 1L;
	
	@Transient
	@JsonIgnore
	private Integer ftvsxrid;
	
	@JsonProperty("EntityName")
	private String entityName;
	
	@JsonProperty("FileType")
	private String fileType;
	
	@JsonProperty("FileMask")
	private String fileMask;
	
	@JsonProperty("StepName")
	private String stepName;
	
	@Column(name = "steporder")
	@JsonProperty("stepOrder")
	private Integer stepOrder;
	
	@Id
	@Column(name = "stepid")
	@JsonProperty("stepID")
	private Integer stepId;
	
	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;
	
	@Transient
	@JsonIgnore
	private boolean addMode;
	
	
	public FileValStepXrefVw(boolean addMode,Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
	}
	
	public FileValStepXrefVw() {
		
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

	public Integer getFtvsxrid() {
		return ftvsxrid;
	}
	
	public void setFtvsxrid(Integer ftvsxrid) {
		this.ftvsxrid = ftvsxrid;
	}
	
	
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileMask() {
		return fileMask;
	}

	public void setFileMask(String fileMask) {
		this.fileMask = fileMask;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public Integer getStepOrder() {
		return stepOrder;
	}

	public void setStepOrder(Integer stepOrder) {
		this.stepOrder = stepOrder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}
	
	
	
}
