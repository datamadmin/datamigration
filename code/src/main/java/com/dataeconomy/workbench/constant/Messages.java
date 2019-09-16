package com.dataeconomy.workbench.constant;

import com.dataeconomy.framework.util.BasePropertyEnum;

/**
 * 
 * @author Guvala
 *
 */
public enum Messages implements BasePropertyEnum {
	 SYSTEMEXCEPTION("systemException"),
	 WARNING("warning"),
	 PLEASE_SELECT_SORT_ORDER("selectSortOrder"),
	 PLEASE_SELECT_COLUMN("selectColumn"),
	 INFORMATION("information"),
	 ERROR("error"),
	 SAVED_MSG("savedMsg"),
	 VALIDATION_MESSAGE("validationMessage")
	,DELETE_MSG("deleteSingleMsg")
	,DELETEALL_MSG("deleteAllMsg")
	,DELETELOCK_MSG("deleteLockMsg")
	,PENDING_MSG("pendingMsg")
	,RESOLVED_MSG("resolvedMsg")
	,STATUSCHANGE_MSG("statusChangeMsg")
	,USERCREATED_MSG("userCreatedMSg")
	,USERUPDATED_MSG("userUpdatedMSg")
	,LNAMEEXIST_MSG("lnameExistMsg")
	,EMAILEXIST_MSG("emailExistMsg")
	,INVALIDUSER_MSG("invalidUserMsg")
	,USER_LOCKED_MESSAGE("")
	,USERROLEPRIVELEGE_MSG("userRolePrivilegeMsg")
	,RESETPWD_MSG("resetPwdMsg")
	,DBEXIST_MSG("dbExistMsg")
	,CONNSUCCESS_MSG("connSuccessMsg")
	,CONNNOTSUCCESS_MSG("connNotSuccess")
	,CONNSAVEDUNSUCCESS_MSG("connSavedUnsuccessMsg")
	,NOMAIL_MSG("noMailMsg")
	,MAILPWDSENT_MSG("mailSentMsg"),
	GENERICMSG("genericMsg"),
	INVALIDMAIL("invalidMail"),
	DUPLICATEROLENAME("duplicateRoleName"),
	SAVE_BEFORE_PROCEEDING("saveBeforeProceeding"),
	TASK_LOCKED_OTHER_USER("taskLockedOtherUser"),
	ADV_SEARCH_EMPTY_MSG("advSearchEmptyMsg"),
	USER_WITHOUT_PARTNER("userWithoutPartner"),
	RESET_PWD_SUCCESS_MSG("resetPswConfirmMsg"),
	SAVE_AND_SUBMIT_MSG("saveAndSubmitMsg"), 
	USER_UNLOCKED_MESSAGE("userUnlockedSuccessfully"),
	USER_DELETE_SUCCESSFULL("userDeleteSuccessfull"),
	ROLE_NAME_REQUIRED("roleNameRequired"),
	PARTNER_REQUIRED_MSG("partnerRequiredMsg"),
	FILE_TYPE_REQUIRD("fileTypeRequired"),
	ATLEAST_ONE_COLUMN_REQUIRED("atleastOneColumnRequired"),
	PASSWORD_EXPIRED_MSG("passwordExpiredMsg"),
	USER_DISABLED_MSG("userDisabledMsg"),
	USER_LOCKED_MSG("userLockedMsg"),
	UNSENT_EMAIL("unsentEmail"),	
	PLEASE_ENTER_USERNAME("pleaseEnterUsername"),
	PLEASE_ENTER_PASSWORD("pleaseEnterPassword"),
	PLEASE_ENTER_EMAIL_TO_GET_PASSWORD("pleaseEnterEmailToGetPassword"),
	PLEASE_ENTER_VALID_EMAIL_ADDRESS("pleaseEnterValidEmailAddress"),
	GROUP_SUCCESSFULLY_CREATED("groupSuccessfullyCreated"),
	PLEASE_ENTER_GROUP_NAME("pleaseEnterGroupName"),
	DUPLICATE_GROUP_NAME("duplicateGroupName"),
	PLEASE_SELECT_A_GROUP("pleaseSelectAGroup"),
	PLEASE_SELECT_ATLEAST_ONE_ROLE("pleaseSelectAtleastOneRole"),
	GROUP_SUCCESSFULLY_DELETED("groupSuccessfullyDeleted"),
	PLEASE_SELECT_ATLEAST_ONE_RECORD("pleaseSelectAtleastOneRecord"),
	PLEASE_ENTER_NEW_PASSWORD("pleaseEnterNewPassword"),
	PLEASE_CONFIRM_NEW_PASSWORD("pleaseConfirmNewPassword"),
	NEW_AND_CONFIRM_PASSWORDS_SHOULD_BE_SAME("newAndConfirmPasswordsShouldBeSame"),
	OLD_AND_NEW_PASSWORDS_SHOULD_NOT_BE_SAME("oldAndNewPasswordShouldNotBeSame"),
	RESOLVED_OR_LOCKED_TASKS_CANT_BE_DELETED("resolvedOrLockedTasksCantBeDeleted"),
	RESOLVED_TASKS_STATUS_CANT_BE_CHANGED("resolvedTasksStatusCantBeChanged"),
	PLEASE_CONTACT_ADMINISTRATOR_UNLOCK_TASKS("pleaseContactAdministratorUnlockTasks"),
	NOT_OWNER_OF_TASK("notowneroftask"),
	NEW_TASKS_CANT_CHANGED_TO_NEW_STATUS("newTasksCantChangedToNewStatus"),
	PENDING_TASKS_CANT_CHANGED_TO_PENDING_STATUS("pendingTasksCantChangedToPendingStatus"),
	RESOLVED_TASKS_CANT_CHANGED_TO_RESOLVED_STATUS("resolvedTasksCantChangedToResolvedStatus"),
	LOCKED_TASKS_CANT_CHANGED_TO_LOCKED_STATUS("lockedTasksCantChangedToLockedStatus"),
	PLEASE_SELECT_A_FIELD("pleaseSelectAfield"),
	PLEASE_SELECT_AN_OPERATOR("pleaseSelectAnOperator"),
	PLEASE_ENTER_SEARCH_VALUE("pleaseEnterSearchValue"),
	SELECT_ATLEAST_ONE_RECORD_TO_EDIT("selectAtleastOneRecordToEdit"),
	LOGIN_NAME_ALREADY_EXISTS("loginNameAlreadyExists"),
	EMAIL_ALREADY_EXISTS("emailAlreadyExists"),
	EMAIL_AND_CONFIRM_EMAIL_SHOULD_BE_SAME("emailAndConfirmEmailShouldBeSame"),
	PLEASE_SELECT_ONE_USER("pleaseSelectOneUser"),
	PLEASE_SELECT_ATLEAST_ONE_USER("pleaseSelectAtleastOneUser"),
	SELECT_USERS_HAVING_ONLY_LOCKED_STATUS("selectUsreshavingOnlyLockedStatus"),
	YOU_MUST_SELECT_ATLEAST_ONE_USER_TO_DELETE("youMustSelectAtleastOneUserToDelete"),
	SELECT_USERS_OTHER_THAN_SUPER_ADMIN("selectUsersOtherThanSuperAdmin"),
	USER_NAME_IS_NOT_REGISTERED("userNameIsNotRegistered"),
	SUPER_ADMIN_CAN_NOT_BE_DELETED("superAdminUserCanNotBeDeleted"),
	QUERY_NAME_ALREADY_EXISTS("queryNameAlreadyExists"),
	QUERY_SUCCESSFULLY_SAVED("querySuccessfullySaved"),
	QUERY_SUCCESSFULLY_DELETED("querySuccessfullyDeleted"), 
	TASK_DIFFERENT_GROUP("taskIsOfDifferentGroup"),
	SUPERADMIN_CANNOT_BE_ASSIGNED_GROUP("superAdminCannotBeAssignedGroup"),
	RESET_SUCCESS("resetSuccess"),
	RECORD_LOCKED_SUCCESSFULLY("recordLockedSucesfully"),
	RESOLVED_TASKS_CANT_CHANGED_TO_NEW_STATUS("resolvedTasksCannotBeChangedtoNew"),
	RESOLVED_TASKS_CANT_CHANGED_TO_LOCKED_STATUS("resolvedTasksCannotBeChangedtoLocked"),
	TASK_LOCKED_CANNOT_NAVIGATE("taskLockedCannotNavigate"),
	TASK_RESOLVED_CANNOT_NAVIGATE("taskResolvedCannotNavigate"),
	DEFAULT_ERROR_MESSAGE(""),
	MAX_RECORDS_EXCEDED("maxRecordsExceded"),
	INVALID_DATE(""),
	INVALID_TASK_ID_PATTERN("invalidTaskIdPattern"),
	LOGIN_USER_CAN_NOT_DELETED("loginUserCan'tBeDeleted"),
	RESOLVED_TASK_STATUS_CHANGE_ONLY_ADMIN_OR_SUPERADMIN("resolvedStatusChangeOnlyAdminOrSuperAdmin"),
	SUPER_ADMIN_CAN_NOT_BE_UNLOCKED("superAdminCan'tUnlocked"),
	TASK_CREATED("taskIsCreated"),
	TASKS_NOT_SAVED("tasksNotSaved"),
	TASK_CANNOT_BE_PROCESSED("NoColumnsFound"),
	TASK_CANNOT_BE_CREATED("userHaveNoRightsToCreateTask"),
	PARTNER_FILETYPE_NOT_EMPTY("partnerFileTypenotempty"),
	USER_PREFERENCE_ALREADY_EXISTS("userPreferenceAlreadyExists"),
	FILETYPE_NOT_EMPTY("FileTypenotempty"),
	INVALID_OLD_PASSWORD("invalidOldPassword"),
	PLEASE_ENTER_OLD_PASSWORD("pleaseEnterOldPassword"),
	USER_PREFERENCE_SAVED("userPreferenceSaved"),
	TIMEOUT_MINUTES_GREATER_ZERO("timeOutShldBeGrtrZero"),
	POLL_INTERVAL_GREATER_THAN_TIMEOUT("pollIntervalGrtrTimeout"),
	POLL_INTERVAL_LESS_THAN_TEN("pollIntervalLessThanTen");
	
	
	public final String key;
	public final String bundle = "com.dataeconomy.businessDWB.messages";

	Messages(String key) {
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
