/**
 * 
 */
package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


/**
 * @author karthik
 *
 */
@Embeddable
public class ReleaseArchiveKey implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ReleaseID", nullable = false)
	@NotNull
	private Integer releaseId;
	
	@Column(name = "ArchivedReleaseID", nullable = false)
	@NotNull
	private Integer archivedReleaseId;
	
	@Column(name = "TableName", nullable = false)
	@NotNull
	private String tableName;
	
	@Column(name = "TableRecID", nullable = false)
	@NotNull
	private String tableRecId;
	
	
	

	public ReleaseArchiveKey() {
		
	}

	public ReleaseArchiveKey(Integer releaseId, Integer archivedReleaseId, String tableName, String tableRecId) {
		
		this.releaseId = releaseId;
		this.archivedReleaseId = archivedReleaseId;
		this.tableName = tableName;
		this.tableRecId = tableRecId;
	}

	public Integer getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(Integer releaseId) {
		this.releaseId = releaseId;
	}

	public Integer getArchivedReleaseId() {
		return archivedReleaseId;
	}

	public void setArchivedReleaseId(Integer archivedReleaseId) {
		this.archivedReleaseId = archivedReleaseId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableRecId() {
		return tableRecId;
	}

	public void setTableRecId(String tableRecId) {
		this.tableRecId = tableRecId;
	}
	
	
	
	
}
