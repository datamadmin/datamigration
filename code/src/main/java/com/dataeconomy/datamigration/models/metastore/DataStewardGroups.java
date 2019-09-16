package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "datastewardgroups", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
 @JsonRootName("dataStewardgroup")
 @XmlRootElement(name="dataStewardgroup")
public class DataStewardGroups implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonProperty("Key")
	private DataStewardGroupsKey dataStewardGroupsKey;

	@Column(name = "UserName", insertable = false, updatable = false)
	@JsonProperty("UserName")
	private String userName;

	@Column(name = "GroupName", insertable = false, updatable = false)
	@JsonProperty("GroupName")
	private String groupName;

	@JsonProperty("UserEmail")
	private String userEmail;

	@JsonProperty("FileType")
	private String fileType;

	@JsonProperty("Tag")
	private String tag;

	@JsonProperty("ErrorLevel")
	private String errorLevel;

	@JsonProperty("FileTypeID")
	private Integer fileTypeId;

	@Column(name = "ReleaseNum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public DataStewardGroups(Integer releaseNo, boolean addMode) {
		this.releaseNo = releaseNo;
		this.addMode = addMode;
	}

	public DataStewardGroups() {

	}
	public DataStewardGroups(boolean addMode,Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
	}

	// getters and setters

	

	public DataStewardGroupsKey getDataStewardGroupsKey() {
		return dataStewardGroupsKey;
	}

	public void setDataStewardGroupsKey(DataStewardGroupsKey dataStewardGroupsKey) {
		this.dataStewardGroupsKey = dataStewardGroupsKey;
	}
	@XmlTransient
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@XmlTransient
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getErrorLevel() {
		return errorLevel;
	}

	public void setErrorLevel(String errorLevel) {
		this.errorLevel = errorLevel;
	}

	public Integer getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(Integer fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}
	@XmlTransient
	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

}
