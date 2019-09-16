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
@Table(name = "webservicereccolumn", schema = "metastore")
@XmlRootElement(name = "webservicereccolumn")
public class WebServiceRecColumn implements AbstractModel {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@JsonProperty("Key")
	private WebServiceRecColumnKey webServiceRecColumnKey;

	@Column(name = "webserviceid", insertable = false, updatable = false)
	@JsonIgnore
	private Integer webServiceID;

	@Column(name = "columnid", insertable = false, updatable = false)
	@JsonIgnore
	private Integer columnID;

	@Column(name = "colname")
	@JsonProperty("ColName")
	private String colName;

	@Column(name = "datatype")
	@JsonProperty("DataType")
	private String dataType;

	@Column(name = "collength")
	@JsonProperty("ColLength")
	private Integer colLength;

	@Column(name = "startposition")
	@JsonProperty("StartPosition")
	private Integer startPosition;

	@Column(name = "colmask")
	@JsonProperty("ColMask")
	private String colMask;

	@Column(name = "allownullvalue")
	@JsonProperty("AllowNullValue")
	private String allowNullValue;

	@Column(name = "active")
	@JsonProperty("Active")
	private String active;

	@Column(name = "effectivedate")
	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@Column(name = "xpathparent")
	@JsonProperty("XPathParent")
	private String xPathParent;

	@Column(name = "releasenum")
	@JsonProperty("ReleaseNum")
	private Integer releaseNum;

	// Getters & Setters

	public WebServiceRecColumnKey getWebServiceRecColumnKey() {
		return webServiceRecColumnKey;
	}

	public void setWebServiceRecColumnKey(WebServiceRecColumnKey webServiceRecColumnKey) {
		this.webServiceRecColumnKey = webServiceRecColumnKey;
	}

	@XmlTransient
	public Integer getWebServiceID() {
		return webServiceID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
	}

	@XmlTransient
	public Integer getColumnID() {
		return columnID;
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

	public String getxPathParent() {
		return xPathParent;
	}

	public void setxPathParent(String xPathParent) {
		this.xPathParent = xPathParent;
	}

	public Integer getReleaseNum() {
		return releaseNum;
	}

	public void setReleaseNum(Integer releaseNum) {
		this.releaseNum = releaseNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((webServiceRecColumnKey == null) ? 0 : webServiceRecColumnKey.hashCode());
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
		WebServiceRecColumn other = (WebServiceRecColumn) obj;
		if (webServiceRecColumnKey == null) {
			if (other.webServiceRecColumnKey != null)
				return false;
		} else if (!webServiceRecColumnKey.equals(other.webServiceRecColumnKey))
			return false;
		return true;
	}

}
