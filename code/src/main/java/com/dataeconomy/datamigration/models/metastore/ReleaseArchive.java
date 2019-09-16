/**
 * 
 */
package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author karthik
 *
 */
@Entity
@Table(name = "releasearchive", schema = "metastore")

public  class ReleaseArchive {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	ReleaseArchiveKey releaseArchiveKey;
	
	@Column(name = "recdata", nullable = false)
	@JsonProperty("RecData")
	private String recData;
	
	@Column(name="ViewRecData")
	@JsonProperty("ViewRecData")
	private String viewRecData;
	
	
	@Column(name="TablePkRecID")
	@JsonProperty("TablePkRecID")
	private String tablePkRecID;

	public ReleaseArchiveKey getReleaseArchiveKey() {
		return releaseArchiveKey;
	}

	public void setReleaseArchiveKey(ReleaseArchiveKey releaseArchiveKey) {
		this.releaseArchiveKey = releaseArchiveKey;
	}

	public String getRecData() {
		return recData;
	}

	public void setRecData(String recData) {
		this.recData = recData;
	}
	
	public String getViewRecData() {
		return viewRecData;
	}

	public void setViewRecData(String viewRecData) {
		this.viewRecData = viewRecData;
	}
	
	public String getTablePkRecID() {
		return tablePkRecID;
	}

	public void setTablePkRecID(String tablePkRecID) {
		this.tablePkRecID = tablePkRecID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((releaseArchiveKey == null) ? 0 : releaseArchiveKey.hashCode());
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
		ReleaseArchive other = (ReleaseArchive) obj;
		if (releaseArchiveKey == null) {
			if (other.releaseArchiveKey != null)
				return false;
		} else if (!releaseArchiveKey.equals(other.releaseArchiveKey))
			return false;
		return true;
	}
	
	

}
