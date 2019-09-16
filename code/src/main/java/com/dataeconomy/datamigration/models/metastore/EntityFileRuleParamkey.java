package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;

public class EntityFileRuleParamkey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2843793382279791123L;

	@Column(name = "entityfileruleid")
	private Integer entityFileRuleId;

	@Column(name = "paramid")
	private String paramID;

	public EntityFileRuleParamkey() {
		super();
	}

	public EntityFileRuleParamkey(String paramID) {
		super();
		this.paramID = paramID;
	}


	public Integer getEntityFileRuleId() {
		return entityFileRuleId;
	}

	public void setEntityFileRuleId(Integer entityFileRuleId) {
		this.entityFileRuleId = entityFileRuleId;
	}

	public String getParamID() {
		return paramID;
	}

	public void setParamID(String paramID) {
		this.paramID = paramID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + entityFileRuleId;
		result = prime * result + ((paramID == null) ? 0 : paramID.hashCode());
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
		EntityFileRuleParamkey other = (EntityFileRuleParamkey) obj;
		if (entityFileRuleId != other.entityFileRuleId)
			return false;
		if (paramID == null) {
			if (other.paramID != null)
				return false;
		} else if (!paramID.equals(other.paramID))
			return false;
		return true;
	}

}
