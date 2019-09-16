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
@Table(name = "vsourcetoservicecriteria", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class SourceToServiceCriteriaVw implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SourceToServiceCriteriaVwKey sourceToServiceCriteriaVwKey;

	@Column(name = "webserviceid", insertable = false, updatable = false)
	@JsonProperty("WebServiceID")
	private Integer webServiceId;

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

	@JsonProperty("Criteria")
	private String criteria;

	@JsonProperty("SeqOrder")
	private Integer seqOrder;

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

	public SourceToServiceCriteriaVw() {

	}

	public SourceToServiceCriteriaVw(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.effectiveDate = effectiveDate;
		this.addMode = addMode;
		this.releaseNum = releaseNo;
	}

	public SourceToServiceCriteriaVwKey getSourceToServiceCriteriaVwKey() {
		return sourceToServiceCriteriaVwKey;
	}

	public void setSourceToServiceCriteriaVwKey(SourceToServiceCriteriaVwKey sourceToServiceCriteriaVwKey) {
		this.sourceToServiceCriteriaVwKey = sourceToServiceCriteriaVwKey;
	}
	// getters and setters

	public String getEntityName() {
		return entityName;
	}

	public Integer getWebServiceId() {
		return webServiceId;
	}

	public void setWebServiceId(Integer webServiceId) {
		this.webServiceId = webServiceId;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
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

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Integer getSeqOrder() {
		return seqOrder;
	}

	public void setSeqOrder(Integer seqOrder) {
		this.seqOrder = seqOrder;
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

}
