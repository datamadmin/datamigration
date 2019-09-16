package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * @author GASWANTH
 *
 */
@Entity
@Table(name = "headerfooter", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "headerfooter")
@NamedQueries({
		@NamedQuery(name = "findHeaderFooterByFileTypeId", query = "from HeaderFooter hf where hf.entityFileTypeID = :entityFileTypeID"),
		@NamedQuery(name = "deleteHeaderFooterByFileTypeId", query = "delete from HeaderFooter hf where hf.entityFileTypeID = :entityFileTypeID") })
public class HeaderFooter implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_HEADERFOOTER_BY_FILETYPEID = "findHeaderFooterByFileTypeId";
	public static final String DELETE_HEADER_FOOTER_BY_FILETYPEID = "deleteHeaderFooterByFileTypeId";

	@EmbeddedId
	@JsonProperty("Key")
	private HeaderFooterKey headerFooterKey;

	@Column(name = "entityfiletypeid", insertable = false, updatable = false)
	private Integer entityFileTypeID;

	@Column(name = "rectype", insertable = false, updatable = false)
	private String recType;

	@Column(name = "seqnum", insertable = false, updatable = false)
	private Integer seqNum;

	@JsonProperty("EntityID")
	private Integer entityID;

	@JsonProperty("FileTypeID")
	private Integer fileTypeID;

	@JsonProperty("HeaderFooterType")
	private String headerFooterType;

	@JsonProperty("FileRecNum")
	private String fileRecNum;

	@JsonProperty("ColCnt")
	private Integer colCnt;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("ColumnsWidth")
	private Integer columnsWidth;

	@JsonProperty("ColumnsPattern")
	private String columnsPattern;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

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

	public HeaderFooterKey getHeaderFooterKey() {
		return headerFooterKey;
	}

	public void setHeaderFooterKey(HeaderFooterKey headerFooterKey) {
		this.headerFooterKey = headerFooterKey;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	@XmlTransient
	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	@XmlTransient
	public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}

	@XmlTransient
	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((headerFooterKey == null) ? 0 : headerFooterKey.hashCode());
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
		HeaderFooter other = (HeaderFooter) obj;
		if (headerFooterKey == null) {
			if (other.headerFooterKey != null)
				return false;
		} else if (!headerFooterKey.equals(other.headerFooterKey))
			return false;
		return true;
	}

}
