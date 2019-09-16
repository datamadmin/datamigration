package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;



import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class WebServiceRecColumnKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name= "WebServiceID")
	@JsonProperty("WebServiceID")
	private Integer webServiceID;
	
	@Column(name = "columnid")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columnID;
		result = prime * result + webServiceID;
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
		WebServiceRecColumnKey other = (WebServiceRecColumnKey) obj;
		if (columnID != other.columnID)
			return false;
		if (webServiceID != other.webServiceID)
			return false;
		return true;
	}
	
	
	
	

}
