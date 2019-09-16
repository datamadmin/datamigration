package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DQIndexQuery", schema = "metastore")
public class DQIndexQuery {

	@Id
	public String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
}
