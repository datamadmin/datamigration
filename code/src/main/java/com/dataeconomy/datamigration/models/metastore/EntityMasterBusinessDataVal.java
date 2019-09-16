package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="embusinessdataval",schema="metastore")
public class EntityMasterBusinessDataVal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "entityid")
	private Integer entityID;

	// bi-directional many-to-one association to Policy
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "entityID", insertable = false, updatable = false)
	private EntityMaster entityMaster;

	@Column(name = "datavalidationtype")
	private Integer dataValidationType;

	@Column(name = "documentvalidationprocess")
	private Integer documentValidationProcess;

	// bi-directional many-to-one association to businessdatavalColumnLevel
	@OneToMany(mappedBy = "businessdataval", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<EntityMasterBusinessDataValColLvl> businessdatavalColumnLevel = new LinkedHashSet<EntityMasterBusinessDataValColLvl>();

	// bi-directional many-to-one association to businessdatavalcontrol
	@OneToMany(mappedBy = "businessdataval", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<EntityMasterBusinessDataValControl> businessdatavalcontrol = new LinkedHashSet<EntityMasterBusinessDataValControl>();


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getDataValidationType() {
		return dataValidationType;
	}

	public void setDataValidationType(Integer dataValidationType) {
		this.dataValidationType = dataValidationType;
	}

	public Integer getDocumentValidationProcess() {
		return documentValidationProcess;
	}

	public void setDocumentValidationProcess(Integer documentValidationProcess) {
		this.documentValidationProcess = documentValidationProcess;
	}

	public Set<EntityMasterBusinessDataValColLvl> getBusinessdatavalColumnLevel() {
		return businessdatavalColumnLevel;
	}

	public void setBusinessdatavalColumnLevel(Set<EntityMasterBusinessDataValColLvl> businessdatavalColumnLevel) {
		this.businessdatavalColumnLevel = businessdatavalColumnLevel;
	}

	public Set<EntityMasterBusinessDataValControl> getBusinessdatavalcontrol() {
		return businessdatavalcontrol;
	}

	public void setBusinessdatavalcontrol(Set<EntityMasterBusinessDataValControl> businessdatavalcontrol) {
		this.businessdatavalcontrol = businessdatavalcontrol;
	}


}
