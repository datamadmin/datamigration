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
@Table(name = "vheaderfootercol", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@IdClass(HeaderFooterColVwKey.class)
public class HeaderFooterColsVw implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "entityfiletypeid")
	@JsonProperty("entityFileTypeID")
	private Integer entityFileTypeId;

	@Column(name = "filemask", nullable = false)
	@JsonProperty("fileMask")
	private String fileMask;

	@JsonProperty("entityName")
	private String entityName;

	@JsonProperty("hSFileType")
	private String hSFileType;

	@JsonProperty("recType")
	private String recType;

	@JsonProperty("seqNum")
	private Integer seqNum;

	@JsonProperty("columnID")
	private Integer columnID;

	@JsonProperty("columnName")
	private String columnName;

	@JsonProperty("active")
	private String active;

	@JsonProperty("effectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("releaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private String comments;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public HeaderFooterColsVw(boolean addMode, LocalDate effctiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.effectiveDate = effctiveDate;
		this.releaseNo = releaseNo;

	}

	public HeaderFooterColsVw() {

	}

	public Integer getEntityFileTypeId() {
		return entityFileTypeId;
	}

	public void setEntityFileTypeId(Integer entityFileTypeId) {
		this.entityFileTypeId = entityFileTypeId;
	}

	public String getFileMask() {
		return fileMask;
	}

	public void setFileMask(String fileMask) {
		this.fileMask = fileMask;
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

	public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	public Integer getColumnID() {
		return columnID;
	}

	public void setColumnID(Integer columnID) {
		this.columnID = columnID;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
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

}
