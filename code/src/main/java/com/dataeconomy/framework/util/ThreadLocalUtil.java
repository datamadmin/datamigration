package com.dataeconomy.framework.util;

import java.util.HashMap;
import java.util.Locale;

/**
 * @author GASWANT
 * 
 *         This class is used setting and getting values during the thread
 *         context
 *
 */
public class ThreadLocalUtil {
	public static final String LOCALE = "LOCALE";
	public static final String LOCALE_OBJ = "LOCALE_OBJ";
	public static final String CURRENT_USER = "CURRENT_USER";
	public static final String USER_NAME = "USER_NAME";
	public static final String USER_ID = "USER_ID";
	public static final String X_TIMEZONE = "X-TimeZone";
	public static final String CURRENT_DB = "CURRENT_DB";
	public static final String CURRENT_RELEASE = "CURRENT_RELEASE";

	private final static ThreadLocal<HashMap<String, Object>> THREAD_VARIABLES = new ThreadLocal<HashMap<String, Object>>() {

		/**
		 * @see java.lang.ThreadLocal#initialValue()
		 */
		@Override
		protected HashMap<String, Object> initialValue() {
			return new HashMap<String, Object>();
		}
	};

	/**
	 * Set the value
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getThreadVariable(String name) {
		return (T) THREAD_VARIABLES.get().get(name);
	}

	/**
	 * get the value
	 * 
	 */
	public static void setThreadVariable(String name, Object value) {
		THREAD_VARIABLES.get().put(name, value);
	}

	/**
	 * remove the value
	 * 
	 */
	public static void destroy() {
		THREAD_VARIABLES.remove();
	}

	public static String getUserName() {
		return getThreadVariable(USER_NAME);
	}

	public static Long getUserId() {
		return getThreadVariable(USER_ID);
	}
	
	public static AppUser getUser() {
		return getThreadVariable(CURRENT_USER);
	}

	public static String getLocale() {
		return getThreadVariable(LOCALE);
	}

	public static Locale getLocaleObj() {
		return getThreadVariable(LOCALE_OBJ);
	}
	
	public static Integer getSelectedRelease() {
		return getThreadVariable(CURRENT_RELEASE);
	}
	
	public static Long getdbName() {
		return getThreadVariable(CURRENT_DB);
	}
}
