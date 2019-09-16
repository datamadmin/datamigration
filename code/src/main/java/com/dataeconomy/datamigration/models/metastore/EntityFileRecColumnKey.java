package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class EntityFileRecColumnKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ColumnID")
	@JsonProperty("ColumnID")
	private Integer columnID;

	@Column(name = "EntityFileTypeID")
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;

	public EntityFileRecColumnKey() {
		super();
	}

	public EntityFileRecColumnKey(Integer columnID, Integer entityFileTypeID) {
		super();
		this.columnID = columnID;
		this.entityFileTypeID = entityFileTypeID;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
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
		result = prime * result + entityFileTypeID;
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
		EntityFileRecColumnKey other = (EntityFileRecColumnKey) obj;
		if (columnID != other.columnID)
			return false;
		if (entityFileTypeID != other.entityFileTypeID)
			return false;
		return true;
	}

}
