package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "validationrules", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityfilevalidationrule")
public class ValidationRules implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ruleid", nullable = false)
	@JsonProperty("RuleID")
	private Integer ruleID;

	@JsonProperty("RuleTypeID")
	private Integer ruleTypeID;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("RuleValue")
	private String ruleValue;

	@Column(name = "rulename")
	@JsonProperty("RuleName")
	private String ruleName;

	@JsonProperty("RuleDescription")
	private String ruleDescription;

	@JsonProperty("RuleforTable")
	private String ruleforTable;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Column(name = "dimensionid", nullable = false)
	@JsonProperty("DimensionId")
	private Long dimensionId;

	@JsonIgnore
	@OneToMany(mappedBy = "entityFileValidationRule")
	private List<EntityFileRuleXref> entityFileRuleXrefs;

	@ManyToOne
	@JoinColumn(name = "ruletypeid")
	private RuleType ruleType;

	// getter and setter

	public Integer getReleaseNo() {
		return releaseNo;
	}

	@XmlTransient
	public RuleType getRuleType() {
		return ruleType;
	}

	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public Integer getRuleID() {
		return ruleID;
	}

	public void setRuleID(Integer ruleID) {
		this.ruleID = ruleID;
	}

	public Integer getRuleTypeID() {
		return ruleTypeID;
	}

	public void setRuleTypeID(Integer ruleTypeID) {
		this.ruleTypeID = ruleTypeID;
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

	public String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}

	public String getRuleDescription() {
		return ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	public String getRuleforTable() {
		return ruleforTable;
	}

	public void setRuleforTable(String ruleforTable) {
		this.ruleforTable = ruleforTable;
	}

	public Long getDimensionId() {
		return dimensionId;
	}

	public void setDimensionId(Long dimensionId) {
		this.dimensionId = dimensionId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
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
		ValidationRules other = (ValidationRules) obj;
		if (ruleID == null) {
			if (other.ruleID != null)
				return false;
		} else if (!ruleID.equals(other.ruleID))
			return false;
		return true;
	}

}
