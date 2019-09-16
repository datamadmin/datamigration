package com.dataeconomy.workbench.constant;

import java.util.HashMap;
import java.util.Map;

public enum EntityStatusEnum {

	ACTIVE('A', "Active"), INACTIVE('N', "In Active");

	private final char charValue;
	private final String stringValue;

	private static final Map<String, EntityStatusEnum> STRINGCHARMAP = new HashMap<>();
	private static final Map<String, EntityStatusEnum> STRINGMAP = new HashMap<>();

	static {
		for (EntityStatusEnum constant : EntityStatusEnum.class.getEnumConstants()) {
			STRINGCHARMAP.put(constant.toStringChar(), constant);
			STRINGMAP.put(constant.toString(), constant);
		}
	}

	EntityStatusEnum(final char charValue, final String stringValue) {
		this.charValue = charValue;
		this.stringValue = stringValue;
	}

	public char toChar() {
		return this.charValue;
	}

	@Override
	public String toString() {
		return this.stringValue;
	}

	public String toStringChar() {
		return String.valueOf(this.charValue);
	}

	public static Map<String, EntityStatusEnum> getStringcharmap() {
		return STRINGCHARMAP;
	}

	public static Map<String, EntityStatusEnum> getStringmap() {
		return STRINGMAP;
	}

}
