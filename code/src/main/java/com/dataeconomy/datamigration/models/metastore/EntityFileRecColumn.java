package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "entityfilereccolumn", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityfilereccolumn")
@NamedQueries({
		@NamedQuery(name = "findEntityFileRecColumnByFileTypeId", query = "from EntityFileRecColumn frc where frc.entityFileTypeID = :entityFileTypeID") })
public class EntityFileRecColumn implements AbstractModel {

	public static final long serialVersionUID = 1L;

	public static final String FIND_ENTITY_FILE_REC_COLUMNBY_FILETYPEID = "findEntityFileRecColumnByFileTypeId";

	@EmbeddedId
	@JsonProperty("Key")
	private EntityFileRecColumnKey entityFileRecColKey;

	@Column(name = "entityfiletypeid", insertable = false, nullable = false, updatable = false)
	private Integer entityFileTypeID;

	@Column(name = "columnid", insertable = false, nullable = false, updatable = false)
	private Integer columnID;

	@JsonProperty("ColName")
	private String colName;

	@JsonProperty("DataType")
	private String dataType;

	@JsonProperty("ColLength")
	private Integer colLength;

	@JsonProperty("StartPosition")
	private Integer startPosition;

	@JsonProperty("ColMask")
	private String colMask;

	@Column(name = "allownullvalue", nullable = false)
	@JsonProperty("AllowNullValue")
	private String allowNullValue;

	@Column(name = "active", nullable = false)
	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class) 
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@Column(name = "xpathparent")
	private String xPathParent;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo = 1;

	@Column(name = "includeinrpt")
	@JsonProperty("IncludeInRpt")
	private Boolean includeInRpt;

	@Column(name = "attrname")
	@JsonProperty("AttrName")
	private String attributeName;

	@Column(name = "attrid")
	@JsonProperty("AttrId")
	private Integer attributeId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "entityfiletypeid", insertable = false, updatable = false)
	private EntityFileTypeXref entityFileTypeXref;

	@XmlTransient
	public Integer getColumnID() {
		return columnID;
	}

	@XmlTransient
	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public void setColumnID(Integer columnID) {
		this.columnID = columnID;
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

	public String getColMask() {
		return colMask;
	}

	public void setColMask(String colMask) {
		this.colMask = colMask;
	}

	public String getAllowNullValue() {
		return allowNullValue;
	}

	public void setAllowNullValue(String allowNullValue) {
		this.allowNullValue = allowNullValue;
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

	public EntityFileRecColumnKey getEntityFileRecColKey() {
		return entityFileRecColKey;
	}

	public void setEntityFileRecColKey(EntityFileRecColumnKey entityFileRecColKey) {
		this.entityFileRecColKey = entityFileRecColKey;
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

	public EntityFileTypeXref getEntityFileTypeXref() {
		return entityFileTypeXref;
	}

	public void setEntityFileTypeXref(EntityFileTypeXref entityFileTypeXref) {
		this.entityFileTypeXref = entityFileTypeXref;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getxPathParent() {
		return xPathParent;
	}

	public void setxPathParent(String xPathParent) {
		this.xPathParent = xPathParent;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityFileRecColKey == null) ? 0 : entityFileRecColKey.hashCode());
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
		EntityFileRecColumn other = (EntityFileRecColumn) obj;
		if (entityFileRecColKey == null) {
			if (other.entityFileRecColKey != null)
				return false;
		} else if (!entityFileRecColKey.equals(other.entityFileRecColKey))
			return false;
		return true;
	}

}
