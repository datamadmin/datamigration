package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.dataeconomy.framework.model.BaseModel;
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
@Table(name = "entitymaster", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@JsonRootName("entityMaster")
@XmlRootElement(name = "entitymaster")
public class EntityMaster extends BaseModel implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "entityid", nullable = false)
	@NotNull
	@ExcelHeader(name = "entity id")
	@JsonProperty("EntityID")
	private Integer entityID;

	@ExcelHeader(name = "entity name")
	@JsonProperty("EntityName")
	private String entityName;

	@ExcelHeader(name = "entity name abbr")
	@JsonProperty("EntityNameAbbr")
	private String entityNameAbbr;

	@ExcelHeader(name = "entity typeid")
	@JsonProperty("EntityTypeID")
	private Integer entityTypeID;

	@ExcelHeader(name = "addrline1")
	@JsonProperty("AddrLine1")
	private String addrLine1;

	@ExcelHeader(name = "addrline2")
	@JsonProperty("AddrLine2")
	private String addrLine2;

	@ExcelHeader(name = "addrline3")
	@JsonProperty("AddrLine3")
	private String addrLine3;

	@ExcelHeader(name = "city name")
	@JsonProperty("CityName")
	private String cityName;

	@ExcelHeader(name = "statecd")
	@JsonProperty("StateCd")
	private String stateCd;

	@ExcelHeader(name = "postalcd")
	@JsonProperty("PostalCd")
	private String postalCd;

	@ExcelHeader(name = "postal plus")
	@JsonProperty("PostalPlus")
	private String postalPlus;

	@ExcelHeader(name = "active")
	@JsonProperty("Active")
	private String active;

	@ExcelHeader(name = "effective date")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	@Column(name = "effectiveDt")
	private LocalDate effectiveDate;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@JsonProperty("EntityDescription")
	private String entityDescription;

	@Column(name = "userid")
	private Long userId;

	@Column(name = "status")
	private String status;
	
	
	@Column(name="policyid")
	private Long policyId;
	
	@Column(name="dataowner")
	private Long dataOwner;

	@JsonIgnore
	@OneToMany(mappedBy = "entityMaster")
	private List<EntityFileTypeXref> entityFileTypeXrefs;
	
	@OneToOne(mappedBy = "entityMaster",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private EntityMasterBusinessDataVal entityMasterBusinessDataVal;
	
	@OneToOne(mappedBy = "entityMaster",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private EntityMasterDataLifeCycleMgmt entityMasterDataLifeCycleMgmt;
	
	@OneToOne(mappedBy = "entityMaster",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private EntityMasterDataIssueMgmt entityMasterDataIssueMgmt;
	
	@OneToOne(mappedBy = "entityMaster",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private EntityMasterDataquality entityMasterDataQuaylity;
	
	@OneToMany(mappedBy = "entityMaster",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<EntityMasterSecurityControls> entityMasterSecurityControls = new HashSet<>();
	
	@OneToMany(mappedBy = "entityMaster",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<EntityMasterStakeholderRole> entityMasterStakeholderRole = new HashSet<>();
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "entitytypeid")
	private EntityType entityType;

	@Transient
	@JsonIgnore
	private String effectiveDtstr;

	@Transient
	@JsonIgnore
	private String errorMsg;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public EntityMaster(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.effectiveDate = effectiveDate;
		this.releaseNo = releaseNo;
	}

	public EntityMaster() {
	}

	@XmlTransient
	@JsonIgnore
	public String getErrormsg() {
		return errorMsg;
	}

	public void setErrormsg(String errormsg) {
		errorMsg = errormsg;
	}

	public Integer getEntityID() {
		return entityID;
	}

	@XmlTransient
	public String getEffectiveDtstr() {
		return effectiveDtstr;
	}

	public void setEffectiveDtstr(String effectiveDtstr) {
		this.effectiveDtstr = effectiveDtstr;
	}

	public void setEntityID(Integer entityID) {
		this.entityID = entityID;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityNameAbbr() {
		return entityNameAbbr;
	}

	public void setEntityNameAbbr(String entityNameAbbr) {
		this.entityNameAbbr = entityNameAbbr;
	}

	public Integer getEntityTypeID() {
		return entityTypeID;
	}

	public void setEntityTypeID(Integer entityTypeID) {
		this.entityTypeID = entityTypeID;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getAddrLine3() {
		return addrLine3;
	}

	public void setAddrLine3(String addrLine3) {
		this.addrLine3 = addrLine3;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String getPostalCd() {
		return postalCd;
	}

	public void setPostalCd(String postalCd) {
		this.postalCd = postalCd;
	}

	public String getPostalPlus() {
		return postalPlus;
	}

	public void setPostalPlus(String postalPlus) {
		this.postalPlus = postalPlus;
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

	@XmlTransient
	public List<EntityFileTypeXref> getEntityFileTypeXrefs() {
		return entityFileTypeXrefs;
	}

	public void setEntityFileTypeXrefs(List<EntityFileTypeXref> entityFileTypeXrefs) {
		this.entityFileTypeXrefs = entityFileTypeXrefs;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public String getEntityDescription() {
		return entityDescription;
	}

	public void setEntityDescription(String entityDescription) {
		this.entityDescription = entityDescription;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public EntityMasterBusinessDataVal getEntityMasterBusinessDataVal() {
		return entityMasterBusinessDataVal;
	}

	public void setEntityMasterBusinessDataVal(EntityMasterBusinessDataVal entityMasterBusinessDataVal) {
		this.entityMasterBusinessDataVal = entityMasterBusinessDataVal;
	}

	public EntityMasterDataLifeCycleMgmt getEntityMasterDataLifeCycleMgmt() {
		return entityMasterDataLifeCycleMgmt;
	}

	public void setEntityMasterDataLifeCycleMgmt(EntityMasterDataLifeCycleMgmt entityMasterDataLifeCycleMgmt) {
		this.entityMasterDataLifeCycleMgmt = entityMasterDataLifeCycleMgmt;
	}

	public EntityMasterDataquality getEntityMasterDataQuaylity() {
		return entityMasterDataQuaylity;
	}

	public void setEntityMasterDataQuaylity(EntityMasterDataquality entityMasterDataQuaylity) {
		this.entityMasterDataQuaylity = entityMasterDataQuaylity;
	}


	public Set<EntityMasterSecurityControls> getEntityMasterSecurityControls() {
		return entityMasterSecurityControls;
	}

	public void setEntityMasterSecurityControls(Set<EntityMasterSecurityControls> entityMasterSecurityControls) {
		this.entityMasterSecurityControls = entityMasterSecurityControls;
	}

	public Set<EntityMasterStakeholderRole> getEntityMasterStakeholderRole() {
		return entityMasterStakeholderRole;
	}

	public void setEntityMasterStakeholderRole(Set<EntityMasterStakeholderRole> entityMasterStakeholderRole) {
		this.entityMasterStakeholderRole = entityMasterStakeholderRole;
	}

	public Long getDataOwner() {
		return dataOwner;
	}

	public void setDataOwner(Long dataOwner) {
		this.dataOwner = dataOwner;
	}

	public EntityMasterDataIssueMgmt getEntityMasterDataIssueMgmt() {
		return entityMasterDataIssueMgmt;
	}

	public void setEntityMasterDataIssueMgmt(EntityMasterDataIssueMgmt entityMasterDataIssueMgmt) {
		this.entityMasterDataIssueMgmt = entityMasterDataIssueMgmt;
	}

}
