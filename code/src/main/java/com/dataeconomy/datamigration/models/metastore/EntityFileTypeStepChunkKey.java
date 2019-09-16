package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class EntityFileTypeStepChunkKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "entityfiletypeid")
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeId;

	@Column(name = "stepid")
	@JsonProperty("StepID")
	private Integer stepID;

	// getters and setters

	public Integer getEntityFileTypeId() {
		return entityFileTypeId;
	}

	public void setEntityFileTypeId(Integer entityFileTypeId) {
		this.entityFileTypeId = entityFileTypeId;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityFileTypeId == null) ? 0 : entityFileTypeId.hashCode());
		result = prime * result + ((stepID == null) ? 0 : stepID.hashCode());
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
		EntityFileTypeStepChunkKey other = (EntityFileTypeStepChunkKey) obj;
		if (entityFileTypeId == null) {
			if (other.entityFileTypeId != null)
				return false;
		} else if (!entityFileTypeId.equals(other.entityFileTypeId))
			return false;
		if (stepID == null) {
			if (other.stepID != null)
				return false;
		} else if (!stepID.equals(other.stepID))
			return false;

		return true;
	}

}
