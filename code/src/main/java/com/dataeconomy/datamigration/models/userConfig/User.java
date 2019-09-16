package com.dataeconomy.datamigration.models.userConfig;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateTimeDeserializer;
import com.dataeconomy.framework.util.LocalDateTimeSerializer;
import com.dataeconomy.framework.util.ThreadLocalUtil;
import com.dataeconomy.workbench.constant.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author jagadesh
 *
 */
@Entity
@Table(name = "users", schema = "userconfig")
@Audited
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column(name = "username", nullable = false)
	private String userName;

	@Column(name = "groupid")
	private Integer groupid;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String userEmail;

	@JsonIgnore
	@Column(name = "usersalt", nullable = false)
	private String userSalt;

	@JsonIgnore
	@Column(name = "pwdhash", nullable = false)
	private String passwordHash;

	@Column(name = "userstatus")
	private Integer userStatus = UserStatus.USER_ENABLED.value;

	@JsonIgnore
	@Column(name = "loginattempts")
	private Integer loginAttempts = 0;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "lastlogindt")
	private LocalDateTime lastLoginDate;

	@JsonIgnore
	@Column(name = "pwexpirationdt", nullable = false)
	private LocalDateTime passwordExpirationDate;

	@Column(name = "createtask")
	@Type(type = "numeric_boolean")
	private boolean createTask;

	@Column(name = "createdby", nullable = false)
	private String createdBy;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "createddt", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "updatedby", nullable = false)
	private String updatedBy;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column(name = "updateddt", nullable = false)
	private LocalDateTime updatedDate;

	@Transient
	private String roleName;

	@Transient
	private String displayDate;

	@Transient
	private String displayEndDate;

	@Transient
	private String groupName;

	@JsonIgnore
	@Transient
	private String pswdExpirationDate;

	@Transient
	private String userStatusString;

	@Transient
	private String userType;

	@Transient
	private boolean selected;

	@Transient
	private String orgName;

	//TODO change to Long
	@Column(name = "roleid")
	private Integer roleId;

	@Column(name = "orgid")
	private Long orgId;

	public User() {

	}

	public User(Long userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	@Transient
	private boolean expanded;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName != null ? userName.trim() : userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName != null ? firstName.trim() : firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName != null ? lastName.trim() : lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail != null ? userEmail.trim() : userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserSalt() {
		return userSalt;
	}

	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(Integer loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public LocalDateTime getPasswordExpirationDate() {
		return passwordExpirationDate;
	}

	public void setPasswordExpirationDate(LocalDateTime passwordExpirationDate) {
		this.passwordExpirationDate = passwordExpirationDate;
	}

	public boolean hasPasswordExpired() {
		return !getPasswordExpirationDate().isAfter(DateUtils.getCurrentUTCDateTime()) || getUserStatus().equals(4);
	}

	public String getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	public String getDisplayEndDate() {
		return displayEndDate;
	}

	public void setDisplayEndDate(String displayEndDate) {
		this.displayEndDate = displayEndDate;
	}

	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getPswdExpirationDate() {
		return pswdExpirationDate;
	}

	public void setPswdExpirationDate(String pswdExpirationDate) {
		this.pswdExpirationDate = pswdExpirationDate;
	}

	public String getUserStatusString() {
		return userStatusString;
	}

	public void setUserStatusString(String userStatusString) {
		this.userStatusString = userStatusString;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isCreateTask() {
		return createTask;
	}

	public void setCreateTask(boolean createTask) {
		this.createTask = createTask;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@PostLoad
	public void postLoad() {
		setUserStatusString(UserStatus.fromInteger(userStatus).stringValue);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@PreUpdate
	public void beforeUpdate() {
		if (ThreadLocalUtil.getUserName() != null) {
			setUpdatedBy(ThreadLocalUtil.getUserName());
		}
		setUpdatedDate(DateUtils.getCurrentUTCDateTime());
	}

	@PrePersist
	public void beforePersist() {
		setCreatedBy(ThreadLocalUtil.getUserName());
		setCreatedDate(DateUtils.getCurrentUTCDateTime());
		if (ThreadLocalUtil.getUserName() != null) {
			setUpdatedBy(ThreadLocalUtil.getUserName());
		}
		setUpdatedDate(DateUtils.getCurrentUTCDateTime());

	}

}
