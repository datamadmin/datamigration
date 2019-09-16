package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "threadthreadpoolxref", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@JsonRootName("threadThreadPoolXref")
@XmlRootElement(name = "threadthreadpoolxref")

public class ThreadThreadPoolXref implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonProperty("Key")
	private ThreadThreadPoolXrefKey threadThreadPoolXrefKey;

	@Column(name = "thread", insertable = false, updatable = false)
	@JsonProperty("Thread")
	private Integer thread;

	@Column(name = "poolid", insertable = false, updatable = false)
	@JsonProperty("PoolID")
	private Integer poolid;

	@JsonProperty("EffectiveDate")
	@Column(name = "effectivedate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("Active")
	@Column(name = "active")
	private String active;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private String effectiveDtstr;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public ThreadThreadPoolXref() {

	}

	public ThreadThreadPoolXref(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
		this.effectiveDate = effectiveDate;
	}
	// getters and setters

	public ThreadThreadPoolXrefKey getThreadThreadPoolXrefKey() {
		return threadThreadPoolXrefKey;
	}

	public void setThreadThreadPoolXrefKey(ThreadThreadPoolXrefKey threadThreadPoolXrefKey) {
		this.threadThreadPoolXrefKey = threadThreadPoolXrefKey;
	}

	public Integer getThread() {
		return thread;
	}

	public void setThread(Integer thread) {
		this.thread = thread;
	}

	public Integer getPoolid() {
		return poolid;
	}

	public void setPoolid(Integer poolid) {
		this.poolid = poolid;
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

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public String getEffectiveDtstr() {
		return effectiveDtstr;
	}

	public void setEffectiveDtstr(String effectiveDtstr) {
		this.effectiveDtstr = effectiveDtstr;
	}

}
