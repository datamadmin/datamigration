package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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

/**
 * 
 * @author GASWANTH
 *
 */
@Entity
@Table(name = "entityfiletypexref", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityfiletypexref")
public class EntityFileTypeXref implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "entityfiletypeid", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;

	@Column(name = "entityid")
	@JsonProperty("EntityID")
	private Integer entityID;

	@Column(name = "filetypeid")
	@JsonProperty("FileTypeID")
	private Integer fileTypeID;

	@Column(name = "fileformatid")
	@JsonProperty("FileFormatID")
	private Integer fileFormatID;

	@Column(name = "filepath")
	@JsonProperty("FilePath")
	private String filePath;

	@Column(name = "filemask")
	@JsonProperty("FileMask")
	private String fileMask;

	@Column(name = "recdelimiter")
	@JsonProperty("RecDelimiter")
	private String recDelimiter;

	@Column(name = "columnsdelimiter")
	@JsonProperty("ColumnsDelimiter")
	private String columnsDelimiter;

	@Column(name = "columnscount")
	@JsonProperty("ColumnsCount")
	private Integer columnsCount;

	@Column(name = "maxreclen")
	@JsonProperty("MaxRecLen")
	private Integer maxRecLen;

	@Column(name = "allowextracolumns")
	@JsonProperty("AllowExtraColumns")
	private String allowExtraColumns;

	@Column(name = "notifyretycount")
	@JsonProperty("NotifyRetyCount")
	private Integer notifyRetyCount;

	@Column(name = "outboundorder")
	@JsonProperty("OutboundOrder")
	private String outboundOrder;

	@Column(name = "active")
	@JsonProperty("Active")
	private String active;

	@Column(name = "effectivedate")
	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@Column(name = "columnswidth")
	@JsonProperty("ColumnsWidth")
	private Integer columnsWidth;

	@Column(name = "dupfilecheck")
	@JsonProperty("DupFileCheck")
	private String dupFileCheck;

	@Column(name = "columnspattern")
	@JsonProperty("ColumnsPattern")
	private String columnsPattern;

	@Column(name = "nodatarecordpattern")
	@JsonProperty("NoDataRecordPattern")
	private String noDataRecordPattern;

	@Column(name = "norecorddelimiter")
	@JsonProperty("NoRecordDelimiter")
	private String noRecordDelimiter;

	@Column(name = "outboundfilter")
	@JsonProperty("OutBoundFilter")
	private String outBoundFilter;

	@Column(name = "sheetname")
	@JsonProperty("SheetName")
	private String sheetName;

	@Column(name = "ignoreheaderrowcount")
	@JsonProperty("IgnoreHeaderRowCount")
	private Integer ignoreHeaderRowCount;

	@Column(name = "ignorefooterrowcount")
	@JsonProperty("IgnoreFooterRowCount")
	private Integer ignoreFooterRowCount;

	@Column(name = "firstcolumn")
	@JsonProperty("FirstColumn")
	private Integer firstColumn;

	@Column(name = "lastcolumn")
	@JsonProperty("LastColumn")
	private Integer lastColumn;

	@Column(name = "allowblankrows")
	@JsonProperty("AllowBlankRows")
	private String allowBlankRows;

	@Column(name = "eofdelimiter")
	@JsonProperty("EOFDelimiter")
	private String eOFDelimiter;

	@Column(name = "shortdescription")
	@JsonProperty("ShortDescription")
	private String shortDescription;

	@Column(name = "xsd")
	@JsonProperty("XSD")
	private String xsd;

	@Column(name = "xmlloop")
	@JsonProperty("XMLLOOP")
	private String xmlLoop;

	@Column(name = "prettify")
	@JsonProperty("Prettify")
	private String prettify;

	@Column(name = "poolid")
	@JsonProperty("PoolID")
	private Integer poolID;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@ManyToOne
	@JoinColumn(name = "entityid", insertable = false, updatable = false)
	@JsonIgnore
	private EntityMaster entityMaster;

	@ManyToOne
	@JoinColumn(name = "fileformatid", insertable = false, updatable = false)
	@JsonIgnore
	private FileFormat fileFormat;

	@ManyToOne
	@JoinColumn(name = "filetypeid", insertable = false, updatable = false)
	@JsonIgnore
	private HSFileType fileType;

	@ManyToOne
	@JoinColumn(name = "poolid", insertable = false, updatable = false)
	@JsonIgnore
	private ThreadPoolType threadPoolType;

	@OneToMany(mappedBy = "entityFileTypeXref")
	@JsonIgnore
	private List<EntityFileRecColumn> entityFileRecColumns = new ArrayList<EntityFileRecColumn>();

	@OneToMany(mappedBy = "entityFileTypeXref")
	@JsonIgnore
	private List<EntityFileRuleXref> entityFileRuleXrefs;

	public EntityFileTypeXref() {

	}

	public EntityFileTypeXref(Integer entityFileTypeID, Integer entityID, Integer fileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
		this.entityID = entityID;
		this.fileTypeID = fileTypeID;
	}

	public String geteOFDelimiter() {
		return eOFDelimiter;
	}

	public String getAllowBlankRows() {
		return allowBlankRows;
	}

	public void setAllowBlankRows(String allowBlankRows) {
		this.allowBlankRows = allowBlankRows;
	}

	public void seteOFDelimiter(String eOFDelimiter) {
		this.eOFDelimiter = eOFDelimiter;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
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

	public String getOutboundOrder() {
		return outboundOrder;
	}

	public void setOutboundOrder(String outboundOrder) {
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
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

	@XmlTransient
	public List<EntityFileRecColumn> getEntityFileRecColumns() {
		return entityFileRecColumns;
	}

	public void setEntityFileRecColumns(List<EntityFileRecColumn> entityFileRecColumns) {
		this.entityFileRecColumns = entityFileRecColumns;
	}

	@XmlTransient
	public EntityMaster getEntityMaster() {
		return entityMaster;
	}

	public void setEntityMaster(EntityMaster entityMaster) {
		this.entityMaster = entityMaster;
	}

	@XmlTransient
	public FileFormat getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(FileFormat fileFormat) {
		this.fileFormat = fileFormat;
	}

	@XmlTransient
	public HSFileType getFileType() {
		return fileType;
	}

	public void setFileType(HSFileType fileType) {
		this.fileType = fileType;
	}

	@XmlTransient
	public ThreadPoolType getThreadPoolType() {
		return threadPoolType;
	}

	public void setThreadPoolType(ThreadPoolType threadPoolType) {
		this.threadPoolType = threadPoolType;
	}

	@XmlTransient
	public List<EntityFileRuleXref> getEntityFileRuleXrefs() {
		return entityFileRuleXrefs;
	}

	public void setEntityFileRuleXrefs(List<EntityFileRuleXref> entityFileRuleXrefs) {
		this.entityFileRuleXrefs = entityFileRuleXrefs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityFileTypeID == null) ? 0 : entityFileTypeID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityFileTypeXref other = (EntityFileTypeXref) obj;
		if (entityFileTypeID == null) {
			if (other.entityFileTypeID != null)
				return false;
		} else if (!entityFileTypeID.equals(other.entityFileTypeID))
			return false;
		return true;
	}

}
