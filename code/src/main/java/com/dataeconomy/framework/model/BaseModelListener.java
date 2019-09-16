package com.dataeconomy.framework.model;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.ThreadLocalUtil;

public class BaseModelListener {

	@PreUpdate
	public void beforeUpdate(BaseModel entity) {
		entity.setUpdatedBy(getUserName());
		entity.setUpdatedDate(DateUtils.getCurrentUTCDateTime());
	}

	@PrePersist
	public void beforePersist(BaseModel entity) {
		entity.setCreatedBy(getUserName());
		entity.setCreatedDate(DateUtils.getCurrentUTCDateTime());
		entity.setUpdatedBy(getUserName());
		entity.setUpdatedDate(DateUtils.getCurrentUTCDateTime());
	}

	/**
	 * Get user name from thread context - set in the session filter
	 * 
	 * @return
	 */
	private String getUserName() {
		return ThreadLocalUtil.getUserName();
	}

}
