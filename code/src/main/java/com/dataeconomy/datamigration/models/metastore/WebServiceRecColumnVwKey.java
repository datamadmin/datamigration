package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class WebServiceRecColumnVwKey implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("WebServiceID")
	private Integer webServiceID;
	
	@JsonProperty("ColumnID")
	private Integer columnID;
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
}
