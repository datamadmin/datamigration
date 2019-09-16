package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class DataStewardGroupsKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "UserName")
	@JsonProperty("UserName")
	private String userName;

	@Column(name = "GroupName")
	@JsonProperty("GroupName")
	private String groupName;

	// setters and getters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
