package com.dataeconomy.datamigration.models.config;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FunctionMapping implements Serializable {

	/**
	 * serial version id.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String tablename;

	private String readwrite;

	private String viewmode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getReadwrite() {
		return readwrite;
	}

	public void setReadwrite(String readwrite) {
		this.readwrite = readwrite;
	}

	public String getViewmode() {
		return viewmode;
	}

	public void setViewmode(String viewmode) {
		this.viewmode = viewmode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
