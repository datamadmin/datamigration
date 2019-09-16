package com.dataeconomy.workbench.constant;

import java.util.HashMap;
import java.util.Map;

public enum ListOfTablesEnum {
	ENTITY_TYPE("Entity Type","entityType",1),
	FILE_FORMAT("File Format","fileFormat",2),
	HS_FILE_TYPE("File Type","hsFileType",3),
	ENTITY_MASTER("Entity Master","entityMaster",4),
	ENTITY_FILE_TYPE_XREF("Entity FileType Xref","entityFileTypeXref",5),
	ENTITY_FILE_REC_COLUMN("Entity FileRecColumn","entityFileRecColumn",6),
	SOURCE_TO_TARGET_MAPPING("Source To Target Mapping","sourceToTargetMapping",7),
	ENTITY_FILE_TYPE_SCHEDULE_XREF("Entity FileType Schedule Xref","entityFileTypeScheduleXref",8),
	HEADER_FOOTER("Header Footer","headerFooter",9),
	HEADER_FOOTER_COLS("Header Footer Cols","headerFooterCols",10),
	RULE_TYPE("Rule Type","ruleType",11),
	VALIDATION_STEP("Validation Step","validationStep",12),
	ENTITY_FILE_VALIDATION_RULE("Validation Rule","entityFileValidationRule",13),
	FILE_VAL_STEP_XREF("File ValStep Xref","fileValStepXref",14),
	ENTITY_FILE_TYPE_WEB_SERVICE("Entity File Type Web Service","entityFileTypeWebService",15),
	WEB_SERVICE_REC_COLUMN("Web Service Rec Column","webServiceRecColumn",16),
	SOURCE_TO_WEB_SERVICE_MAPPING("Source To Web Service Mapping","sourceToWebServiceMapping",17),
	SOURCE_TO_TARGET_SPLIT("Source To Target Split","sourceToTargetSplit",18),
	SOURCE_TO_SERVICE_CRITERIA("Source To Service Criteria","sourceToServiceCriteria",19),
	ENTITY_FILE_TYPE_QUERIES("Entity File Type Queries","entityFileTypeQueries",20),
	DATA_STEWARD_GROUPS("Data Steward Groups","dataStewardGroups",21),
	THREAD_POOL_TYPE("Thread Pool Type","threadPoolType",22),
	ENTITY_FILE_TYPE_STEP_CHUNK("Entity File Type Step Chunk","entityFileTypeStepChunk",23),
	THREAD_THREAD_POOL_XREF("Thread Thread Pool Xref","threadThreadPoolXref",24),
	EMPTY_FILE_CONFIG("Empty File Config","emptyFileConfig",25);
	
	public final String name;
	public final String value;
	public final int id;
	public static final Map<String,String> listOfTablesMap = new HashMap<>();
	public static final Map<Integer,String> listOfTablesIdsMap = new HashMap<>();
	public static final Map<String,Integer> tablesIdsMap = new HashMap<>();
	 ListOfTablesEnum(final String name,final String value,int id) {
		this.name = name;
		this.value = value;
		this.id = id;
	}
	
	static {
		for (ListOfTablesEnum constant : ListOfTablesEnum.class.getEnumConstants()) {
			listOfTablesMap.put(constant.name, constant.value);
			tablesIdsMap.put(constant.value, constant.id);
			listOfTablesIdsMap.put(constant.id,constant.value);
		}
	}

	public static Map<String, String> getListoftablesmap() {
		return listOfTablesMap;
	}

	public static Map<Integer, String> getListoftablesidsmap() {
		return listOfTablesIdsMap;
	}

	public static Map<String, Integer> getTablesidsmap() {
		return tablesIdsMap;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public int getId() {
		return id;
	}
	
	
	

}
