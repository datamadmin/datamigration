package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateTimeDeserializer;
import com.dataeconomy.framework.util.LocalDateTimeSerializer;
import com.dataeconomy.framework.util.ThreadLocalUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "referencevalue", schema = "metastore")
//@Audited
public class ReferenceValue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "referencetypeid")
	private Integer referenceTypeId;

	@Column(name = "referencecode")
	private String referenceCode;

	@Column(name = "referencedescription")
	private String referenceDescription;

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

	// bi-directional many-to-one association to Dataquality
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "referenceTypeId", insertable = false, updatable = false)
	private ReferenceType referencetype;

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

	
	public Integer getReferenceTypeId() {
		return referenceTypeId;
	}

	public void setReferenceTypeId(Integer referenceTypeId) {
		this.referenceTypeId = referenceTypeId;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getReferenceDescription() {
		return referenceDescription;
	}

	public void setReferenceDescription(String referenceDescription) {
		this.referenceDescription = referenceDescription;
	}

	public ReferenceType getReferencetype() {
		return referencetype;
	}

	public void setReferencetype(ReferenceType referencetype) {
		this.referencetype = referencetype;
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
