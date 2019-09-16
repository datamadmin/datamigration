package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "vEntityFileTypeWebService", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
public class EntityFileTypeWebServiceVw implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	EntityFileTypeWebServiceVwKey entityFileTypeWebServiceVwKey;

	@Column(name = "webserviceid", insertable = false, updatable = false)
	@JsonProperty("WebServiceID")
	private Integer webServiceID;

	@Column(name = "entityname", insertable = false, updatable = false)
	@JsonProperty("entityname")
	private String entityname;

	@Column(name = "hsfiletype", insertable = false, updatable = false)
	@JsonProperty("hsfiletype")
	private String hsfiletype;

	@Column(name = "filemask", insertable = false, updatable = false)
	@JsonProperty("filemask")
	private String filemask;

	@Column(name = "entityfiletypeid", insertable = false, updatable = false)
	@JsonProperty("entityfiletypeid")
	private Integer entityfiletypeid;

	@JsonProperty("StepID")
	private Integer stepID;

	@JsonProperty("SeqOrder")
	private Integer seqOrder;

	@JsonProperty("EndPointService")
	private String endPointService;

	@JsonProperty("SOAPAction")
	private String sOAPAction;

	@JsonProperty("AuthUser")
	private String authUser;

	@JsonProperty("AuthPass")
	private String authPass;

	@JsonProperty("ProxyHost")
	private String proxyHost;

	@JsonProperty("proxyPort")
	private String proxyPort;

	@JsonProperty("proxyuser")
	private String proxyuser;

	@JsonProperty("proxypass")
	private String proxypass;

	@JsonProperty("methodName")
	private String methodName;

	@JsonProperty("callTimeout")
	private Integer callTimeout;

	@JsonProperty("Payload")
	private String payload;

	@JsonProperty("Active")
	private String active;

	@JsonProperty("EffectiveDate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("XPathRootNode")
	private String xPathRootNode;

	@JsonProperty("XPathChildNode")
	private String xPathChildNode;

	@JsonProperty("XPathReturnNode")
	private String xPathReturnNode;

	@JsonProperty("exemptCondition")
	@Column(name = "exemptcondition")
	private String exemptCondition;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public EntityFileTypeWebServiceVw() {

	}

	public EntityFileTypeWebServiceVw(LocalDate effectiveDate, Integer releaseNo, boolean addMode) {
		this.effectiveDate = effectiveDate;
		this.releaseNo = releaseNo;
		this.addMode = addMode;
	}

	// getters and setters

	public Integer getWebServiceID() {
		return webServiceID;
	}

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
	}

	public String getEntityname() {
		return entityname;
	}

	public void setEntityname(String entityname) {
		this.entityname = entityname;
	}

	public String getHsfiletype() {
		return hsfiletype;
	}

	public void setHsfiletype(String hsfiletype) {
		this.hsfiletype = hsfiletype;
	}

	public String getFilemask() {
		return filemask;
	}

	public void setFilemask(String filemask) {
		this.filemask = filemask;
	}

	public Integer getEntityfiletypeid() {
		return entityfiletypeid;
	}

	public void setEntityfiletypeid(Integer entityfiletypeid) {
		this.entityfiletypeid = entityfiletypeid;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

	public Integer getSeqOrder() {
		return seqOrder;
	}

	public void setSeqOrder(Integer seqOrder) {
		this.seqOrder = seqOrder;
	}

	public String getEndPointService() {
		return endPointService;
	}

	public void setEndPointService(String endPointService) {
		this.endPointService = endPointService;
	}

	public String getsOAPAction() {
		return sOAPAction;
	}

	public void setsOAPAction(String sOAPAction) {
		this.sOAPAction = sOAPAction;
	}

	public String getAuthUser() {
		return authUser;
	}

	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}

	public String getAuthPass() {
		return authPass;
	}

	public void setAuthPass(String authPass) {
		this.authPass = authPass;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public String getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyuser() {
		return proxyuser;
	}

	public void setProxyuser(String proxyuser) {
		this.proxyuser = proxyuser;
	}

	public String getProxypass() {
		return proxypass;
	}

	public void setProxypass(String proxypass) {
		this.proxypass = proxypass;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Integer getCallTimeout() {
		return callTimeout;
	}

	public void setCallTimeout(Integer callTimeout) {
		this.callTimeout = callTimeout;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
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

	public String getxPathRootNode() {
		return xPathRootNode;
	}

	public void setxPathRootNode(String xPathRootNode) {
		this.xPathRootNode = xPathRootNode;
	}

	public String getxPathChildNode() {
		return xPathChildNode;
	}

	public void setxPathChildNode(String xPathChildNode) {
		this.xPathChildNode = xPathChildNode;
	}

	public String getxPathReturnNode() {
		return xPathReturnNode;
	}

	public void setxPathReturnNode(String xPathReturnNode) {
		this.xPathReturnNode = xPathReturnNode;
	}

	public EntityFileTypeWebServiceVwKey getEntityFileTypeWebServiceVwKey() {
		return entityFileTypeWebServiceVwKey;
	}

	public void setEntityFileTypeWebServiceVwKey(EntityFileTypeWebServiceVwKey entityFileTypeWebServiceVwKey) {
		this.entityFileTypeWebServiceVwKey = entityFileTypeWebServiceVwKey;
	}

	public String getExemptCondition() {
		return exemptCondition;
	}

	public void setExemptCondition(String exemptCondition) {
		this.exemptCondition = exemptCondition;
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

}
