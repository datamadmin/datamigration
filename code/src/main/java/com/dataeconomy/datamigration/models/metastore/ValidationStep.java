
package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "validationstep", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "validationStep")
public class ValidationStep implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "stepid", nullable = false)
	@NotNull
	@JsonProperty("StepID")
	private Integer stepID;

	@JsonProperty("StepName")
	private String stepName;

	@JsonProperty("StepDescription")
	private String stepDescription;

	@JsonProperty("JobName")
	private String jobName;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("Effectivedate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	

	@Transient
	@JsonIgnore
	private String effectiveDtstr;

	@Column(name = "releasenum", nullable = false)
	@ExcelHeader(name = "ReleaseNum")
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public ValidationStep(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.releaseNo = releaseNo;
		this.effectiveDate = effectiveDate;
	}

	public ValidationStep() {

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@XmlTransient
	public String getEffectiveDtstr() {
		return effectiveDtstr;
	}

	public void setEffectiveDtstr(String effectiveDtstr) {
		this.effectiveDtstr = effectiveDtstr;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getStepDescription() {
		return stepDescription;
	}

	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
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

}
