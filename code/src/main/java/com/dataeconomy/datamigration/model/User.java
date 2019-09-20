package com.dataeconomy.datamigration.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity(name = "dmu_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "USER_ROLE")
	private String userRole;
	@Column(name = "EMAIL_ID")
	private String emailid;
	@Column(name = "password")
	private String password;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "updatedby")
	private String updatedBy;
	@Column(name = "updateddate")
	private LocalDateTime updatedDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	@Column(name = "isnew")
	private String isNew;



	@PrePersist
	public void beforePersist() {
		setCreatedBy("Admin");
		setCreatedDate(LocalDateTime.now(ZoneOffset.UTC));
		setUpdatedDate(LocalDateTime.now(ZoneOffset.UTC));

	}


}
