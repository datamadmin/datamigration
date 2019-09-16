package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "entityfilerulexref", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityfilerulexref")

public class EntityFileRuleXref implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "entityfileruleid", nullable = false)
	@JsonProperty("EntityfileRuleId")
	private Integer entityfileRuleId;

	@JsonProperty("EntityFileTypeID")
	@Column(name = "entityfiletypeid")
	private Integer entityFileTypeID;

	@JsonProperty("StepID")
	@Column(name = "stepid")
	private Integer stepID;

	@JsonProperty("RuleID")
	@Column(name = "ruleid")
	private Integer ruleID;

	@JsonProperty("FailLevel")
	private String failLevel;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("BaseMessage")
	private String baseMessage;

	@JsonProperty("BaseColumn")
	private String baseColumn;

	@JsonProperty("ParamHash")
	private String paramHash;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo = 1;

	@ManyToOne
	@JoinColumn(name = "entityfiletypeid", insertable = false, updatable = false)
	@JsonIgnore
	private EntityFileTypeXref entityFileTypeXref;

	@ManyToOne
	@JoinColumn(name = "ruleid", insertable = false, updatable = false)
	@JsonIgnore
	private ValidationRules entityFileValidationRule;

	@ManyToOne
	@JoinColumn(name = "stepid", insertable = false, updatable = false)
	@JsonIgnore
	private ValidationStep validationStep;

	@OneToMany(mappedBy = "entityFileRuleXref", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<EntityFileRuleParam> entityFileRuleParams = new ArrayList<>();

	@XmlTransient
	public EntityFileTypeXref getEntityFileTypeXref() {
		return entityFileTypeXref;
	}

	public void setEntityFileTypeXref(EntityFileTypeXref entityFileTypeXref) {
		this.entityFileTypeXref = entityFileTypeXref;
	}

	@XmlTransient
	public ValidationRules getEntityFileValidationRule() {
		return entityFileValidationRule;
	}

	public void setEntityFileValidationRule(ValidationRules entityFileValidationRule) {
		this.entityFileValidationRule = entityFileValidationRule;
	}

	@XmlTransient
	public ValidationStep getValidationStep() {
		return validationStep;
	}

	public void setValidationStep(ValidationStep validationStep) {
		this.validationStep = validationStep;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public Integer getEntityfileRuleId() {
		return entityfileRuleId;
	}

	public void setEntityfileRuleId(Integer entityfileRuleId) {
		this.entityfileRuleId = entityfileRuleId;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

	public String getFailLevel() {
		return failLevel;
	}

	public void setFailLevel(String failLevel) {
		this.failLevel = failLevel;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getParamHash() {
		return paramHash;
	}

	public void setParamHash(String paramHash) {
		this.paramHash = paramHash;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getBaseMessage() {
		return baseMessage;
	}

	public void setBaseMessage(String baseMessage) {
		this.baseMessage = baseMessage;
	}

	public String getBaseColumn() {
		return baseColumn;
	}

	public void setBaseColumn(String baseColumn) {
		this.baseColumn = baseColumn;
	}

	public List<EntityFileRuleParam> getEntityFileRuleParams() {
		return entityFileRuleParams;
	}

	public void setEntityFileRuleParams(List<EntityFileRuleParam> entityFileRuleParams) {
		this.entityFileRuleParams = entityFileRuleParams;
	}

	public Integer getRuleId() {
		return ruleID;
	}

	public void setRuleId(Integer ruleID) {
		this.ruleID = ruleID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ruleID == null) ? 0 : ruleID.hashCode());
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
		EntityFileRuleXref other = (EntityFileRuleXref) obj;
		if (ruleID == null) {
			if (other.ruleID != null)
				return false;
		} else if (!ruleID.equals(other.ruleID))
			return false;
		return true;
	}

}
