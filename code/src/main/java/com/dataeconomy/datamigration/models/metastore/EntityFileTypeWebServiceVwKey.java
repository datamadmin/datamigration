package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class EntityFileTypeWebServiceVwKey implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "WebServiceID")
	@JsonProperty("WebServiceID")
	private Integer webServiceID;
	
	//getters and setters
	
	public Integer getWebServiceID() {
		return webServiceID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((webServiceID == null) ? 0 : webServiceID.hashCode());
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
		EntityFileTypeWebServiceVwKey other = (EntityFileTypeWebServiceVwKey) obj;
		if (webServiceID == null) {
			if (other.webServiceID != null)
				return false;
		} else if (!webServiceID.equals(other.webServiceID))
			return false;
		return true;
	}

	
}
