package com.dataeconomy.workbench.constant;


import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import com.dataeconomy.framework.logging.AppLogger;
import com.dataeconomy.framework.logging.AppLoggerFactory;
import com.dataeconomy.framework.util.AppBundle;

public enum DBProperties {
	
	DBO("DBO"),
	DATAHUB("DATAHUB"),
	SP_TGT_UPDATE("SP_TGT_UPDATE"),
	DS_UPDATE_STATUS_HISTORY("DS_UPDATE_STATUS_HISTORY"),
	FETCHHIERARCHY("FETCHHIERARCHY");

	public String value;

	private static final AppLogger log = AppLoggerFactory.getLogger(DBProperties.class.getName());

	private static final Properties properties = loadProperties();

	DBProperties(String value) {
		this.value = value;
	}

	public static String findProperty(DBProperties key) {
		return properties.getProperty(key.value);
	}

	private static Properties loadProperties() {
		InputStream is = null;
		Properties property = new Properties();
		String envVal = System.getenv().get("dbName");
		envVal =  envVal==null?"":envVal;
		try {
			String filePath = "com.dataeconomy.businessDWB.".concat(envVal).concat("DBEnvConfig");
			ResourceBundle resource = AppBundle.getBundle(filePath);
			property = convertResourceBundleToProperties(resource);
		} catch (Exception th) {
			log.error(th);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {

				}
			}
		}
		return property;
	}
	
	
	private static Properties convertResourceBundleToProperties(ResourceBundle resource) {
		Properties properties = new Properties();
		Enumeration<String> keys = resource.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			properties.put(key, resource.getString(key));
		}
		return properties;
	}
}
