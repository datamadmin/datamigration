package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the policystakeholserroles database table.
 * 
 */
@Entity
@Table(name = "emstakeholderroles", schema = "metastore")
@NamedQuery(name = "EntityMasterStakeholderRole.findAll", query = "SELECT p FROM EntityMasterStakeholderRole p")
public class EntityMasterStakeholderRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "entityid")
	private Integer entityID;

	@Column(name = "businessdomain")
	private String businessdomain;

	@Column(name = "governancearea")
	private String governancearea;

	@Column(name = "roleid")
	private Integer roleid;

	@Transient
	private String roleName;
	
	// bi-directional many-to-one association to Policy
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "entityID", insertable = false, updatable = false)
	private EntityMaster entityMaster;

	// bi-directional one-to-many association to EntityMasterStakeholderRoleUsers
	@OneToMany(mappedBy = "entityMasterStakeholderRole", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<EntityMasterStakeholderRoleUsers> entityMasterStakeHolderRoleUsers = new LinkedHashSet<>();

	public EntityMasterStakeholderRole() {
	}

	public String getBusinessdomain() {
		return this.businessdomain;
	}

	public void setBusinessdomain(String businessdomain) {
		this.businessdomain = businessdomain;
	}

	public String getGovernancearea() {
		return this.governancearea;
	}

	public void setGovernancearea(String governancearea) {
		this.governancearea = governancearea;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<EntityMasterStakeholderRoleUsers> getEntityMasterStakeHolderRoleUsers() {
		return entityMasterStakeHolderRoleUsers;
	}

	public void setEntityMasterStakeHolderRoleUsers(
			Set<EntityMasterStakeholderRoleUsers> entityMasterStakeHolderRoleUsers) {
		this.entityMasterStakeHolderRoleUsers = entityMasterStakeHolderRoleUsers;
	}

	public Integer getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
