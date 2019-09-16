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
@Table(name = "headerfootercols", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "headerfootercols")
public class HeaderFooterCols implements AbstractModel {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@JsonProperty("Key")
	private Headerfootercolkey headerFooterColKey;

	@JsonProperty("ColumnName")
	private String columnName;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@Column(name = "entityfiletypeid", insertable = false, updatable = false)
	@JsonIgnore
	private Integer entityFileTypeId;

	@Column(name = "rectype", insertable = false, updatable = false)
	@JsonIgnore
	private String recType;

	@Column(name = "seqnum", insertable = false, updatable = false)
	@JsonIgnore
	private Integer seqNum;

	@Column(name = "columnid", insertable = false, updatable = false)
	@JsonIgnore
	private Integer columnID;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

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

	public Headerfootercolkey getHeaderFooterColKey() {
		return headerFooterColKey;
	}

	public void setHeaderFooterColKey(Headerfootercolkey headerFooterColKey) {
		this.headerFooterColKey = headerFooterColKey;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	@XmlTransient
	public Integer getEntityFileTypeId() {
		return entityFileTypeId;
	}

	public void setEntityFileTypeId(Integer entityFileTypeId) {
		this.entityFileTypeId = entityFileTypeId;
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

	@XmlTransient
	public Integer getColumnID() {
		return columnID;
	}

	public void setColumnID(Integer columnID) {
		this.columnID = columnID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((headerFooterColKey == null) ? 0 : headerFooterColKey.hashCode());
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
		HeaderFooterCols other = (HeaderFooterCols) obj;
		if (headerFooterColKey == null) {
			if (other.headerFooterColKey != null)
				return false;
		} else if (!headerFooterColKey.equals(other.headerFooterColKey))
			return false;
		return true;
	}

}
