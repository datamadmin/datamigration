package com.dataeconomy.datamigration.models.core;

import javax.persistence.Column;
import javax.persistence.Id;

import com.dataeconomy.datamigration.models.metastore.AbstractModel;

public class Srcmts implements AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "src_name")
	private String srcName;

	@Column(name = "trustedscore")
	private Integer trustedScore;

	public String getSrcName() {
		return srcName;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public Integer getTrustedScore() {
		return trustedScore;
	}

	public void setTrustedScore(Integer trustedScore) {
		this.trustedScore = trustedScore;
	}

}
