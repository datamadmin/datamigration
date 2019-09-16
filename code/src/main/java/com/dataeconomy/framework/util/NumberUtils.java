package com.dataeconomy.framework.util;

/**
 * 
 * @author GASWANT
 *
 */
public class NumberUtils {

	public static Long longValue(String aString) {
		try {
			return Long.parseLong(aString);
		} catch (Exception ex) {

		}
		return null;
	}

	public static boolean longEquals(final Long l1, final Long l2)
	{
		 if (l1 == l2) {
	            return true;
	        }
	        if (l1 == null || l2 == null) {
	            return false;
	        }
	        if (l1 instanceof Long && l2 instanceof Long) {
	            return l1.equals(l2);
	        }
	      return false;
	}
	
	public static boolean integerEquals(final Integer l1, final Integer l2)
	{
		 if (l1 == l2) {
	            return true;
	        }
	        if (l1 == null || l2 == null) {
	            return false;
	        }
	        if (l1 instanceof Integer && l2 instanceof Integer) {
	            return l1.equals(l2);
	        }
	      return false;
	}
}
