package com.dataeconomy.workbench.constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import com.dataeconomy.framework.logging.AppLogger;
import com.dataeconomy.framework.logging.AppLoggerFactory;
import com.dataeconomy.framework.util.AppBundle;
import com.dataeconomy.framework.util.StringUtils;

public enum EnvProperties {

	FILE_LOCATION("filelocation"),
	FILE_NAME("fileName");

	public String value;

	private static final AppLogger LOG = AppLoggerFactory.getLogger(EnvProperties.class.getName());

	private static final Properties PROPERTIES = loadProperties();

	EnvProperties(String value) {
		this.value = value;
	}

	public static String findProperty(EnvProperties key) {
		return PROPERTIES.getProperty(key.value);
	}

	private static Properties loadProperties() {
		InputStream is = null;
		Properties property = new Properties();
		String envConfig = System.getProperty("configPath");
		LOG.info("Config path :" + envConfig);
		try {
			if (StringUtils.isEmpty(envConfig)) {
				ResourceBundle resource = AppBundle.getBundle("com.dataeconomy.businessDWB.envConfig");
				property = convertResourceBundleToProperties(resource);
			} else {
				StringBuilder filePath = new StringBuilder(envConfig);
				filePath.append("envConfig.properties");
				LOG.info("Full path :" + filePath);
				File configFile = new File(filePath.toString());
				is = new FileInputStream(configFile);
				property.load(is);
			}
		} catch (Exception th) {

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
