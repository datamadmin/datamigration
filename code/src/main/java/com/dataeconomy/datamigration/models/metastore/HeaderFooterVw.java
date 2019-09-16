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
@Table(name = "vheaderfooter", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@IdClass(HeaderFooterVwkey.class)
public class HeaderFooterVw implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "entityfiletypeid")
	@JsonProperty("entityFiletypeId")
	private Integer entityFileTypeId;

	@Column(name = "filemask", nullable = false)
	@JsonProperty("fileMask")
	private String fileMask;

	@Column(name = "rectype")
	@JsonProperty("recType")
	private String recType;

	@Column(name = "seqnum")
	@JsonProperty("seqnum")
	private Integer seqnum;

	@Column(name = "entityname")
	@JsonProperty("entityName")
	private String entityName;

	@Column(name = "hsfiletype")
	@JsonProperty("hsfileType")
	private String hSFileType;

	@Column(name = "headerfootertype")
	@JsonProperty("headerFooterType")
	private String headerFooterType;

	@Column(name = "filerecnum")
	@JsonProperty("fileRecNum")
	private String fileRecNum;

	@Column(name = "colcnt")
	@JsonProperty("colcnt")
	private Integer colCnt;

	@Column(name = "active")
	@JsonProperty("active")
	private String active;

	@Column(name = "effectivedate")
	@JsonProperty("effectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@Column(name = "columnswidth")
	@JsonProperty("columnsWidth")
	private Integer columnsWidth;

	@Column(name = "columnspattern")
	@JsonProperty("columnsPattern")
	private String columnsPattern;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("releaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private String comments;

	@Transient
	@JsonIgnore
	private boolean addMode;

	@Transient
	private Integer entityId;

	@Transient
	private Integer fileTypeId;

	public HeaderFooterVw(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.effectiveDate = effectiveDate;
		this.releaseNo = releaseNo;
	}

	public HeaderFooterVw() {

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

	public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}

	public Integer getSeqnum() {
		return seqnum;
	}

	public void setSeqnum(Integer seqnum) {
		this.seqnum = seqnum;
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

	public String getHeaderFooterType() {
		return headerFooterType;
	}

	public void setHeaderFooterType(String headerFooterType) {
		this.headerFooterType = headerFooterType;
	}

	public String getFileRecNum() {
		return fileRecNum;
	}

	public void setFileRecNum(String fileRecNum) {
		this.fileRecNum = fileRecNum;
	}

	public Integer getColCnt() {
		return colCnt;
	}

	public void setColCnt(Integer colCnt) {
		this.colCnt = colCnt;
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

	public Integer getColumnsWidth() {
		return columnsWidth;
	}

	public void setColumnsWidth(Integer columnsWidth) {
		this.columnsWidth = columnsWidth;
	}

	public String getColumnsPattern() {
		return columnsPattern;
	}

	public void setColumnsPattern(String columnsPattern) {
		this.columnsPattern = columnsPattern;
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

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

}
