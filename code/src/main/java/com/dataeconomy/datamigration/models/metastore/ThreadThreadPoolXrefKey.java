package com.dataeconomy.datamigration.models.metastore;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;
@Embeddable
public class ThreadThreadPoolXrefKey implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "thread")
	@JsonProperty("Thread")
	private Integer thread;

	@Column(name = "poolid")
	@JsonProperty("PoolID")
	private Integer poolid;

	// setters and getters

	
	

	public Integer getPoolid() {
		return poolid;
	}



	public void setPoolid(Integer poolid) {
		this.poolid = poolid;
	}



	public Integer getThread() {
		return thread;
	}



	public void setThread(Integer thread) {
		this.thread = thread;
	}	

}
