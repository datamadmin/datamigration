package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "sourcetotargetmapping_v", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class SourceToTargetMappingdb implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "InputFileMask", nullable = false)
	@JsonProperty("inputFileMask")
	private String inputFileMask;

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

	@Transient
	@JsonIgnore
	private String comments;

	public String getInputFileMask() {
		return inputFileMask;
	}

	public void setInputFileMask(String inputFileMask) {
		this.inputFileMask = inputFileMask;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
