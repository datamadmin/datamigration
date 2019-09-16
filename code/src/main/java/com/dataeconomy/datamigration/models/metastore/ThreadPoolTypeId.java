package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThreadPoolTypeId implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("PoolID")
	private Integer poolid;

	public Integer getPoolid() {
		return poolid;
	}

	public void setPoolid(Integer poolid) {
		this.poolid = poolid;
	}

}
