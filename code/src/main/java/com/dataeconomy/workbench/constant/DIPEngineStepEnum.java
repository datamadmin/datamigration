package com.dataeconomy.workbench.constant;

public enum DIPEngineStepEnum {
	APPLY_VALIDATION("APPLY_VALIDATION", 1), LOAD_ANALYTICS("LOAD_ANALYTICS", 2), FILE_VAL("FILE_VAL",
			55), HEADER_VAL("HEADER_VAL", 56), FOOTER_VAL("FOOTER_VAL", 3);

	public String stepName;
	public Integer stepId;

	DIPEngineStepEnum(String stepName, Integer stepId) {
		this.stepName = stepName;
		this.stepId = stepId;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

}
