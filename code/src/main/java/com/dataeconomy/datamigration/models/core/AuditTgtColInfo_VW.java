package com.dataeconomy.datamigration.models.core;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the audittgtcolinfo database table.
 * 
 */
@Entity
@Table(name="vaudittgtcolinfo",schema="datahub")
public class AuditTgtColInfo_VW implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="defcolname")
	private String defColName;

	@Column(name="lastupdby")
	private String lastUpdBy;

	@Column(name="lastupddt")
	private Timestamp lastUpdDt;

	private String modifiedvalue;

	@Id
	@Column(name="revid")
	private int revId;

	@Column(name="tgtcolid")
	private String tgtcolId;

	@Column(name="tgtrecid")
	private String tgtrecId;

	public AuditTgtColInfo_VW() {
	}

	public String getDefColName() {
		return this.defColName;
	}

	public void setDefColName(String defColName) {
		this.defColName = defColName;
	}

	public String getLastUpdBy() {
		return this.lastUpdBy;
	}

	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}

	public Timestamp getLastUpdDt() {
		return this.lastUpdDt;
	}

	public void setLastUpdDt(Timestamp lastUpdDt) {
		this.lastUpdDt = lastUpdDt;
	}

	public String getModifiedvalue() {
		return this.modifiedvalue;
	}

	public void setModifiedvalue(String modifiedvalue) {
		this.modifiedvalue = modifiedvalue;
	}

	public int getRevId() {
		return this.revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public String getTgtcolId() {
		return this.tgtcolId;
	}

	public void setTgtcolId(String tgtcolId) {
		this.tgtcolId = tgtcolId;
	}

	public String getTgtrecId() {
		return this.tgtrecId;
	}

	public void setTgtrecId(String tgtrecId) {
		this.tgtrecId = tgtrecId;
	}

}