package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "entityfiletypewebservice", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityfiletypewebservice")
@JsonRootName("entityFileTypeWebService")
public class EntityFileTypeWebService implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name = "webserviceid", nullable = false)
	@JsonProperty("WebServiceID")
	private Integer webServiceID;

	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;

	@JsonProperty("StepID")
	private Integer stepID;

	@JsonProperty("SeqOrder")
	private Integer seqOrder;

	@JsonProperty("EndPointService")
	private String endPointService;

	@JsonProperty("SOAPAction")
	private String soapAction;

	@JsonProperty("AuthUser")
	private String authUser;

	@JsonProperty("AuthPass")
	private String authPass;

	@JsonProperty("ProxyHost")
	private String proxyHost;

	@JsonProperty("ProxyPort")
	private String proxyPort;

	@JsonProperty("Proxyuser")
	private String proxyuser;

	@JsonProperty("Proxypass")
	private String proxypass;

	@JsonProperty("MethodName")
	private String methodName;

	@JsonProperty("CallTimeout")
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

	public Integer getWebServiceID() {
		return webServiceID;
	}

	// Getters & setters

	public void setWebServiceID(Integer webServiceID) {
		this.webServiceID = webServiceID;
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

	public String getSoapAction() {
		return soapAction;
	}

	public void setSoapAction(String soapAction) {
		this.soapAction = soapAction;
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

}
