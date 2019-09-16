package com.dataeconomy.framework.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;

import org.springframework.web.cors.CorsConfiguration;

import com.dataeconomy.workbench.constant.EnvProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author GUVALA
 * 
 *         This class contains all utility methods used in KAPA
 *
 */
public class AppWebUtils {

	public static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final String UTC = "UTC";

	/**
	 * Converts the double value to string
	 * 
	 */
	public static String doubleToString(Object value, String pattern) {
		if (value == null) {
			return null;
		}
		DecimalFormat priceFormat = new DecimalFormat(pattern, new DecimalFormatSymbols(Locale.ENGLISH));
		return priceFormat.format(value);
	}

	public static String convertObjectToJson(Object o) throws JsonProcessingException {
		return MAPPER.writeValueAsString(o);
	}

	public static <T> T convertJsonToObject(Class<T> clazz, String json) throws IOException {
		return MAPPER.readValue(json, clazz);
	}

	public static void loadThreadLocalUtils(AppUser user) {
		ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.LOCALE, Locale.ENGLISH.getLanguage());
		ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.LOCALE_OBJ, Locale.ENGLISH);
		ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.CURRENT_USER, user);
		ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.USER_ID, user.getUserId());
		ThreadLocalUtil.setThreadVariable(ThreadLocalUtil.USER_NAME, user.getUserName());
	}

	/**
	 * Set the value
	 * 
	 */
	public static String getCurrentTimeZone() {
		String timezone = ThreadLocalUtil.getThreadVariable(ThreadLocalUtil.X_TIMEZONE);
		if (StringUtils.isEmpty(timezone)) {
			timezone = AppWebUtils.UTC;
		}
		return timezone;
	}

	public static void saveToLocation(String fileName, String text) throws FileNotFoundException {
		String path = EnvProperties.findProperty(EnvProperties.FILE_LOCATION);
		File fDir = new File(path);
		if (!fDir.exists()) {
			fDir.mkdirs();
		}
		boolean fileExists = new File(path, fileName).exists();
		PrintWriter out = null;
		File file = new File(path, fileName);

		if (fileExists) {
			out = new PrintWriter(new FileOutputStream(file, true));
		} else {
			out = new PrintWriter(new FileOutputStream(file));
		}
		file.setReadable(true, false);
		file.setWritable(true, false);
		file.setExecutable(true, false);
		out.print(text);
		out.flush();
		out.close();
	}

	public static CorsConfiguration corsConfiguration() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "x-auth-token", "Current_release,X-TimeZone,X-Locale"));
		configuration.setExposedHeaders(Arrays.asList("x-auth-token", "Content-Type", "Content-Disposition", "Current_release"));
		return configuration;
	}

	public static String generateParamHash(int columnsId) {
		return columnsId < 10 ? "col00" + columnsId : columnsId >= 10 && columnsId < 100 ? "col0" + columnsId : "col" + columnsId;
	}

	public static String formatDouble(Double value) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(value);
	}
	
	public static String encodePassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(password.getBytes());
	}

	public static String decodePassword(String password) {
		Base64.Decoder decoder = Base64.getDecoder();
		return new String(decoder.decode(password));
	}

}
