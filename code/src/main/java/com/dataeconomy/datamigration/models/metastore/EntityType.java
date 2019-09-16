package com.dataeconomy.datamigration.models.metastore;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.dataeconomy.framework.util.ExcelHeader;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@Entity
@Table(name = "entitytype", schema = "metastore")
@JsonRootName("entityType")
@XmlRootElement(name = "entitytype")
public class EntityType implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "entitytypeid", nullable = false)
	@ExcelHeader(name = "entitytypeid")
	@JsonProperty("EntityTypeID")
	private Integer entityTypeID;
	
	@Column(name = "description", nullable = false)
	@ExcelHeader(name = "description")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "releasenum", nullable = false)
	@ExcelHeader(name = "releasenum")
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "entityType",fetch = FetchType.LAZY)
	private List<EntityMaster> entityMasters;

	@Transient
	@JsonIgnore
	private boolean addMode;

	// private Set<EntityMaster> entityMasters;

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "EntityType") public
	 * Set<EntityMaster> getEntityMasters() { return entityMasters; }
	 * 
	 * public void setEntityMasters(Set<EntityMaster> entityMasters) {
	 * this.entityMasters = entityMasters; }
	 */
	public EntityType(boolean addMode, Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
	}

	public EntityType() {

	}

	public Integer getEntityTypeID() {
		return entityTypeID;
	}

	public void setEntityTypeID(Integer entityTypeID) {
		this.entityTypeID = entityTypeID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	@XmlTransient
	public List<EntityMaster> getEntityMasters() {
		return entityMasters;
	}

	public void setEntityMasters(List<EntityMaster> entityMasters) {
		this.entityMasters = entityMasters;
	}

}
