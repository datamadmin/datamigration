package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "sourcetotargetmapping", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "sourceToTargetMapping")
public class SourceToTargetMapping implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonProperty("Key")
	private SourceToTargetMappingKey sourceToTargetMappingKey;

	@Column(name = "sourceentityfiletypeid", insertable = false, updatable = false)
	@JsonIgnore
	private int sourceEntityFileTypeID;

	@Column(name = "targetentityfiletypeid", insertable = false, updatable = false)
	@JsonIgnore
	private int targetEntityFileTypeID;

	@Column(name = "targetcolumnid", insertable = false, updatable = false)
	@JsonIgnore
	private int targetColumnID;

	@JsonProperty("sourceEntityID")
	private Integer sourceEntityID;

	@JsonProperty("sourceFileTypeID")
	private Integer sourceFileTypeID;

	@JsonProperty("targetEntityID")
	private Integer targetEntityID;

	@JsonProperty("targetFileTypeID")
	private Integer targetFileTypeID;

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

	public SourceToTargetMappingKey getSourceToTargetMappingKey() {
		return sourceToTargetMappingKey;
	}

	public void setSourceToTargetMappingKey(SourceToTargetMappingKey sourceToTargetMappingKey) {
		this.sourceToTargetMappingKey = sourceToTargetMappingKey;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	@XmlTransient
	public int getSourceEntityFileTypeID() {
		return this.sourceEntityFileTypeID;
	}

	public void setSourceEntityFileTypeID(int sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
	}

	@XmlTransient
	public int getTargetEntityFileTypeID() {
		return targetEntityFileTypeID;
	}

	public void setTargetEntityFileTypeID(int targetEntityFileTypeID) {
		this.targetEntityFileTypeID = targetEntityFileTypeID;
	}

	@XmlTransient
	public int getTargetColumnID() {
		return targetColumnID;
	}

	public void setTargetColumnID(int targetColumnID) {
		this.targetColumnID = targetColumnID;
	}

}
