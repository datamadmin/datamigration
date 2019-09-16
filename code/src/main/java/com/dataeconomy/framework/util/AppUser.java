package com.dataeconomy.framework.util;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dataeconomy.datamigration.models.userConfig.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class AppUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private Long userId;
	private String userName;
	private String userEmail;
	private String firstName;
	private String lastName;
	private Integer userStatus;
	@JsonIgnore
	private Integer groupid;
	private boolean createTask;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime lastLoginDate;
	private Long releaseId;
	private String userLocked;
	private Long expiryDays;
	private Integer loginCount;
	private Integer roleId;

	@JsonIgnore
	private Map<String, Integer> colAccessRights = new HashMap<String, Integer>();
	@JsonIgnore
	private List<String> taskAccessRights = new ArrayList<String>();

	public AppUser() {

	}

	public AppUser(User user) {
		this.userName = user.getUserName();
		this.userId = user.getUserId();
		this.userEmail = user.getUserEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.userStatus = user.getUserStatus();
		this.groupid = user.getGroupid();
		this.createTask = user.isCreateTask();
		this.lastLoginDate = user.getLastLoginDate();
		this.roleId=user.getRoleId();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Map<String, Integer> getColAccessRights() {
		return colAccessRights;
	}

	public void setColAccessRights(Map<String, Integer> colAccessRights) {
		this.colAccessRights = colAccessRights;
	}

	public List<String> getTaskAccessRights() {
		return taskAccessRights;
	}

	public void setTaskAccessRights(List<String> taskAccessRights) {
		this.taskAccessRights = taskAccessRights;
	}

	public boolean isImpersonated() {
		return !this.userName.equals(this.getUserName());
	}

	public boolean isCreateTask() {
		return createTask;
	}

	public void setCreateTask(boolean createTask) {
		this.createTask = createTask;
	}

	public Long getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(Long releaseId) {
		this.releaseId = releaseId;
	}

	public String getLastUpdatedBy() {
		int MAX_USER_ID_LENGTH = 30;
		String userName = this.getUserName().length() > MAX_USER_ID_LENGTH ? this.getUserName().substring(0, MAX_USER_ID_LENGTH - 1) : this.getUserName();
		return userName.toUpperCase();
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getUserLocked() {
		return userLocked;
	}

	public void setUserLocked(String userLocked) {
		this.userLocked = userLocked;
	}

	public Long getExpiryDays() {
		return expiryDays;
	}

	public void setExpiryDays(Long expiryDays) {
		this.expiryDays = expiryDays;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return userName;
	}

}
