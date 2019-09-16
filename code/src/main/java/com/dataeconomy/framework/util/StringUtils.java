package com.dataeconomy.framework.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author Guvala
 *
 */
public class StringUtils {

	/**
	 * Return true if the string is empty or null
	 * 
	 * @param aStr
	 * @return boolean
	 */
	public static boolean isEmpty(String aStr) {
		if ((aStr == null) || (aStr.trim().length() == 0))
			return (true);
		return (false);
	}

	/**
	 * Take a collection of string separated by spaces, carriage return or
	 * commas, and return a list of String. Only convert the parameter String to
	 * uppercase if specified.
	 * 
	 * @param aStr
	 * @param toUpperCase
	 * @return List<String>
	 */
	public static List<String> parseMultipleValueString(String aStr, boolean toUpperCase) {
		if (isEmpty(aStr)) {
			return new ArrayList<String>();
		}

		if (toUpperCase) {
			aStr = aStr.toUpperCase();
		}

		String[] stringArray = aStr.trim().replaceAll("\\s", ",").split(",+");
		return Arrays.asList(stringArray);
	}

	/**
	 * Take a collection of string separated by spaces, carriage return or
	 * commas, and return a list of String. Only convert the parameter String to
	 * uppercase if specified. This method will remove any duplicates from the
	 * list
	 * 
	 * @param aStr
	 * @param toUpperCase
	 * @return List<String>
	 */
	public static List<String> parseMultipleValueStringToUniqueList(String aStr, boolean toUpperCase) {
		if (isEmpty(aStr)) {
			return new ArrayList<String>();
		}

		if (toUpperCase) {
			aStr = aStr.toUpperCase();
		}

		String[] stringArray = aStr.trim().replaceAll("\\s", ",").split(",+");
		return new ArrayList<String>(new HashSet<String>(Arrays.asList(stringArray)));
	}

	/**
	 * Take a collection of string separated by carriage return or commas, and
	 * return a list of String. Spaces will be ignored, as the actual value may
	 * contain a space. Only convert the parameter String to uppercase if
	 * specified.
	 * 
	 * @param aStr
	 * @param toUpperCase
	 * @return List<String>
	 */
	public static List<String> parseMultipleValueStringIgnoreSpace(String aStr, boolean toUpperCase) {
		if (isEmpty(aStr)) {
			return new ArrayList<String>();
		}

		if (toUpperCase) {
			aStr = aStr.toUpperCase();
		}

		String[] stringArray = aStr.trim().replaceAll("\r\n", ",").split(",+");
		return Arrays.asList(stringArray);
	}

	/**
	 * Take a collection of string separated by carriage return or commas, and
	 * return a list of String. Spaces will be ignored, as the actual value may
	 * contain a space. Only convert the parameter String to uppercase if
	 * specified. This method will remove any duplicates from the list
	 * 
	 * @param aStr
	 * @param toUpperCase
	 * @return List<String>
	 */
	public static List<String> parseMultipleValueStringToUniqueListIgnoreSpace(String aStr, boolean toUpperCase) {
		if (isEmpty(aStr)) {
			return new ArrayList<String>();
		}

		if (toUpperCase) {
			aStr = aStr.toUpperCase();
		}

		String[] stringArray = aStr.trim().replaceAll("\r\n", ",").split(",+");
		return new ArrayList<String>(new HashSet<String>(Arrays.asList(stringArray)));
	}

	/**
	 * Take a collection of string separated by commas only, and return a list
	 * of Strings. Only convert the parameter String to uppercase if specified.
	 * 
	 * @param aStr
	 * @param toUpperCase
	 * @return List<String>
	 */
	public static List<String> parseCommaDelimitedString(String aStr, boolean toUpperCase) {
		if (isEmpty(aStr)) {
			return new ArrayList<String>();
		}

		if (toUpperCase) {
			aStr = aStr.toUpperCase();
		}

		String[] stringArray = aStr.trim().split(",");
		return new ArrayList<String>(Arrays.asList(stringArray));
	}

	/**
	 * Convert a list of Strings into a single string object with each value
	 * separated by a comma
	 * 
	 * @param stringArray
	 * @return String
	 */
	public static String toCommaDelimitedString(List<String> stringArray) {
		return stringArray.toString().trim().replace("[", "").replace("]", "");
	}

	/**
	 * Convert a list of Strings into a single string object with each value
	 * separated by a space
	 * 
	 * @param stringArray
	 * @return String
	 */
	public static String toSpaceDelimitedString(List<String> stringArray) {
		return org.apache.commons.lang3.StringUtils.join(stringArray, " ");
	}

	/**
	 * Convert a list of Strings into a single string object with each value
	 * separated by a specified delimiter passed as a parameter
	 * 
	 * @param stringArray
	 * @return String
	 */
	public static String toDelimitedString(List<String> stringArray, String delimiter) {
		return org.apache.commons.lang3.StringUtils.join(stringArray, delimiter);
	}

	public static String getCommaSeparatedString(List<String> values) {
		StringBuilder value = new StringBuilder();
		if (values == null || values.isEmpty()) {
			return value.toString();
		}
		for (String vin : values) {
			value.append(vin);
			value.append(",");
		}
		return value.substring(0, value.lastIndexOf(","));
	}

	/**
	 * Take a collection of string separated by carriage return or commas,
	 * parses the string and returns true if a value exceeds the max size.
	 * Spaces will be ignored in parsing, as the actual value may contain a
	 * space.
	 * 
	 * @param aString
	 * @param maxSize
	 * @return true if a value exceeds max size else returns false
	 */
	public static boolean exceedsSizeIgnoreSpace(String aString, int maxSize) {
		boolean exceedsSize = false;
		List<String> values = (ArrayList) parseMultipleValueStringIgnoreSpace(aString, true);
		for (String value : values) {
			if (value.length() > maxSize) {
				exceedsSize = true;
			}
		}

		return exceedsSize;

	}

	/**
	 * Take a collection of string separated by carriage return or commas,
	 * parses the string and returns true if a value exceeds the max size.
	 * 
	 * @param aString
	 * @param maxSize
	 * @return true if a value exceeds max size else returns false
	 */
	public static boolean exceedsSize(String aString, int maxSize) {
		boolean exceedsSize = false;
		List<String> values = parseMultipleValueString(aString, true);
		for (String value : values) {
			if (value.length() > maxSize) {
				exceedsSize = true;
			}
		}

		return exceedsSize;

	}

	public static String padRightWith(String aString, int size, String padValue) {
		return org.apache.commons.lang3.StringUtils.rightPad(aString, size, padValue);
	}

	public static String trim(String aString) {
		if (StringUtils.isEmpty(aString))
			return (new String());
		return (aString.trim());
	}
	
	public static int ordinalIndexOf(String str, String substr, int n) {
	    int pos = str.indexOf(substr);
	    while (--n > 0 && pos != -1)
	        pos = str.indexOf(substr, pos + 1);
	    return pos;
	}
}
