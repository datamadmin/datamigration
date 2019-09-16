package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "runschedule", schema = "datahub")
public class RunSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "runmoment", nullable = false)
	private LocalDateTime runMoment;

	@Column(name = "entityfiletypeid", nullable = false)
	private Integer entityFileTypeID;

	@Column(name = "filedirection", nullable = false)
	private String fileDirection;

	@Column(name = "processmoment")
	private LocalDateTime processMoment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getRunMoment() {
		return runMoment;
	}

	public void setRunMoment(LocalDateTime runMoment) {
		this.runMoment = runMoment;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public String getFileDirection() {
		return fileDirection;
	}

	public void setFileDirection(String fileDirection) {
		this.fileDirection = fileDirection;
	}

	public LocalDateTime getProcessMoment() {
		return processMoment;
	}

	public void setProcessMoment(LocalDateTime processMoment) {
		this.processMoment = processMoment;
	}

}
