package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "entityfileruleparam", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityfileruleparam")
public class EntityFileRuleParam implements AbstractModel {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@JsonIgnore
	private EntityFileRuleParamkey id;

	@Column(name = "entityfileruleid", insertable = false, updatable = false)
	@JsonProperty("EntityFileRuleID")
	private Integer entityFileRuleId;

	@Column(name = "paramid", nullable = false, insertable = false, updatable = false)
	@JsonProperty("ParamID")
	private String paramID;

	@ManyToOne
	@JoinColumn(name = "entityfileruleid")
	@MapsId("entityFileRuleId")
	@JsonIgnore
	private EntityFileRuleXref entityFileRuleXref;

	@JsonProperty("ParamColName")
	@Column(name = "paramcolname")
	private String paramColName;

	@JsonProperty("ParamAliasName")
	@Column(name = "paramaliasname")
	private String paramAliasName;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo = 1;

	public EntityFileRuleXref getEntityFileRuleXref() {
		return entityFileRuleXref;
	}

	public void setEntityFileRuleXref(EntityFileRuleXref entityFileRuleXref) {
		this.entityFileRuleXref = entityFileRuleXref;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public Integer getEntityFileRuleId() {
		return entityFileRuleId;
	}

	public void setEntityFileRuleId(Integer entityFileRuleId) {
		this.entityFileRuleId = entityFileRuleId;
	}

	public String getParamID() {
		return paramID;
	}

	public void setParamID(String paramID) {
		this.paramID = paramID;
	}

	public String getParamColName() {
		return paramColName;
	}

	public void setParamColName(String paramColName) {
		this.paramColName = paramColName;
	}

	public String getParamAliasName() {
		return paramAliasName;
	}

	public void setParamAliasName(String paramAliasName) {
		this.paramAliasName = paramAliasName;
	}

	public EntityFileRuleParamkey getId() {
		return id;
	}

	public void setId(EntityFileRuleParamkey id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EntityFileRuleParam other = (EntityFileRuleParam) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
