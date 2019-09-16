package com.dataeconomy.workbench.constant;

public enum FileFormatEnum {
	DELIMITED(1, "DELIMITED"), FIXEDWIDTH(2, "FIXEDWIDTH"), XML(3, "DELIMITED"), MSExcel(4, "FIXEDWIDTH"), DB(5, "DB");

	public Integer id;
	public String format;

	FileFormatEnum(Integer id, String format) {
		this.id = id;
		this.format = format;

	}

}
