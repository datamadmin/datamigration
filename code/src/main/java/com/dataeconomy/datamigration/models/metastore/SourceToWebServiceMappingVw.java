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
@Table(name = "sourcetowebservicemapping_v", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate

public class SourceToWebServiceMappingVw implements AbstractModel {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private SourceToWebServiceMappingVwKey sourceToWebServiceMappingVwKey;

	@Column(name = "webserviceid", insertable = false, updatable = false)
	@JsonProperty("WebServiceID")
	private Integer webServiceID;

	@Column(name = "entityname", insertable = false, updatable = false)
	@JsonProperty("EntityName")
	private String entityName;

	@Column(name = "hsfiletype", insertable = false, updatable = false)
	@JsonProperty("HsFileType")
	private String hsFileType;

	@Column(name = "filemask", insertable = false, updatable = false)
	@JsonProperty("FileMask")
	private String fileMask;

	@Column(name = "sourceentityfiletypeid", insertable = false, updatable = false)
	@JsonProperty("SourceEntityFileTypeID")
	private Integer sourceEntityFileTypeID;

	@Column(name = "targetcolumnid", insertable = false, updatable = false)
	@JsonProperty("TargetColumnID")
	private Integer targetColumnID;

	@JsonProperty("MapFunction")
	private String mapFunction;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("TargetColOrder")
	private Integer targetColOrder;

	@JsonProperty("ReleaseNum")
	private Integer releaseNum;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public SourceToWebServiceMappingVw() {

	}

	public SourceToWebServiceMappingVw(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.effectiveDate = effectiveDate;
		this.addMode = addMode;
		this.releaseNum = releaseNo;
	}

	// getters/setters

	public Integer getWebServiceID() {
		return webServiceID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
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

	public Integer getSourceEntityFileTypeID() {
		return sourceEntityFileTypeID;
	}

	public void setSourceEntityFileTypeID(Integer sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
	}

	public Integer getTargetColumnID() {
		return targetColumnID;
	}

	public void setTargetColumnID(Integer targetColumnID) {
		this.targetColumnID = targetColumnID;
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

	public Integer getReleaseNum() {
		return releaseNum;
	}

	public void setReleaseNum(Integer releaseNum) {
		this.releaseNum = releaseNum;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public SourceToWebServiceMappingVwKey getSourceToWebServiceMappingVwKey() {
		return sourceToWebServiceMappingVwKey;
	}

	public void setSourceToWebServiceMappingVwKey(SourceToWebServiceMappingVwKey sourceToWebServiceMappingVwKey) {
		this.sourceToWebServiceMappingVwKey = sourceToWebServiceMappingVwKey;
	}

}
