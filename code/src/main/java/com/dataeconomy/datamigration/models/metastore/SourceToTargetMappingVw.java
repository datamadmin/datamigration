package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "vsourcetotargetmapping", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@IdClass(SourceToTargetVwKey.class)
public class SourceToTargetMappingVw implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "inputfilemask", nullable = false)
	@JsonProperty("inputFileMask")
	private String inputFileMask;

	@JsonProperty("sourceEntityFileTypeID")
	private Integer sourceEntityFileTypeID;

	@JsonProperty("targetEntityFileTypeID")
	private Integer targetEntityFileTypeID;

	@JsonProperty("entityName")
	private String entityName;

	@JsonProperty("hSFileType")
	private String hSFileType;

	@JsonProperty("targetEntityFileMask")
	private String targetEntityFileMask;

	@JsonProperty("targetEntityName")
	private String targetEntityName;

	@JsonProperty("columnID")
	private Integer columnID;

	@JsonProperty("mapFunction")
	private String mapFunction;

	@JsonProperty("active")
	private String active;

	@JsonProperty("effectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("targetColOrder")
	private Integer targetColOrder;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("releaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private String comments;

	@Transient
	@JsonIgnore
	private boolean addMode;

	@Transient
	@JsonProperty("sourceEntityID")
	private Integer sourceEntityID;

	@Transient
	@JsonProperty("sourceFileTypeID")
	private Integer sourceFileTypeID;

	@Transient
	@JsonProperty("targetEntityID")
	private Integer targetEntityID;

	@Transient
	@JsonProperty("targetFileTypeID")
	private Integer targetFileTypeID;

	public SourceToTargetMappingVw(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.effectiveDate = effectiveDate;
		this.addMode = addMode;
		this.releaseNo = releaseNo;
	}

	public SourceToTargetMappingVw() {
	}

	public String getInputFileMask() {
		return inputFileMask;
	}

	public void setInputFileMask(String inputFileMask) {
		this.inputFileMask = inputFileMask;
	}

	public Integer getSourceEntityFileTypeID() {
		return sourceEntityFileTypeID;
	}

	public void setSourceEntityFileTypeID(Integer sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
	}

	public Integer getTargetEntityFileTypeID() {
		return targetEntityFileTypeID;
	}

	public void setTargetEntityFileTypeID(Integer targetEntityFileTypeID) {
		this.targetEntityFileTypeID = targetEntityFileTypeID;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String gethSFileType() {
		return hSFileType;
	}

	public void sethSFileType(String hSFileType) {
		this.hSFileType = hSFileType;
	}

	public String getTargetEntityFileMask() {
		return targetEntityFileMask;
	}

	public void setTargetEntityFileMask(String targetEntityFileMask) {
		this.targetEntityFileMask = targetEntityFileMask;
	}

	public String getTargetEntityName() {
		return targetEntityName;
	}

	public void setTargetEntityName(String targetEntityName) {
		this.targetEntityName = targetEntityName;
	}

	public Integer getColumnID() {
		return columnID;
	}

	public void setColumnID(Integer columnID) {
		this.columnID = columnID;
	}

	public String getMapFunction() {
		return mapFunction;
	}

	public void setMapFunction(String mapFunction) {
		this.mapFunction = mapFunction;
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

	public Integer getTargetColOrder() {
		return targetColOrder;
	}

	public void setTargetColOrder(Integer targetColOrder) {
		this.targetColOrder = targetColOrder;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public Integer getSourceEntityID() {
		return sourceEntityID;
	}

	public void setSourceEntityID(Integer sourceEntityID) {
		this.sourceEntityID = sourceEntityID;
	}

	public Integer getSourceFileTypeID() {
		return sourceFileTypeID;
	}

	public void setSourceFileTypeID(Integer sourceFileTypeID) {
		this.sourceFileTypeID = sourceFileTypeID;
	}

	public Integer getTargetEntityID() {
		return targetEntityID;
	}

	public void setTargetEntityID(Integer targetEntityID) {
		this.targetEntityID = targetEntityID;
	}

	public Integer getTargetFileTypeID() {
		return targetFileTypeID;
	}

	public void setTargetFileTypeID(Integer targetFileTypeID) {
		this.targetFileTypeID = targetFileTypeID;
	}

}
