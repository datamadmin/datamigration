package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The persistent class for the dataquality database table.
 * 
 */
@Entity
@Table(name = "emdataquality", schema = "metastore")
@NamedQuery(name = "EntityMasterDataquality.findAll", query = "SELECT d FROM EntityMasterDataquality d")
public class EntityMasterDataquality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String dataassessmentfrequency;

	private Integer datacleansing;

	private String datacleansingfrequency;

	private Integer dataTrustIndexType;

	private Integer dataType;

	private Integer dataUsage;

	@Column(name="dqthreshold")
	private Integer dataQualityThreshold;

	@Column(name="dqtrending")
	private Integer dataQualityTrending;

	private Integer importance;

	@Column(name = "entityid")
	private Long entityID;

	// bi-directional many-to-one association to Policy
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "entityID", insertable = false, updatable = false)
	private EntityMaster entityMaster;

	// bi-directional many-to-one association to Dataqualitydimension
	@OneToMany(mappedBy = "dataquality", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<EntityMasterDataqualitydimension> dataqualitydimensions = new LinkedHashSet<>();

	public EntityMasterDataquality() {
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


	public Integer getId() {
		return id;
	}

	public String getDataassessmentfrequency() {
		return this.dataassessmentfrequency;
	}

	public void setDataassessmentfrequency(String dataassessmentfrequency) {
		this.dataassessmentfrequency = dataassessmentfrequency;
	}

	

	public String getDatacleansingfrequency() {
		return this.datacleansingfrequency;
	}
                                   
	public void setDatacleansingfrequency(String datacleansingfrequency) {
		this.datacleansingfrequency = datacleansingfrequency;
	}

	public Integer getDataTrustIndexType() {
		return dataTrustIndexType;
	}


	public void setDataTrustIndexType(Integer dataTrustIndexType) {
		this.dataTrustIndexType = dataTrustIndexType;
	}


	public Integer getDataType() {
		return dataType;
	}


	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}


	public Integer getDataQualityThreshold() {
		return dataQualityThreshold;
	}


	public void setDataQualityThreshold(Integer dataQualityThreshold) {
		this.dataQualityThreshold = dataQualityThreshold;
	}


	public Integer getDataQualityTrending() {
		return dataQualityTrending;
	}


	public void setDataQualityTrending(Integer dataQualityTrending) {
		this.dataQualityTrending = dataQualityTrending;
	}


	public Integer getImportance() {
		return this.importance;
	}

	public void setImportance(Integer importance) {
		this.importance = importance;
	}
	

	public Integer getDatacleansing() {
		return datacleansing;
	}

	public Set<EntityMasterDataqualitydimension> getDataqualitydimensions() {
		return dataqualitydimensions;
	}

	public void setDataqualitydimensions(Set<EntityMasterDataqualitydimension> dataqualitydimensions) {
		this.dataqualitydimensions = dataqualitydimensions;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDatacleansing(Integer datacleansing) {
		this.datacleansing = datacleansing;
	}


	public Integer getDataUsage() {
		return dataUsage;
	}


	public void setDataUsage(Integer dataUsage) {
		this.dataUsage = dataUsage;
	}


}