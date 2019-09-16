package com.dataeconomy.datamigration.models.metastore;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The persistent class for the datalifecyclemgmt database table.
 * 
 */
@Entity
@Table(name="emdatalifecyclemgmt",schema="metastore")
@NamedQuery(name = "EntityMasterDataLifeCycleMgmt.findAll", query = "SELECT d FROM EntityMasterDataLifeCycleMgmt d")
public class EntityMasterDataLifeCycleMgmt implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "applicableriskcontrol")
	private Integer applicableriskcontrol;

	@Column(name = "applydatadiscovery")
	private Integer applydatadiscovery;

	@Column(name = "archivingprovision")
	private Integer archivingprovision;

	@Column(name = "businessmetadatarequried")
	private Integer businessmetadatarequried;

	@Column(name = "datalineage")
	private Integer datalineage;

	@Column(name = "dataprivacy")
	private Integer dataPrivacy;

	@Column(name = "dataprocessing")
	private Integer dataProcessing;

	@Column(name = "datapublicationtype")
	private Integer datapublicationtype;

	@Column(name = "datarequest")
	private Integer dataRequest;

	@Column(name = "datasource")
	private Integer dataSource;

	@Column(name = "datatype")
	private Integer dataType;

	@Column(name = "datausage")
	private Integer datausage;

	@Column(name = "datavalidation")
	private Integer dataValidation;

	@Column(name = "datavalidationapplicable")
	private Integer dataValidationApplicable;

	@Column(name = "disposalperiod")
	@JsonProperty("disposalperiod")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate disposalperiod;

	@Column(name = "frequency")
	private Integer frequency;

	@Column(name = "permissionforpublication")
	private Integer permissionforpublication;

	@Column(name = "recoveryfacility")
	private Integer recoveryfacility;

	@Column(name = "retentiontimeperiod")
	private Integer retentiontimeperiod;

	@Column(name = "riskcontrolstype")
	private Integer riskcontrolstype;

	@Column(name = "sourcedata")
	private Integer sourceData;

	@Column(name = "technicalmetadata")
	private Integer technicalmetadata;

	@Column(name = "entityid")
	private Integer entityID;

	// bi-directional many-to-one association to Policy
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "entityID", insertable = false, updatable = false)
	private EntityMaster entityMaster;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getApplicableriskcontrol() {
		return applicableriskcontrol;
	}

	public void setApplicableriskcontrol(Integer applicableriskcontrol) {
		this.applicableriskcontrol = applicableriskcontrol;
	}

	public Integer getApplydatadiscovery() {
		return applydatadiscovery;
	}

	public void setApplydatadiscovery(Integer applydatadiscovery) {
		this.applydatadiscovery = applydatadiscovery;
	}

	public Integer getArchivingprovision() {
		return archivingprovision;
	}

	public void setArchivingprovision(Integer archivingprovision) {
		this.archivingprovision = archivingprovision;
	}

	public Integer getBusinessmetadatarequried() {
		return businessmetadatarequried;
	}

	public void setBusinessmetadatarequried(Integer businessmetadatarequried) {
		this.businessmetadatarequried = businessmetadatarequried;
	}

	public Integer getDatalineage() {
		return datalineage;
	}

	public void setDatalineage(Integer datalineage) {
		this.datalineage = datalineage;
	}

	

	public Integer getDatapublicationtype() {
		return datapublicationtype;
	}

	public void setDatapublicationtype(Integer datapublicationtype) {
		this.datapublicationtype = datapublicationtype;
	}


	public Integer getDatausage() {
		return datausage;
	}

	public void setDatausage(Integer datausage) {
		this.datausage = datausage;
	}



	public Integer getDataPrivacy() {
		return dataPrivacy;
	}

	public void setDataPrivacy(Integer dataPrivacy) {
		this.dataPrivacy = dataPrivacy;
	}

	public Integer getDataProcessing() {
		return dataProcessing;
	}

	public void setDataProcessing(Integer dataProcessing) {
		this.dataProcessing = dataProcessing;
	}

	public Integer getDataRequest() {
		return dataRequest;
	}

	public void setDataRequest(Integer dataRequest) {
		this.dataRequest = dataRequest;
	}

	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public Integer getDataValidation() {
		return dataValidation;
	}

	public void setDataValidation(Integer dataValidation) {
		this.dataValidation = dataValidation;
	}

	public Integer getDataValidationApplicable() {
		return dataValidationApplicable;
	}

	public void setDataValidationApplicable(Integer dataValidationApplicable) {
		this.dataValidationApplicable = dataValidationApplicable;
	}

	public Integer getSourceData() {
		return sourceData;
	}

	public void setSourceData(Integer sourceData) {
		this.sourceData = sourceData;
	}

	public Integer getDatavalidationapplicable() {
		return dataValidationApplicable;
	}

	public void setDatavalidationapplicable(Integer datavalidationapplicable) {
		this.dataValidationApplicable = datavalidationapplicable;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getPermissionforpublication() {
		return permissionforpublication;
	}

	public void setPermissionforpublication(Integer permissionforpublication) {
		this.permissionforpublication = permissionforpublication;
	}

	public Integer getRecoveryfacility() {
		return recoveryfacility;
	}

	public void setRecoveryfacility(Integer recoveryfacility) {
		this.recoveryfacility = recoveryfacility;
	}

	public Integer getRetentiontimeperiod() {
		return retentiontimeperiod;
	}

	public void setRetentiontimeperiod(Integer retentiontimeperiod) {
		this.retentiontimeperiod = retentiontimeperiod;
	}

	public Integer getRiskcontrolstype() {
		return riskcontrolstype;
	}

	public void setRiskcontrolstype(Integer riskcontrolstype) {
		this.riskcontrolstype = riskcontrolstype;
	}

	

	public Integer getTechnicalmetadata() {
		return technicalmetadata;
	}

	public void setTechnicalmetadata(Integer technicalmetadata) {
		this.technicalmetadata = technicalmetadata;
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

	public LocalDate getDisposalperiod() {
		return disposalperiod;
	}

	public void setDisposalperiod(LocalDate disposalperiod) {
		this.disposalperiod = disposalperiod;
	}

}
