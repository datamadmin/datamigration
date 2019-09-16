package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the businessdatavalcontrol database table.
 * 
 */
@Entity
@Table(name="embusinessdatavalcntrl",schema="metastore")
@NamedQuery(name="EntityMasterBusinessDataValControl.findAll", query="SELECT b FROM EntityMasterBusinessDataValControl b")
public class EntityMasterBusinessDataValControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "datavalidationcontrol")
	private Integer datavalidationcontrol;
	
	

	//bi-directional many-to-one association to Businessdataval
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="businessvalidationid")
	private EntityMasterBusinessDataVal businessdataval;

	public EntityMasterBusinessDataValControl() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDatavalidationcontrol() {
		return this.datavalidationcontrol;
	}

	public void setDatavalidationcontrol(Integer datavalidationcontrol) {
		this.datavalidationcontrol = datavalidationcontrol;
	}

	public EntityMasterBusinessDataVal getBusinessdataval() {
		return this.businessdataval;
	}

	public void setBusinessdataval(EntityMasterBusinessDataVal businessdataval) {
		this.businessdataval = businessdataval;
	}

}
