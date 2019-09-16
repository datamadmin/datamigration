package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the dataqualitydimensions database table.
 * 
 */
@Entity
@Table(name = "emdqdimensions", schema = "metastore")
@NamedQuery(name = "EntityMasterDataqualitydimension.findAll", query = "SELECT d FROM EntityMasterDataqualitydimension d")
public class EntityMasterDataqualitydimension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer dataqualitydimension;

	// bi-directional many-to-one association to Dataquality
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "dataqualityid")
	private EntityMasterDataquality dataquality;

	public EntityMasterDataqualitydimension() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDataqualitydimension() {
		return this.dataqualitydimension;
	}


	public EntityMasterDataquality getDataquality() {
		return dataquality;
	}

	public void setDataquality(EntityMasterDataquality dataquality) {
		this.dataquality = dataquality;
	}


	public void setDataqualitydimension(Integer dataqualitydimension) {
		this.dataqualitydimension = dataqualitydimension;
	}

}