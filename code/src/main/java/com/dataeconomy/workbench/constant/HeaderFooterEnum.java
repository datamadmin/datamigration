package com.dataeconomy.workbench.constant;

import java.util.HashMap;
import java.util.Map;

public enum HeaderFooterEnum {

	HEADER('H', "Header", "'H'"), DATA('D', "Data", "'D'"), FOOTER('F', "Footer", "'F'");

	private final char charValue;
	private final String stringValue;
	private final String apostropheChar;

	private static final Map<String, HeaderFooterEnum> STRINGCHARMAP = new HashMap<>();
	private static final Map<String, HeaderFooterEnum> STRINGMAP = new HashMap<>();

	static {
		for (HeaderFooterEnum constant : HeaderFooterEnum.class.getEnumConstants()) {
			STRINGCHARMAP.put(constant.toStringChar(), constant);
			STRINGMAP.put(constant.toString(), constant);
		}
	}

	HeaderFooterEnum(final char charValue, final String stringValue, String apostropheChar) {
		this.charValue = charValue;
		this.stringValue = stringValue;
		this.apostropheChar = apostropheChar;
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

	public String toApostropheChar() {
		return apostropheChar;
	}

	public char getCharValue() {
		return charValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public String getApostropheChar() {
		return apostropheChar;
	}

	public static Map<String, HeaderFooterEnum> getStringcharmap() {
		return STRINGCHARMAP;
	}

	public static Map<String, HeaderFooterEnum> getStringmap() {
		return STRINGMAP;
	}

}
