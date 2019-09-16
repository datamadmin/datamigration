package com.dataeconomy.datamigration.models.metastore;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

@Entity
@Table(name = "filetype", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "hsfiletype")
public class HSFileType implements AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "filetypeid", nullable = false)
	@NotNull
	@JsonProperty("FileTypeID")
	private Integer fileTypeID;

	@Column(name = "filetype")
	@JsonProperty("HSFileType")
	private String hsFileType;

	@JsonProperty("Description")
	private String description;

	@Column(name = "releasenum", nullable = false)
	@ExcelHeader(name = "releasenum")
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Column(name = "filetypeabbr")
	@JsonProperty("HSFileTypeAbbr")
	private String hSFileTypeAbbr;
	
	@JsonIgnore
	@OneToMany(mappedBy="fileType")
	private List<EntityFileTypeXref> entityFileTypeXrefs;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public HSFileType(boolean addMode, Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
	}

	public HSFileType() {

	}

	// Getters and Setters.
	public Integer getFileTypeID() {
		return fileTypeID;
	}

	public void setFileTypeID(Integer fileTypeID) {
		this.fileTypeID = fileTypeID;
	}

	public String getHsFileType() {
		return hsFileType;
	}

	public void setHsFileType(String hsFileType) {
		this.hsFileType = hsFileType;
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

	public String gethSFileTypeAbbr() {
		return hSFileTypeAbbr;
	}

	public void sethSFileTypeAbbr(String hSFileTypeAbbr) {
		this.hSFileTypeAbbr = hSFileTypeAbbr;
	}
	@XmlTransient
	public List<EntityFileTypeXref> getEntityFileTypeXrefs() {
		return entityFileTypeXrefs;
	}

	public void setEntityFileTypeXrefs(List<EntityFileTypeXref> entityFileTypeXrefs) {
		this.entityFileTypeXrefs = entityFileTypeXrefs;
	}

}
