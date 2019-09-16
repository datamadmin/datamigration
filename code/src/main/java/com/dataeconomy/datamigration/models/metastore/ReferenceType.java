package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateTimeDeserializer;
import com.dataeconomy.framework.util.LocalDateTimeSerializer;
import com.dataeconomy.framework.util.ThreadLocalUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "referencetype", schema = "metastore")
// @Audited
public class ReferenceType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "referencetype")
	private String referenceTypeName;

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

	@OneToMany(mappedBy = "referencetype", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval=true)
	private List<ReferenceValue> referenceValues = new ArrayList<ReferenceValue>();

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

	public String getReferenceTypeName() {
		return referenceTypeName;
	}

	public void setReferenceTypeName(String referenceTypeName) {
		this.referenceTypeName = referenceTypeName;
	}

	public List<ReferenceValue> getReferenceValues() {
		return referenceValues;
	}

	public void setReferenceValues(List<ReferenceValue> referenceValues) {
		this.referenceValues = referenceValues;
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
