package com.dataeconomy.framework.util;

/**
 * 
 * @author Guvala
 * 
 *         All properties Enums should extend this interface which help for
 *         processing the messages
 *
 */
public interface BasePropertyEnum {

	String getBundle();

	String getKey();

	Integer getStatusCode();

}
