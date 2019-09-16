package com.dataeconomy.framework.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author GASWANT This class helps to initialize the resourceBundle with
 *         bundleName and caches all the resource with the RebatesResourceBundle.
 * 
 */

public class AppBundle {

	/**
	 * 
	 * @param bundleName
	 * @param locale
	 * @return
	 */
	public static ResourceBundle getBundle(String bundleName, Locale locale) {
		Locale sLocale = Locale.ENGLISH;
		ResourceBundle resourcebundle = ResourceBundle.getBundle(bundleName, sLocale,
				AppBundle.class.getClassLoader());
		return resourcebundle;
	}

	/**
	 * 
	 * @param bundleName
	 * @return
	 */
	public static ResourceBundle getBundle(String bundleName) {
		return getBundle(bundleName, Locale.ENGLISH);

	}

	/**
	 * 
	 * @param bundleName
	 * @param key
	 * @param locale
	 * @param params
	 * @return
	 */
	public static String getString(String bundleName, String key, Locale locale, Object... params) {
		ResourceBundle bundle = getBundle(bundleName, locale);
		try {
			String value = bundle.getString(key);
			if (params != null) {
				value = MessageFormat.format(value, params);
			}
			return value;
		} catch (Exception e) {
			return key;
		}

	}

	/**
	 * 
	 * @param bundleName
	 * @param key
	 * @param params
	 * @return
	 */
	public static String getString(String bundleName, String key, Object... params) {
		return getString(bundleName, key, Locale.ENGLISH, params);

	}

	/**
	 * 
	 * @param bundleName
	 * @param key
	 * @param params
	 * @return
	 */
	public static String getString(BasePropertyEnum property, Object... params) {
		return getString(property.getBundle(), property.getKey(), Locale.ENGLISH, params);

	}

}