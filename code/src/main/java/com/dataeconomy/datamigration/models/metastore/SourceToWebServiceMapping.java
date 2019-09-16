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
@Table(name = "sourcetowebservicemapping", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "sourcetowebservicemapping")
public class SourceToWebServiceMapping implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonProperty("Key")
	private SourceToWebServiceMappingKey sourceToWebServiceMappingKey;
	@JsonIgnore
	@Column(name = "sourceentityfiletypeid", insertable = false, updatable = false)

	private Integer sourceEntityFileTypeID;
	@JsonIgnore
	@Column(name = "webserviceid", insertable = false, updatable = false)

	private Integer webServiceID;
	@JsonIgnore
	@Column(name = "targetcolumnid", insertable = false, updatable = false)

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
	private int targetColOrder;

	@JsonProperty("ReleaseNum")
	private int releaseNum;

	// Getters & Setters

	@XmlTransient
	public Integer getSourceEntityFileTypeID() {
		return sourceEntityFileTypeID;
	}

	public void setSourceEntityFileTypeID(Integer sourceEntityFileTypeID) {
		this.sourceEntityFileTypeID = sourceEntityFileTypeID;
	}

	@XmlTransient
	public Integer getWebServiceID() {
		return webServiceID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
	}

	@XmlTransient
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

	public int getTargetColOrder() {
		return targetColOrder;
	}

	public void setTargetColOrder(int targetColOrder) {
		this.targetColOrder = targetColOrder;
	}

	public SourceToWebServiceMappingKey getSourceToWebServiceMappingKey() {
		return sourceToWebServiceMappingKey;
	}

	public void setSourceToWebServiceMappingKey(SourceToWebServiceMappingKey sourceToWebServiceMappingKey) {
		this.sourceToWebServiceMappingKey = sourceToWebServiceMappingKey;
	}

	public int getReleaseNum() {
		return releaseNum;
	}

	public void setReleaseNum(int releaseNum) {
		this.releaseNum = releaseNum;
	}

}
