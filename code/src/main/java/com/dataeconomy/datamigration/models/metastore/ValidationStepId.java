package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationStepId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Column(name = "StepID", nullable = false)
	@NotNull
	@JsonProperty("StepID")
	private Integer stepID;

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}
	
	
}
