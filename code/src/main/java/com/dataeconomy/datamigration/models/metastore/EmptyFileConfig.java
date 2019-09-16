package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "EmptyFileConfig", schema = "metastore")
public class EmptyFileConfig implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EmptyFileConfigID", nullable = false)
	@JsonProperty("EmptyFileConfigID")
	private Integer emptyFileConfigID;

	@Column(name = "EntityFileTypeID")
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;

	@Column(name = "DataRecMSG")
	@JsonProperty("DataRecMSG")
	private String dataRecMSG;

	@Column(name = "Header")
	@JsonProperty("Header")
	private String header;

	@Column(name = "Footer")
	@JsonProperty("Footer")
	private String footer;

	@Column(name = "SchedulerBase")
	@JsonProperty("SchedulerBase")
	private String schedulerBase;

	@Column(name = "EntityFileTypeSchedID")
	@JsonProperty("EntityFileTypeSchedID")
	private Integer entityFileTypeSchedID;

	@Column(name = "NoInboundData")
	@JsonProperty("NoInboundData")
	private String noInboundData;

	@Column(name = "InboundFileFailure")
	@JsonProperty("InboundFileFailure")
	private String inboundFileFailure;

	@Column(name = "InboundFileThreshhold")
	@JsonProperty("InboundFileThreshhold")
	private String inboundFileThreshhold;

	@Column(name = "FileMasterInsert")
	@JsonProperty("FileMasterInsert")
	private String fileMasterInsert;

	@JsonProperty("EffectiveDate")
	@Column(name = "EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("Active")
	@Column(name = "Active")
	private String active;

	@Column(name = "ReleaseNum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private String effectiveDtstr;

	@Transient
	@JsonIgnore
	private boolean addMode;

	// getters and setters
	public EmptyFileConfig() {

	}

	public EmptyFileConfig(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
		this.effectiveDate = effectiveDate;
	}

	public Integer getEmptyFileConfigID() {
		return emptyFileConfigID;
	}

	public void setEmptyFileConfigID(Integer emptyFileConfigID) {
		this.emptyFileConfigID = emptyFileConfigID;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public String getDataRecMSG() {
		return dataRecMSG;
	}

	public void setDataRecMSG(String dataRecMSG) {
		this.dataRecMSG = dataRecMSG;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getSchedulerBase() {
		return schedulerBase;
	}

	public void setSchedulerBase(String schedulerBase) {
		this.schedulerBase = schedulerBase;
	}

	public Integer getEntityFileTypeSchedID() {
		return entityFileTypeSchedID;
	}

	public void setEntityFileTypeSchedID(Integer entityFileTypeSchedID) {
		this.entityFileTypeSchedID = entityFileTypeSchedID;
	}

	public String getNoInboundData() {
		return noInboundData;
	}

	public void setNoInboundData(String noInboundData) {
		this.noInboundData = noInboundData;
	}

	public String getInboundFileFailure() {
		return inboundFileFailure;
	}

	public void setInboundFileFailure(String inboundFileFailure) {
		this.inboundFileFailure = inboundFileFailure;
	}

	public String getInboundFileThreshhold() {
		return inboundFileThreshhold;
	}

	public void setInboundFileThreshhold(String inboundFileThreshhold) {
		this.inboundFileThreshhold = inboundFileThreshhold;
	}

	public String getFileMasterInsert() {
		return fileMasterInsert;
	}

	public void setFileMasterInsert(String fileMasterInsert) {
		this.fileMasterInsert = fileMasterInsert;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
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

	public String getEffectiveDtstr() {
		return effectiveDtstr;
	}

	public void setEffectiveDtstr(String effectiveDtstr) {
		this.effectiveDtstr = effectiveDtstr;
	}

	@XmlTransient
	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

}
