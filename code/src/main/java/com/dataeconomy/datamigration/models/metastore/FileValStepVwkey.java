package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileValStepVwkey implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("filemask")
		private String fileMask;
	
	@JsonProperty("StepID")
		private Integer stepId;
	
		public String getFileMask() {
			return fileMask;
		}
		public void setFileMask(String fileMask) {
			this.fileMask = fileMask;
		}
		public Integer getStepId() {
			return stepId;
		}
		public void setStepId(Integer stepId) {
			this.stepId = stepId;
		}
		
		
		
		
}
