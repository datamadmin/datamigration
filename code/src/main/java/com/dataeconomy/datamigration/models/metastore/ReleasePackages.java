package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dataeconomy.framework.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "releasepackages", schema = "metastore")
@NamedQuery(name = "ReleasePackages.findAll", query = "SELECT relPackage FROM ReleasePackages relPackage order by createdDate")
@NamedStoredProcedureQuery(name = "metastore.sprelmanagment", procedureName = "metastore.sprelmanagment", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "release"), @StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "status") })
public class ReleasePackages extends BaseModel implements AbstractModel {

	/**
	 * serial version id.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "releasepackageid")
	@JsonProperty("RELEASEPACKAGEID")
	private Integer releasePackageNo;

	@Column(name = "releasepackagename")
	@JsonProperty("RELEASEPACKAGENAME")
	private String releasePackageName;

	@Column(name = "status")
	@JsonProperty("STATUS")
	private String status;

	@Transient
	@JsonIgnore
	private boolean addMode;

	@Transient
	@JsonIgnore
	private boolean baseRelease;

	public ReleasePackages() {
	}

	public ReleasePackages(boolean addMode) {
		this.addMode = addMode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public boolean isBaseRelease() {
		return baseRelease;
	}

	public void setBaseRelease(boolean baseRelease) {
		this.baseRelease = baseRelease;
	}

	public Integer getReleasePackageNo() {
		return releasePackageNo;
	}

	public void setReleasePackageNo(Integer releasePackageId) {
		this.releasePackageNo = releasePackageId;
	}

	public String getReleasePackageName() {
		return releasePackageName;
	}

	public void setReleasePackageName(String releasePackageName) {
		this.releasePackageName = releasePackageName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((releasePackageNo == null) ? 0 : releasePackageNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReleasePackages other = (ReleasePackages) obj;
		if (releasePackageNo == null) {
			if (other.releasePackageNo != null)
				return false;
		} else if (!releasePackageNo.equals(other.releasePackageNo))
			return false;
		return true;
	}

}
