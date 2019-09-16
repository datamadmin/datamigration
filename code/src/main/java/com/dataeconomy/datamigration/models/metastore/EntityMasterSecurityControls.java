package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="emsecuritycontrols",schema="metastore")
public class EntityMasterSecurityControls implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "governancecontrolid")
	private Integer governanceControlId;

	@Column(name = "securitycontrolid")
	private Integer securityControlId;

	@Column(name = "entityid")
	private Long entityID;
	
	@Transient
	private String securityControlName;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "entityID", insertable = false, updatable = false)
	private EntityMaster entityMaster;
	
	@Transient
	private Boolean selected = Boolean.FALSE;

	// getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGovernanceControlId() {
		return governanceControlId;
	}

	public void setGovernanceControlId(Integer governanceControlId) {
		this.governanceControlId = governanceControlId;
	}

	public Integer getSecurityControlId() {
		return securityControlId;
	}

	public void setSecurityControlId(Integer securityControlId) {
		this.securityControlId = securityControlId;
	}


	public Long getEntityID() {
		return entityID;
	}

	public void setEntityID(Long entityID) {
		this.entityID = entityID;
	}

	public EntityMaster getEntityMaster() {
		return entityMaster;
	}

	public void setEntityMaster(EntityMaster entityMaster) {
		this.entityMaster = entityMaster;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getSecurityControlName() {
		return securityControlName;
	}

	public void setSecurityControlName(String securityControlName) {
		this.securityControlName = securityControlName;
	}


}
