package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the dataissuemgmt database table.
 * 
 */
@Entity
@Table(name="emdataissuemgmt",schema="metastore")
@NamedQuery(name = "EntityMasterDataIssueMgmt.findAll", query = "SELECT d FROM EntityMasterDataIssueMgmt d")
public class EntityMasterDataIssueMgmt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "activity")
	private String activity;

	@Column(name = "alertname")
	private String alertName;

	@Column(name = "governancearea")
	private String governanceArea;

	@Column(name = "monitoringrole")
	private Integer monitoringrole;

	@Column(name = "monitoringtools")
	private String monitoringtools;

	@Column(name = "severity")
	private Integer severity;

	@Column(name = "`user`")
	private Integer user;

	@Column(name = "entityid")
	private Integer entityID;

	// bi-directional many-to-one association to Policy
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "entityID", insertable = false, updatable = false)
	private EntityMaster entityMaster;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}


	public String getAlertName() {
		return alertName;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}

	
	public String getGovernanceArea() {
		return governanceArea;
	}

	public void setGovernanceArea(String governanceArea) {
		this.governanceArea = governanceArea;
	}

	public Integer getMonitoringrole() {
		return monitoringrole;
	}

	public void setMonitoringrole(Integer monitoringrole) {
		this.monitoringrole = monitoringrole;
	}

	public String getMonitoringtools() {
		return monitoringtools;
	}

	public void setMonitoringtools(String monitoringtools) {
		this.monitoringtools = monitoringtools;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getEntityID() {
		return entityID;
	}

	public void setEntityID(Integer entityID) {
		this.entityID = entityID;
	}

	public EntityMaster getEntityMaster() {
		return entityMaster;
	}

	public void setEntityMaster(EntityMaster entityMaster) {
		this.entityMaster = entityMaster;
	}

	
	
}
