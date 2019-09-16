package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateTimeDeserializer;
import com.dataeconomy.framework.util.LocalDateTimeSerializer;
import com.dataeconomy.framework.util.ThreadLocalUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "referencelookup", schema = "metastore")
@Audited
public class ReferenceLookup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "referencetype")
	private String referenceType;

	@Column(name = "referencevalue")
	private String referenceValue;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getReferenceValue() {
		return referenceValue;
	}

	public void setReferenceValue(String referenceValue) {
		this.referenceValue = referenceValue;
	}

	@PreUpdate
	public void beforeUpdate() {
		setUpdatedBy(ThreadLocalUtil.getUserName());
		setUpdatedDate(DateUtils.getCurrentUTCDateTime());
	}

	@PrePersist
	public void beforePersist() {
		setCreatedBy(ThreadLocalUtil.getUserName());
		setCreatedDate(DateUtils.getCurrentUTCDateTime());
		setUpdatedBy(ThreadLocalUtil.getUserName());
		setUpdatedDate(DateUtils.getCurrentUTCDateTime());
	}

}
