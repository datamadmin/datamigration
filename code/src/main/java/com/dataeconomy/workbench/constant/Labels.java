package com.dataeconomy.workbench.constant;

import com.dataeconomy.framework.util.BasePropertyEnum;

/**
 * 
 * @author Guvala
 *
 */
public enum Labels implements BasePropertyEnum {
	SYSTEMEXCEPTION("systemException");

	public final String key;
	public final String bundle = "com.dataeconomy.businessDWB.labels";

	Labels(String key) {
		this.key = key;
	}

	@Override
	public String getBundle() {
		return bundle;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public Integer getStatusCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
