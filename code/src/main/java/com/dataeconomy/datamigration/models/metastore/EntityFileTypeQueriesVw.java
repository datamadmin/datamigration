package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "vEntityFileTypeQueries", schema = "metastore")
public class EntityFileTypeQueriesVw implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonProperty("Key")
	private EntityFileTypeQueriesVwKey entityFileTypeQueriesVwKey;

	@Column(name = "entityfiletypeid", insertable = false, updatable = false, nullable = false)
	@JsonProperty("entityfiletypeid")
	private Integer entityFileTypeID;

	@Column(name = "stepid", insertable = false, updatable = false, nullable = false)
	@JsonProperty("StepID")
	private Integer stepID;

	@Column(name = "seqorder", insertable = false, updatable = false, nullable = false)
	@JsonProperty("SeqOrder")
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

	@Column(name = "entityname", insertable = false, updatable = false)
	@JsonProperty("entityname")
	private String entityName;

	@Column(name = "hsfiletype", insertable = false, updatable = false)
	@JsonProperty("hsfiletype")
	private String hsFileType;

	@Column(name = "filemask", insertable = false, updatable = false)
	@JsonProperty("filemask")
	private String fileMask;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public EntityFileTypeQueriesVw() {

	}

	public EntityFileTypeQueriesVw(LocalDate effectiveDate, Integer releaseNo, boolean addMode) {
		super();
		this.effectiveDate = effectiveDate;
		this.releaseNo = releaseNo;
		this.addMode = addMode;
	}

	// Getters & Setters

	@XmlTransient
	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

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

	public String getEntityName() {
		return entityName;
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

	public EntityFileTypeQueriesVwKey getEntityFileTypeQueriesVwKey() {
		return entityFileTypeQueriesVwKey;
	}

	public void setEntityFileTypeQueriesVwKey(EntityFileTypeQueriesVwKey entityFileTypeQueriesVwKey) {
		this.entityFileTypeQueriesVwKey = entityFileTypeQueriesVwKey;
	}

}
