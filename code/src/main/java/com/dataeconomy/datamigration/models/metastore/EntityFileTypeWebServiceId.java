package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityFileTypeWebServiceId implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@JsonProperty("WebServiceID")
	private Integer webServiceID;
	
	public Integer getWebServiceID() {
		return webServiceID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
	}
	
}
