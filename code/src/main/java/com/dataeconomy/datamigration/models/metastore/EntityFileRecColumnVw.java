package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "ventityfilereccol", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@IdClass(EntityFileReccolVwkey.class)
public class EntityFileRecColumnVw implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("fileMask")
	private String fileMask;

	@Id
	@JsonProperty("entityName")
	private String entityName;

	@Id
	@JsonProperty("hSFileType")
	private String hSFileType;

	@Id
	@Column(name = "columnid", nullable = false)
	@JsonProperty("columnID")
	private Integer columnID;

	@Id
	@JsonProperty("entityFileTypeID")
	private Integer entityFileTypeID;

	@JsonProperty("colName")
	private String colName;

	@JsonProperty("dataType")
	private String dataType;

	@JsonProperty("colLength")
	private Integer colLength;

	@JsonProperty("startPosition")
	private Integer startPosition;

	@JsonProperty("allowValue")
	private String allowValue;

	@JsonProperty("active")
	private String active;

	@Transient
	@JsonIgnore
	private String comments;

	@Transient
	@JsonIgnore
	private String wmc;

	@Transient
	@JsonIgnore
	private String rfc;

	@JsonProperty("effectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("colMask")
	private String colMask;

	@Transient
	@JsonIgnore
	private boolean addMode;

	@Column(name = "releasenum")
	@JsonProperty("releaseNum")
	private Integer releaseNo;

	@Column(name = "includeinrpt")
	@JsonProperty("includeInRpt")
	@Type(type = "boolean")
	private Boolean includeInRpt;

	@Transient
	@JsonProperty("includeRpt")
	private Character includeRpt;

	public EntityFileRecColumnVw() {

	}

	public EntityFileRecColumnVw(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.effectiveDate = effectiveDate;
		this.addMode = addMode;
		this.releaseNo = releaseNo;

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

	public Integer getColumnID() {
		return columnID;
	}

	public void setColumnID(Integer columnID) {
		this.columnID = columnID;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Integer getColLength() {
		return colLength;
	}

	public void setColLength(Integer colLength) {
		this.colLength = colLength;
	}

	public Integer getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Integer startPosition) {
		this.startPosition = startPosition;
	}

	public String getAllowValue() {
		return allowValue;
	}

	public void setAllowValue(String allowValue) {
		this.allowValue = allowValue;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getWmc() {
		return wmc;
	}

	public void setWmc(String wmc) {
		this.wmc = wmc;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getColMask() {
		return colMask;
	}

	public void setColMask(String colMask) {
		this.colMask = colMask;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public Boolean getIncludeInRpt() {
		return includeInRpt;
	}

	public void setIncludeInRpt(Boolean includeInRpt) {
		this.includeInRpt = includeInRpt;
	}

	public Character getIncludeRpt() {
		return includeRpt;
	}

	public void setIncludeRpt(Character includeRpt) {
		this.includeRpt = includeRpt;
	}

	@PostLoad
	public void postLoad() {
		convertIncludeInRpt();
	}

	private void convertIncludeInRpt() {
		if (getIncludeInRpt() == null) {
			this.includeRpt = 'N';
		} else {
			if (getIncludeInRpt() == true) {
				this.includeRpt = 'Y';
			} else {
				this.includeRpt = 'N';
			}
		}

	}

}
