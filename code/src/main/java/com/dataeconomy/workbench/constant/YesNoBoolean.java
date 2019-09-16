package com.dataeconomy.workbench.constant;
import java.util.HashMap;
import java.util.Map;

public enum YesNoBoolean {

	TRUE('Y', "Yes", true), FALSE('N', "No", false);

	private final char charValue;
	private final String stringValue;
	private final boolean booleanValue;

	private static final Map<Boolean, YesNoBoolean> valueMap = new HashMap<Boolean, YesNoBoolean>();
	private static final Map<String, YesNoBoolean> stringCharMap = new HashMap<String, YesNoBoolean>();
	private static final Map<String, YesNoBoolean> stringMap = new HashMap<String, YesNoBoolean>();

	static {
		for (YesNoBoolean constant : YesNoBoolean.class.getEnumConstants()) {
			valueMap.put(Boolean.valueOf(constant.toBoolean()), constant);
			stringCharMap.put(constant.toStringChar(), constant);
			stringMap.put(constant.toString(), constant);
		}
	}

	YesNoBoolean(final char charValue, final String stringValue, final boolean booleanValue) {
		this.charValue = charValue;
		this.stringValue = stringValue;
		this.booleanValue = booleanValue;
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

	public boolean toBoolean() {
		return this.booleanValue;
	}

	public static YesNoBoolean fromBoolean(final boolean booleanValue) {
		return valueMap.get(booleanValue);
	}

	public static YesNoBoolean fromStringChar(final String stringChar) {
		return stringCharMap.get(stringChar);
	}

	public static YesNoBoolean fromString(final String stringValue) {
		return stringMap.get(stringValue);
	}
}
