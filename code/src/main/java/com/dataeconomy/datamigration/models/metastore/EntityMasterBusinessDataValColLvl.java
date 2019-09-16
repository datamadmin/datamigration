package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the businessdatavalcontrol database table.
 * 
 */
@Entity
@Table(name="embusdatavalcollvl",schema="metastore")
@NamedQuery(name = "EntityMasterBusinessDataValColLvl.findAll", query = "SELECT b FROM EntityMasterBusinessDataValColLvl b")
public class EntityMasterBusinessDataValColLvl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "datavalidationcolumn")
	private Integer dataValidationColumn;

	// bi-directional many-to-one association to Businessdataval
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "businessvalidationid")
	private EntityMasterBusinessDataVal businessdataval;

	public EntityMasterBusinessDataValColLvl() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDataValidationColumn() {
		return dataValidationColumn;
	}

	public void setDataValidationColumn(Integer dataValidationColumn) {
		this.dataValidationColumn = dataValidationColumn;
	}

	public EntityMasterBusinessDataVal getBusinessdataval() {
		return this.businessdataval;
	}

	public void setBusinessdataval(EntityMasterBusinessDataVal businessdataval) {
		this.businessdataval = businessdataval;
	}

}
