package com.dataeconomy.workbench.constant;

/**
 * 
 * @author GuvalaL1
 *
 */
public enum TaskStatus {
	NEW("New"), INPROGRESS("InProgress"), LOCKED("Locked"), TEMPLOCK("TempLock"), DELETE("Delete"), PENDING_APPROVAL(
			"PendingApproval"), REJECTED("Rejected"), APPROVED("Approved");

	public final String value;

	TaskStatus(String value) {
		this.value = value;
	}

}
