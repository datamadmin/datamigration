package com.dataeconomy.datamigration.models.core;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dataeconomy.framework.util.LocalDateTimeDeserializer;
import com.dataeconomy.framework.util.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The persistent class for the audittaskinfo database table.
 * 
 */
@Entity
@Table(name = "vaudittaskinfo",schema="datahub")
@NamedQuery(name = "FetchAuditTaskByRights", query = "select audittask from AuditTaskInfo_VW audittask where audittask.taskId like ?1 order by revId desc")
public class AuditTaskInfo_VW implements Serializable {
	private static final long serialVersionUID = 1L;

	

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "lastupddt")
	private LocalDateTime lastUpdDt;

	private String owner;

	@Id
	@Column(name = "rev_id")
	private int revId;

	private String status;

	@Column(name = "taskid")
	private String taskId;

	@Column(name = "taskname")
	private String taskName;

	@Column(name = "revision_type")
	private int revisionType;
	
	@Column(name = "lastupdby")
	private String lastUpdBy;

	@Transient
	private String revisionTypeString;

	public AuditTaskInfo_VW() {
	}

	public String getLastUpdBy() {
		return this.lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}
	
	public LocalDateTime getLastUpdDt() {
		return lastUpdDt;
	}

	public void setLastUpdDt(LocalDateTime lastUpdDt) {
		this.lastUpdDt = lastUpdDt;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getRevId() {
		return this.revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getRevisionType() {
		return revisionType;
	}

	public void setRevisionType(int revisionType) {
		this.revisionType = revisionType;
	}

	public String getRevisionTypeString() {
		return revisionTypeString;
	}

	public void setRevisionTypeString(String revisionTypeString) {
		this.revisionTypeString = revisionTypeString;
	}

	@PostLoad
	public void convertRevisionType() {
		if (revisionType == 2) {
			revisionTypeString = "Deleted";
		}
	}
}