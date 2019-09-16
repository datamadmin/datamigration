package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "vwebservicereccolumn", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class WebServiceRecColumnVw implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WebServiceRecColumnVwKey webServiceRecColumnVwKey;

	@Column(name = "webserviceid", insertable = false, updatable = false)
	@JsonProperty("WebServiceID")
	private Integer webServiceID;

	@Column(name = "columnid", insertable = false, updatable = false)
	@JsonProperty("ColumnID")
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

	@JsonProperty("AllowNullValue")
	private String allowNullValue;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("XPathParent")
	private String xPathParent;

	@Column(name = "releasenum")
	@JsonProperty("ReleaseNum")
	private Integer releaseNum;

	@Transient
	@JsonIgnore
	private String effectiveDtstr;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public WebServiceRecColumnVw(boolean addMode, LocalDate effctiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.effectiveDate = effctiveDate;
		this.releaseNum = releaseNo;

	}

	public WebServiceRecColumnVw() {

	}
	// getters and setters

	public WebServiceRecColumnVwKey getWebServiceRecColumnVwKey() {
		return webServiceRecColumnVwKey;
	}

	public void setWebServiceRecColumnVwKey(WebServiceRecColumnVwKey webServiceRecColumnVwKey) {
		this.webServiceRecColumnVwKey = webServiceRecColumnVwKey;
	}

	public Integer getWebServiceID() {
		return webServiceID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
	}

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

	public String getEffectiveDtstr() {
		return effectiveDtstr;
	}

	public void setEffectiveDtstr(String effectiveDtstr) {
		this.effectiveDtstr = effectiveDtstr;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

}
