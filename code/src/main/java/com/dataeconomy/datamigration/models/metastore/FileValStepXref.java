package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "filevalstepxref", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "filevalstepxref")
public class FileValStepXref implements AbstractModel {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "entityfiletypeid", nullable = false)
	@NotNull
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;

	@Id
	@JsonProperty("StepID")
	private Integer stepID;

	@JsonProperty("EntityID")
	private Integer entityID;

	@JsonProperty("FileTypeID")
	private Integer fileTypeID;

	@JsonProperty("StepOrder")
	private Integer stepOrder;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	private EntityFileTypeQueries entityFileTypeQueries;

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

	public Integer getEntityID() {
		return entityID;
	}

	public void setEntityID(Integer entityID) {
		this.entityID = entityID;
	}

	public Integer getFileTypeID() {
		return fileTypeID;
	}

	public void setFileTypeID(Integer fileTypeID) {
		this.fileTypeID = fileTypeID;
	}

	public Integer getStepOrder() {
		return stepOrder;
	}

	public void setStepOrder(Integer stepOrder) {
		this.stepOrder = stepOrder;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public EntityFileTypeQueries getEntityFileTypeQueries() {
		return entityFileTypeQueries;
	}

	public void setEntityFileTypeQueries(EntityFileTypeQueries entityFileTypeQueries) {
		this.entityFileTypeQueries = entityFileTypeQueries;
	}

}
