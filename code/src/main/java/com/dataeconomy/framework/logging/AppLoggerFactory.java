package com.dataeconomy.framework.logging;

import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

/**
 * 
 * @author Guvala
 *
 */
public class AppLoggerFactory {
	public static AppLogger getLogger(String name) {
		AppLogger logger = new AppLogger();

		logger.setLogger(Logger.getLogger(name));

		return logger;
	}

	@SuppressWarnings("rawtypes")
	public static void close() {
		Enumeration allAppenders = Logger.getRootLogger().getAllAppenders();
		while (allAppenders.hasMoreElements()) {
			Appender appender = (Appender) allAppenders.nextElement();
			appender.close();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		AppLoggerFactory.close();
	}
}
