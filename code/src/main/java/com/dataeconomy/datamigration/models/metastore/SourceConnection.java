package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sourceconnection", schema = "metastore")
@NamedQueries({
		@NamedQuery(name = "findSourceConnectionByFileTypeId", query = "from SourceConnection sc where sc.entityFileTypeID = :entityFileTypeID") })
public class SourceConnection implements AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String FIND_SOURCECONNECTION_BY_FILETYPE_ID = "findSourceConnectionByFileTypeId";

	@Id
	@Column(name = "connection_id")
	private Integer connectionId;

	@Column(name = "connection_type")
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

	@Transient
	private String password;

	@Column(name = "additional_jdbc_parms")
	private String additionalJdbcParams;

	@Column(name = "query")
	private String query;

	@Column(name = "additional_comments")
	private String additionalComments;

	@Column(name = "entityfiletypeid")
	private Integer entityFileTypeID;

	@Column(name = "hivehost")
	private String hiveHost;

	@Column(name = "hiveport")
	private String hivePort;

	@Column(name = "hive_principal")
	private String hivePrincipal;

	@Column(name = "hive_namenode_principal")
	private String hiveNamenodePrincipal;

	@Column(name = "hive_resource_manager_principal")
	private String hiveResourceManagerPrincipal;

	@Column(name = "hive_kerberos_principal")
	private String hivekerberosPrincipal;

	@Column(name = "hive_kerberos_keytab")
	private String hivekerberoskeytab;

	@Column(name = "hive_database")
	private String hiveDatabase;

	@Column(name = "impalahost")
	private String impalahost;

	@Column(name = "impalaport")
	private String impalaport;

	@Column(name = "impalausername")
	private String impalausername;

	@Column(name = "impaladatabase")
	private String impaladatabase;

	@Column(name = "impalaprincipal")
	private String impalaprincipal;
	
	@Column(name = "pwdhash")
	private String pwdhash;


	public String getPwdhash() {
		return pwdhash;
	}

	public void setPwdhash(String pwdhash) {
		this.pwdhash = pwdhash;
	}

	@Transient
	private Integer releaseNo;

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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public Integer getReleaseNo() {
		return releaseNo;
	}

	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}

	public String getHivePrincipal() {
		return hivePrincipal;
	}

	public void setHivePrincipal(String hivePrincipal) {
		this.hivePrincipal = hivePrincipal;
	}

	public String getHiveNamenodePrincipal() {
		return hiveNamenodePrincipal;
	}

	public void setHiveNamenodePrincipal(String hiveNamenodePrincipal) {
		this.hiveNamenodePrincipal = hiveNamenodePrincipal;
	}

	public String getHiveResourceManagerPrincipal() {
		return hiveResourceManagerPrincipal;
	}

	public void setHiveResourceManagerPrincipal(String hiveResourceManagerPrincipal) {
		this.hiveResourceManagerPrincipal = hiveResourceManagerPrincipal;
	}

	public String getHivekerberosPrincipal() {
		return hivekerberosPrincipal;
	}

	public void setHivekerberosPrincipal(String hivekerberosPrincipal) {
		this.hivekerberosPrincipal = hivekerberosPrincipal;
	}

	public String getHivekerberoskeytab() {
		return hivekerberoskeytab;
	}

	public void setHivekerberoskeytab(String hivekerberoskeytab) {
		this.hivekerberoskeytab = hivekerberoskeytab;
	}

	public String getHiveDatabase() {
		return hiveDatabase;
	}

	public void setHiveDatabase(String hiveDatabase) {
		this.hiveDatabase = hiveDatabase;
	}

	public String getHiveHost() {
		return hiveHost;
	}

	public void setHiveHost(String hiveHost) {
		this.hiveHost = hiveHost;
	}

	public String getHivePort() {
		return hivePort;
	}

	public void setHivePort(String hivePort) {
		this.hivePort = hivePort;
	}

	public String getImpalahost() {
		return impalahost;
	}

	public void setImpalahost(String impalahost) {
		this.impalahost = impalahost;
	}

	public String getImpalaport() {
		return impalaport;
	}

	public void setImpalaport(String impalaport) {
		this.impalaport = impalaport;
	}

	public String getImpalausername() {
		return impalausername;
	}

	public void setImpalausername(String impalausername) {
		this.impalausername = impalausername;
	}

	public String getImpaladatabase() {
		return impaladatabase;
	}

	public void setImpaladatabase(String impaladatabase) {
		this.impaladatabase = impaladatabase;
	}

	public String getImpalaprincipal() {
		return impalaprincipal;
	}

	public void setImpalaprincipal(String impalaprincipal) {
		this.impalaprincipal = impalaprincipal;
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
		SourceConnection other = (SourceConnection) obj;
		if (connectionId == null) {
			if (other.connectionId != null)
				return false;
		} else if (!connectionId.equals(other.connectionId))
			return false;
		return true;
	}

}
