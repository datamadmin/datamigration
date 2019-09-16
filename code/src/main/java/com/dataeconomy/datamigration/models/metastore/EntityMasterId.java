package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityMasterId  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("EntityID")
	private Integer entityID;

	public Integer getEntityID() {
		return entityID;
	}

	public void setEntityID(Integer entityID) {
		this.entityID = entityID;
	}
	
	

}
