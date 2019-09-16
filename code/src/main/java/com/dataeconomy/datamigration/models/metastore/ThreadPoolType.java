package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
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

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.ExcelHeader;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "threadpooltype", schema = "metastore")
@JsonRootName("threadPoolType")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "threadpooltype")
public class ThreadPoolType implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "poolid", nullable = false)
	@NotNull
	@JsonProperty("PoolID")
	@ExcelHeader(name = "poolid")
	private Integer poolid;

	@Column(name = "description")
	@JsonProperty("Description")
	@ExcelHeader(name = "description")
	private String description;

	@Column(name = "effectivedate")
	@JsonProperty("EffectiveDate")
	@ExcelHeader(name = "effectivedate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@Column(name = "active")
	@JsonProperty("Active")
	@ExcelHeader(name = "active")
	private String active;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@JsonIgnore
	@OneToMany(mappedBy = "threadPoolType")
	private List<EntityFileTypeXref> entityFileTypeXrefs;

	@Transient
	@JsonIgnore
	private boolean addMode;

	@Transient
	@JsonIgnore
	private String effectiveDtstr;

	public ThreadPoolType() {
	}

	public ThreadPoolType(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
		this.effectiveDate = effectiveDate;
	}

	public Integer getPoolid() {
		return poolid;
	}

	public void setPoolid(Integer poolid) {
		this.poolid = poolid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
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

	public String getEffectiveDtstr() {
		return effectiveDtstr;
	}

	public void setEffectiveDtstr(String effectiveDtstr) {
		this.effectiveDtstr = effectiveDtstr;
	}

	@XmlTransient
	public List<EntityFileTypeXref> getEntityFileTypeXrefs() {
		return entityFileTypeXrefs;
	}

	public void setEntityFileTypeXrefs(List<EntityFileTypeXref> entityFileTypeXrefs) {
		this.entityFileTypeXrefs = entityFileTypeXrefs;
	}

}
