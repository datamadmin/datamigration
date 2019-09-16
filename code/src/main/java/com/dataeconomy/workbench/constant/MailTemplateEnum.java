package com.dataeconomy.workbench.constant;

import com.dataeconomy.framework.util.BasePropertyEnum;

public enum MailTemplateEnum implements BasePropertyEnum{
	FORGOT_PASSWORD("forgetPassword", "forgetPassword"),
	CREATE_USER("createUser", "createUser"),
	UPDATE_USER("updateUser", "updateUser"),
	RESET_PASSWORD("resetPassword","resetPassword"),
	CHECKLIST_TEMPLATE("checklistTemplate","checklistTemplate"),
	APPROVAL_TO_DGO("approvalToAllDGOs","approvalToAllDGOs",WBConstants.SESSION),
	CREATE_TASK("createTask","createTask",WBConstants.SESSION);
	
	public String subject;
	public String filename;
	public String type;
	public String bundleName = "com.dataeconomy.businessDWB.mails";

	private MailTemplateEnum(String subject, String filename,String type) {
		this.subject = subject;
		this.filename = filename;
		this.type=type;
	}
	private MailTemplateEnum(String subject, String filename) {
		this.subject = subject;
		this.filename = filename;
		
	}

	@Override
	public String getBundle() {
		return bundleName;
	}

	@Override
	public String getKey() {
		return subject;
	}

	@Override
	public Integer getStatusCode() {
		return 200;
	}

}


