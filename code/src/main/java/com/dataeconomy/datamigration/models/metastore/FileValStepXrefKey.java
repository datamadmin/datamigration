package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;




public class FileValStepXrefKey  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("entityFileTypeID")
	private Integer EntityFileTypeID;
	
	@JsonProperty("stepID")
    private Integer StepID;
    

 public FileValStepXrefKey()
 {
	 
 }
    public FileValStepXrefKey(Integer entityFileTypeID,Integer stepID){
    	this.EntityFileTypeID = entityFileTypeID;
    	this.StepID = stepID;
    }
	public Integer getEntityFileTypeID() {
		return EntityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.EntityFileTypeID = entityFileTypeID;
	}

	public Integer getStepID() {
		return StepID;
	}

	public void setStepID(Integer stepID) {
		this.StepID = stepID;
	}


    
}
