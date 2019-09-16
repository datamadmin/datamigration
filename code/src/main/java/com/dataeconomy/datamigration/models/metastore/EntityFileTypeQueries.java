package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "entityfiletypequeries", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityfiletypequeries")
public class EntityFileTypeQueries implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonProperty("Key")
	private EntityFileTypeQueriesKey entityFileTypeQueriesKey;

	@Column(name = "entityfiletypeid", insertable = false, updatable = false)
	@JsonIgnore
	private Integer entityFileTypeID;

	@Column(name = "stepid", insertable = false, updatable = false)
	@JsonIgnore
	private Integer stepID;

	@Column(name = "seqorder", insertable = false, updatable = false)
	@JsonIgnore
	private Integer seqOrder;

	@JsonProperty("QueryText")
	private String queryText;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public EntityFileTypeQueries(Integer releaseNo, boolean addMode) {
		this.releaseNo = releaseNo;
		this.addMode = addMode;
	}

	public EntityFileTypeQueries() {

	}

	// Getters & Setters

	public EntityFileTypeQueriesKey getEntityFileTypeQueriesKey() {
		return entityFileTypeQueriesKey;
	}

	public void setEntityFileTypeQueriesKey(EntityFileTypeQueriesKey entityFileTypeQueriesKey) {
		this.entityFileTypeQueriesKey = entityFileTypeQueriesKey;
	}

	@XmlTransient
	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	@XmlTransient
	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

	@XmlTransient
	public Integer getSeqOrder() {
		return seqOrder;
	}

	public void setSeqOrder(Integer seqOrder) {
		this.seqOrder = seqOrder;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
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

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	@XmlTransient
	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

}
