package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author GASWANTH
 *
 */
@Entity
@Table(name = "sourceconfiguration", schema = "metastore")
public class SourceConfiguration implements Serializable {

	private static final long serialVersionUID = 5222055132047270005L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "connectionid")
	private Integer connectionId;

	@Column(name = "connectiontype")
	private String connectionType;

	@Column(name = "hostname")
	private String hostName;

	@Column(name = "port")
	private String port;

	@Column(name = "`schema`")
	private String schema;

	@Column(name = "`database`")
	private String database;

	@Column(name = "username")
	private String userName;

	@Column(name = "additionaljdbcparams")
	private String additionalJdbcParams;

	@Column(name = "additionalcomments")
	private String additionalComments;

	@JsonIgnore
	@Column(name = "connectionsalt", nullable = false)
	private String connectionSalt;

	@JsonIgnore
	@Column(name = "pwdhash", nullable = false)
	private String passwordHash;

	@Transient
	private String password;

	public Integer getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Integer connectionId) {
		this.connectionId = connectionId;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdditionalJdbcParams() {
		return additionalJdbcParams;
	}

	public void setAdditionalJdbcParams(String additionalJdbcParams) {
		this.additionalJdbcParams = additionalJdbcParams;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getConnectionSalt() {
		return connectionSalt;
	}

	public void setConnectionSalt(String connectionSalt) {
		this.connectionSalt = connectionSalt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectionId == null) ? 0 : connectionId.hashCode());
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
		SourceConfiguration other = (SourceConfiguration) obj;
		if (connectionId == null) {
			if (other.connectionId != null)
				return false;
		} else if (!connectionId.equals(other.connectionId))
			return false;
		return true;
	}

}
