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
@Table(name = "entityfiletypexref_v", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class EntityFileTypeXrefVw implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "entityfiletypeid", nullable = false)
	@JsonProperty("entityFileTypeID")
	private Integer entityFileTypeID;

	@JsonProperty("entityName")
	private String entityName;

	@JsonProperty("hSFileType")
	private String hSFileType;

	@JsonProperty("fileFormat")
	private String fileFormat;

	@JsonProperty("filePath")
	private String filePath;

	@JsonProperty("fileMask")
	private String fileMask;

	@JsonProperty("recDelimiter")
	private String recDelimiter;

	@JsonProperty("columnsDelimiter")
	private String columnsDelimiter;

	@JsonProperty("columnsCount")
	private Integer columnsCount;

	@JsonProperty("maxRecLen")
	private Integer maxRecLen;

	@JsonProperty("allowExtraColumns")
	private String allowExtraColumns;

	@JsonProperty("notifyRetyCount")
	private Integer notifyRetyCount;

	@JsonProperty("outboundOrder")
	private Integer outboundOrder;

	@JsonProperty("active")
	private String active;

	@JsonProperty("effectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("columnsWidth")
	private Integer columnsWidth;

	@JsonProperty("dupFileCheck")
	private String dupFileCheck;

	@JsonProperty("columnsPattern")
	private String columnsPattern;

	@JsonProperty("noDataRecordPattern")
	private String noDataRecordPattern;

	@JsonProperty("noRecordDelimiter")
	private String noRecordDelimiter;

	@JsonProperty("outBoundFilter")
	private String outBoundFilter;

	@JsonProperty("sheetName")
	private String sheetName;

	@JsonProperty("ignoreHeaderRowCount")
	private Integer ignoreHeaderRowCount;

	@JsonProperty("ignoreFooterRowCount")
	private Integer ignoreFooterRowCount;

	@JsonProperty("firstColumn")
	private Integer firstColumn;

	@JsonProperty("lastColumn")
	private Integer lastColumn;

	@JsonProperty("allowBlankRows")
	private String allowBlankRows;

	@JsonProperty("eOFDelimiter")
	private String eOFDelimiter;

	@JsonProperty("entityID")
	private Integer entityID;

	@JsonProperty("fileTypeID")
	private Integer fileTypeID;

	@JsonProperty("fileFormatID")
	private Integer fileFormatID;

	@Column(name = "releasenum")
	@JsonProperty("releaseNum")
	private Integer releaseNo;

	@JsonProperty("xSD")
	private String xsd;

	@JsonProperty("xMLLOOP")
	private String xmlLoop;

	@JsonProperty("prettify")
	private String prettify;

	@JsonProperty("poolID")
	private Integer poolID;

	@Transient
	@JsonIgnore
	private String comments;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public EntityFileTypeXrefVw() {

	}

	public EntityFileTypeXrefVw(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.effectiveDate = effectiveDate;
		this.addMode = addMode;
		this.releaseNo = releaseNo;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
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

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileMask() {
		return fileMask;
	}

	public void setFileMask(String fileMask) {
		this.fileMask = fileMask;
	}

	public String getRecDelimiter() {
		return recDelimiter;
	}

	public void setRecDelimiter(String recDelimiter) {
		this.recDelimiter = recDelimiter;
	}

	public String getColumnsDelimiter() {
		return columnsDelimiter;
	}

	public void setColumnsDelimiter(String columnsDelimiter) {
		this.columnsDelimiter = columnsDelimiter;
	}

	public Integer getColumnsCount() {
		return columnsCount;
	}

	public void setColumnsCount(Integer columnsCount) {
		this.columnsCount = columnsCount;
	}

	public Integer getMaxRecLen() {
		return maxRecLen;
	}

	public void setMaxRecLen(Integer maxRecLen) {
		this.maxRecLen = maxRecLen;
	}

	public String getAllowExtraColumns() {
		return allowExtraColumns;
	}

	public void setAllowExtraColumns(String allowExtraColumns) {
		this.allowExtraColumns = allowExtraColumns;
	}

	public Integer getNotifyRetyCount() {
		return notifyRetyCount;
	}

	public void setNotifyRetyCount(Integer notifyRetyCount) {
		this.notifyRetyCount = notifyRetyCount;
	}

	public Integer getOutboundOrder() {
		return outboundOrder;
	}

	public void setOutboundOrder(Integer outboundOrder) {
		this.outboundOrder = outboundOrder;
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

	public String getDupFileCheck() {
		return dupFileCheck;
	}

	public void setDupFileCheck(String dupFileCheck) {
		this.dupFileCheck = dupFileCheck;
	}

	public String getColumnsPattern() {
		return columnsPattern;
	}

	public void setColumnsPattern(String columnsPattern) {
		this.columnsPattern = columnsPattern;
	}

	public String getNoDataRecordPattern() {
		return noDataRecordPattern;
	}

	public void setNoDataRecordPattern(String noDataRecordPattern) {
		this.noDataRecordPattern = noDataRecordPattern;
	}

	public String getNoRecordDelimiter() {
		return noRecordDelimiter;
	}

	public void setNoRecordDelimiter(String noRecordDelimiter) {
		this.noRecordDelimiter = noRecordDelimiter;
	}

	public String getOutBoundFilter() {
		return outBoundFilter;
	}

	public void setOutBoundFilter(String outBoundFilter) {
		this.outBoundFilter = outBoundFilter;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public Integer getIgnoreHeaderRowCount() {
		return ignoreHeaderRowCount;
	}

	public void setIgnoreHeaderRowCount(Integer ignoreHeaderRowCount) {
		this.ignoreHeaderRowCount = ignoreHeaderRowCount;
	}

	public Integer getIgnoreFooterRowCount() {
		return ignoreFooterRowCount;
	}

	public void setIgnoreFooterRowCount(Integer ignoreFooterRowCount) {
		this.ignoreFooterRowCount = ignoreFooterRowCount;
	}

	public Integer getFirstColumn() {
		return firstColumn;
	}

	public void setFirstColumn(Integer firstColumn) {
		this.firstColumn = firstColumn;
	}

	public Integer getLastColumn() {
		return lastColumn;
	}

	public void setLastColumn(Integer lastColumn) {
		this.lastColumn = lastColumn;
	}

	public String getAllowBlankRows() {
		return allowBlankRows;
	}

	public void setAllowBlankRows(String allowBlankRows) {
		this.allowBlankRows = allowBlankRows;
	}

	public String geteOFDelimiter() {
		return eOFDelimiter;
	}

	public void seteOFDelimiter(String eOFDelimiter) {
		this.eOFDelimiter = eOFDelimiter;
	}

	public Integer getEntityID() {
		return entityID;
	}

	public void setEntityID(Integer entityID) {
		this.entityID = entityID;
	}

	public Integer getFileTypeID() {
		return fileTypeID;
	}

	public void setFileTypeID(Integer fileTypeID) {
		this.fileTypeID = fileTypeID;
	}

	public Integer getFileFormatID() {
		return fileFormatID;
	}

	public void setFileFormatID(Integer fileFormatID) {
		this.fileFormatID = fileFormatID;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public String getXsd() {
		return xsd;
	}

	public void setXsd(String xsd) {
		this.xsd = xsd;
	}

	public String getXmlLoop() {
		return xmlLoop;
	}

	public void setXmlLoop(String xmlLoop) {
		this.xmlLoop = xmlLoop;
	}

	public String getPrettify() {
		return prettify;
	}

	public void setPrettify(String prettify) {
		this.prettify = prettify;
	}

	public Integer getPoolID() {
		return poolID;
	}

	public void setPoolID(Integer poolID) {
		this.poolID = poolID;
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
