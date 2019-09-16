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
@Table(name = "sourcetoservicecriteria", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "sourcetoservicecriteria")
public class SourceToServiceCriteria implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonProperty("Key")
	private SourceToServiceCriteriaKey sourceToServiceCriteriaKey;

	@Column(name = "sourceentityfiletypeid", insertable = false, updatable = false)
	@JsonIgnore
	private Integer sourceEntityFileTypeID;

	@Column(name = "webserviceid", insertable = false, updatable = false)
	@JsonIgnore
	private Integer webServiceID;

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

	public SourceToServiceCriteriaKey getSourceToServiceCriteriaKey() {
		return sourceToServiceCriteriaKey;
	}

	public void setSourceToServiceCriteriaKey(SourceToServiceCriteriaKey sourceToServiceCriteriaKey) {
		this.sourceToServiceCriteriaKey = sourceToServiceCriteriaKey;
	}

}
