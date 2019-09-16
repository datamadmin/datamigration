package com.dataeconomy.datamigration.models.metastore;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.dataeconomy.framework.util.ExcelHeader;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "fileformat", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@JsonRootName("fileFormat")
@XmlRootElement(name = "fileformat")
public class FileFormat implements AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ExcelHeader(name = "fileformatid")
	@Column(name = "fileformatid", nullable = false)
	@Id
	@NotNull
	@JsonProperty("FileFormatID")
	private Integer fileFormatID;

	@ExcelHeader(name = "fileformat")
	@JsonProperty("FileFormat")
	private String fileFormat;

	@ExcelHeader(name = "description")
	@JsonProperty("Description")
	private String description;

	@Column(name = "releasenum", nullable = false)
	@ExcelHeader(name = "releasenum")
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@JsonIgnore
	@OneToMany(mappedBy = "fileFormat")
	private List<EntityFileTypeXref> entityFileTypeXrefs;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public FileFormat(boolean addMode, Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
	}

	public FileFormat() {

	}

	public Integer getFileFormatID() {
		return fileFormatID;
	}

	public void setFileFormatID(Integer fileFormatID) {
		this.fileFormatID = fileFormatID;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
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
	public List<EntityFileTypeXref> getEntityFileTypeXrefs() {
		return entityFileTypeXrefs;
	}

	public void setEntityFileTypeXrefs(List<EntityFileTypeXref> entityFileTypeXrefs) {
		this.entityFileTypeXrefs = entityFileTypeXrefs;
	}

}
