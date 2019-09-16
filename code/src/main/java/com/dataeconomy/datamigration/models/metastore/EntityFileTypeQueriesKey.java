package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class EntityFileTypeQueriesKey implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "EntityFileTypeID")
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;
	
	@Column(name = "StepID")
	@JsonProperty("StepID")
	private Integer stepID;
	
	@Column(name = "SeqOrder")
	@JsonProperty("SeqOrder")
	private Integer  seqOrder;

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}



	public Integer getSeqOrder() {
		return seqOrder;
	}

	public void setSeqOrder(Integer seqOrder) {
		this.seqOrder = seqOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityFileTypeID == null) ? 0 : entityFileTypeID.hashCode());
		result = prime * result + ((seqOrder == null) ? 0 : seqOrder.hashCode());
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
		EntityFileTypeQueriesKey other = (EntityFileTypeQueriesKey) obj;
		if (entityFileTypeID == null) {
			if (other.entityFileTypeID != null)
				return false;
		} else if (!entityFileTypeID.equals(other.entityFileTypeID))
			return false;
		if (seqOrder == null) {
			if (other.seqOrder != null)
				return false;
		} else if (!seqOrder.equals(other.seqOrder))
			return false;
		if (stepID == null) {
			if (other.stepID != null)
				return false;
		} else if (!stepID.equals(other.stepID))
			return false;
		return true;
	}
	
	

}
