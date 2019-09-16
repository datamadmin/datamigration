
package com.dataeconomy.framework.logging;

import java.net.InetAddress;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

/**
 * @author Guvala
 */
public class AppLogger {
	private Logger logger;

	public static String DELIMITER = ":";

	public void info(Object message) {
		logger.info(format(message));
	}

	public void warn(Object message) {
		logger.warn(format(message));
	}

	public void debug(Object message) {
		logger.debug(format(message));
	}

	public void error(Object message) {
		logger.error(format(message));
	}

	public void fatal(Object message) {
		logger.fatal(format(message));
	}

	public void trace(Object message) {
		logger.trace(format(message));
	}

	public void info(Object message, Throwable th) {
		logger.info(format(message), th);
	}

	public void warn(Object message, Throwable th) {
		logger.warn(format(message), th);
	}

	public void debug(Object message, Throwable th) {
		logger.debug(format(message), th);
	}

	public void error(Object message, Throwable th) {
		logger.error(format(message), th);
	}

	public void fatal(Object message, Throwable th) {
		logger.fatal(format(message), th);
	}

	public void trace(Object message, Throwable th) {
		logger.trace(format(message), th);
	}

	public void infoFormat(Object message, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.info(format(output));
	}

	public void warnFormat(Object message, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.warn(format(output));
	}

	public void debugFormat(Object message, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.debug(format(output));
	}

	public void errorFormat(Object message, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.error(format(output));
	}

	public void fatalFormat(Object message, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.fatal(format(output));
	}

	public void traceFormat(Object message, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.trace(format(output));
	}

	public void infoFormat(Object message, Throwable th, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.info(format(output), th);
	}

	public void warnFormat(Object message, Throwable th, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.info(format(output), th);
	}

	public void debugFormat(Object message, Throwable th, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.info(format(output), th);
	}

	public void errorFormat(Object message, Throwable th, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.info(format(output), th);
	}

	public void fatalFormat(Object message, Throwable th, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.info(format(output), th);
	}

	public void traceFormat(Object message, Throwable th, Object... parms) {
		String output = replaceParameters(message, parms);
		logger.info(format(output), th);
	}

	/**
	 * Get Local Host Name
	 *
	 * @return
	 */
	private String getHostName() {
		String hostName = new String();
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (Exception ex) {
		}

		return (hostName);
	}

	/**
	 * Get Log specific context
	 *
	 * @return
	 */
	// protected abstract String getContext();

	/**
	 * Prefix user specific context from the thread with the message.
	 *
	 * @param message
	 * @return
	 */
	private String format(Object message) {

		String contextPrefix = "";

		String hostName = getHostName();
		StringBuilder builder = new StringBuilder();
		builder.append(hostName).append(DELIMITER);
		builder.append(contextPrefix);

		builder.append("-");
		builder.append(message);
		return (builder.toString());
	}

	/**
	 * Replace parameters in the message
	 *
	 * @param message
	 * @param parms
	 * @return
	 */
	private String replaceParameters(Object message, Object... parms) {
		String output = new String();

		if ((parms != null) && (parms.length > 0)) {
			output = MessageFormat.format(message.toString(), parms);
		}

		return (output);
	}

	protected void setLogger(Logger logger) {
		this.logger = logger;
	}
}
