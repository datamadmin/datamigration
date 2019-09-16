package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "entityfilevalidationruledb", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityFileValidationRuleVw")
public class EntityFileValidationRuleVw implements AbstractModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "efvrid", nullable = false)
	@JsonProperty("efvrid")
	private Integer efvrid;

	@JsonProperty("FileMask")
	private String fileMask;

	@JsonProperty("EntityName")
	private String entityName;

	@JsonProperty("HSFileType")
	private String hSFileType;

	@JsonProperty("StepName")
	private String stepName;

	@JsonProperty("FailLevel")
	private String failLevel;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("RuleType")
	private String ruleType;

	@JsonProperty("RawRule")
	private String rawRule;

	@JsonProperty("RuleParam1")
	private String ruleParam1;

	@JsonProperty("RuleParam2")
	private String ruleParam2;

	@JsonProperty("RuleParam3")
	private String ruleParam3;

	@JsonProperty("RuleParam4")
	private String ruleParam4;

	@JsonProperty("RuleParam5")
	private String ruleParam5;

	@JsonProperty("RuleParam6")
	private String ruleParam6;

	@JsonProperty("RuleParam7")
	private String ruleParam7;

	@JsonProperty("RuleParam8")
	private String ruleParam8;

	@JsonProperty("RuleParam9")
	private String ruleParam9;

	@JsonProperty("RuleParam10")
	private String ruleParam10;

	@JsonProperty("RuleValue")
	private String ruleValue;

	@JsonProperty("BaseColumn")
	private String baseColumn;

	@JsonProperty("BaseMessage")
	private String baseMessage;

	@JsonProperty("WhomadeChange")
	private String whoMadeChange;

	@JsonProperty("ReasonforChange")
	private String reasonForChange;

	@JsonProperty("EntityFileTypeId")
	private Integer entityFileTypeId;

	@JsonProperty("StepId")
	private Integer stepId;

	@JsonProperty("RuleTypeId")
	private Integer ruleTypeId;

	@JsonProperty("RuleDesc")
	private String ruleDesc;

	@JsonProperty("RuleForTable")
	private String ruleForTable;

	@JsonProperty("Comments")
	private String comments;

	@Transient
	@JsonIgnore
	private String effectiveDtstr;

	@Transient
	@JsonIgnore
	private boolean addMode;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	public EntityFileValidationRuleVw(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.effectiveDate = effectiveDate;
		this.releaseNo = releaseNo;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public EntityFileValidationRuleVw() {

	}

	@XmlTransient
	public String getEffectiveDtstr() {
		return effectiveDtstr;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getRuleForTable() {
		return ruleForTable;
	}

	public void setRuleForTable(String ruleForTable) {
		this.ruleForTable = ruleForTable;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setEffectiveDtstr(String effectiveDtstr) {
		this.effectiveDtstr = effectiveDtstr;
	}

	public Integer getEfvrid() {
		return efvrid;
	}

	public void setEfvrid(Integer efvrid) {
		this.efvrid = efvrid;
	}

	public String getFileMask() {
		return fileMask;
	}

	public void setFileMask(String fileMask) {
		this.fileMask = fileMask;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getHSFileType() {
		return hSFileType;
	}

	public void setHSFileType(String hSFileType) {
		this.hSFileType = hSFileType;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
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

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRawRule() {
		return rawRule;
	}

	public void setRawRule(String rawRule) {
		this.rawRule = rawRule;
	}

	public String getRuleParam1() {
		return ruleParam1;
	}

	public void setRuleParam1(String ruleParam1) {
		this.ruleParam1 = ruleParam1;
	}

	public String getRuleParam2() {
		return ruleParam2;
	}

	public void setRuleParam2(String ruleParam2) {
		this.ruleParam2 = ruleParam2;
	}

	public String getRuleParam3() {
		return ruleParam3;
	}

	public void setRuleParam3(String ruleParam3) {
		this.ruleParam3 = ruleParam3;
	}

	public String getRuleParam4() {
		return ruleParam4;
	}

	public void setRuleParam4(String ruleParam4) {
		this.ruleParam4 = ruleParam4;
	}

	public String getRuleParam5() {
		return ruleParam5;
	}

	public void setRuleParam5(String ruleParam5) {
		this.ruleParam5 = ruleParam5;
	}

	public String getRuleParam6() {
		return ruleParam6;
	}

	public void setRuleParam6(String ruleParam6) {
		this.ruleParam6 = ruleParam6;
	}

	public String getRuleParam7() {
		return ruleParam7;
	}

	public void setRuleParam7(String ruleParam7) {
		this.ruleParam7 = ruleParam7;
	}

	public String getRuleParam8() {
		return ruleParam8;
	}

	public void setRuleParam8(String ruleParam8) {
		this.ruleParam8 = ruleParam8;
	}

	public String getRuleParam9() {
		return ruleParam9;
	}

	public void setRuleParam9(String ruleParam9) {
		this.ruleParam9 = ruleParam9;
	}

	public String getRuleParam10() {
		return ruleParam10;
	}

	public void setRuleParam10(String ruleParam10) {
		this.ruleParam10 = ruleParam10;
	}

	public String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}

	public String getBaseColumn() {
		return baseColumn;
	}

	public void setBaseColumn(String baseColumn) {
		this.baseColumn = baseColumn;
	}

	public String getBaseMessage() {
		return baseMessage;
	}

	public void setBaseMessage(String baseMessage) {
		this.baseMessage = baseMessage;
	}

	public String getWhoMadeChange() {
		return whoMadeChange;
	}

	public void setWhoMadeChange(String whoMadeChange) {
		this.whoMadeChange = whoMadeChange;
	}

	public String getReasonForChange() {
		return reasonForChange;
	}

	public void setReasonForChange(String reasonForChange) {
		this.reasonForChange = reasonForChange;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@XmlTransient
	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	public Integer getEntityFileTypeId() {
		return entityFileTypeId;
	}

	public void setEntityFileTypeId(Integer entityFileTypeId) {
		this.entityFileTypeId = entityFileTypeId;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	public Integer getRuleTypeId() {
		return ruleTypeId;
	}

	public void setRuleTypeId(Integer ruleTypeId) {
		this.ruleTypeId = ruleTypeId;
	}

}
