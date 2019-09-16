package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the policystakeholserroles database table.
 * 
 */
@Entity
@Table(name = "emstakeholderroleusers", schema = "metastore")
@NamedQuery(name = "EntityMasterStakeholderRoleUsers.findAll", query = "SELECT p FROM EntityMasterStakeholderRoleUsers p")
public class EntityMasterStakeholderRoleUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;


	@Column(name = "userid")
	private Long userId;
	
	@Transient
	private String userName;

	@Transient
	private Boolean selected=Boolean.FALSE;

	// bi-directional many-to-one association to Policy
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "emstatkeholderroleid")
	private EntityMasterStakeholderRole entityMasterStakeholderRole;

	public EntityMasterStakeholderRoleUsers() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public EntityMasterStakeholderRole getEntityMasterStakeholderRole() {
		return entityMasterStakeholderRole;
	}

	public void setEntityMasterStakeholderRole(EntityMasterStakeholderRole entityMasterStakeholderRole) {
		this.entityMasterStakeholderRole = entityMasterStakeholderRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	

}
