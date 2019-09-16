package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dqdimension", schema = "metastore")
public class EntityDQDimension {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	private Integer entityFileTypeId;
	private Long dimensionId;
	private Double weightage;
	@Transient
	private String dimensionName;
	@Transient
	private String dimensionDescription;
	public Integer getEntityFileTypeId() {
		return entityFileTypeId;
	}
	public void setEntityFileTypeId(Integer entityFileTypeId) {
		this.entityFileTypeId = entityFileTypeId;
	}
	public Double getWeightage() {
		return weightage;
	}
	public void setWeightage(Double weightage) {
		this.weightage = weightage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDimensionName() {
		return dimensionName;
	}
	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}
	public String getDimensionDescription() {
		return dimensionDescription;
	}
	public void setDimensionDescription(String dimensionDescription) {
		this.dimensionDescription = dimensionDescription;
	}
	public Long getDimensionId() {
		return dimensionId;
	}
	public void setDimensionId(Long dimensionId) {
		this.dimensionId = dimensionId;
	}
	
	

}
