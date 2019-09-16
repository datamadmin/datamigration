package com.dataeconomy.workbench.constant;

import java.util.HashMap;
import java.util.Map;

public enum StatusHistoryEnum {
	NEW("DataStewardDIP"), APPROVED("DataStewardApproved"), INPROGRESS("DataStewardInProgress"), LOCKED(
			"DataStewardLocked"), DELETE("DataStewardDiscard"), REJECTED("DataStewardRejected"), PENDING_APPROVAL(
					"DataStewardPendingApproval");

	public final String value;

	private static Map<String, String> statusHistoryEnumMap = new HashMap<>();

	StatusHistoryEnum(String value) {
		this.value = value;
	}

	static {
		statusHistoryEnumMap.put(TaskStatus.NEW.value, StatusHistoryEnum.NEW.value);
		statusHistoryEnumMap.put(TaskStatus.APPROVED.value, StatusHistoryEnum.APPROVED.value);
		statusHistoryEnumMap.put(TaskStatus.INPROGRESS.value, StatusHistoryEnum.INPROGRESS.value);
		statusHistoryEnumMap.put(TaskStatus.LOCKED.value, StatusHistoryEnum.LOCKED.value);
		statusHistoryEnumMap.put(TaskStatus.DELETE.value, StatusHistoryEnum.DELETE.value);
		statusHistoryEnumMap.put(TaskStatus.REJECTED.value, StatusHistoryEnum.REJECTED.value);
		statusHistoryEnumMap.put(TaskStatus.PENDING_APPROVAL.value, StatusHistoryEnum.PENDING_APPROVAL.value);
	}

	public static Map<String, String> getStatusHistoryEnumMap() {
		return statusHistoryEnumMap;
	}

	public static void setStatusHistoryEnumMap(Map<String, String> statusHistoryEnumMap) {
		StatusHistoryEnum.statusHistoryEnumMap = statusHistoryEnumMap;
	}

	public String getValue() {
		return value;
	}

}
