package com.dataeconomy.framework.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.Assert;

import com.dataeconomy.framework.errorHandler.AppException;
import com.dataeconomy.workbench.constant.MessagesEnum;



public class DataSourceRouting extends AbstractDataSource implements InitializingBean {

	private boolean lenientFallback = true;

	private ConcurrentHashMap<Object, DataSource> resolvedDataSources = new ConcurrentHashMap<>();

	private DataSource resolvedDefaultDataSource;

	private Long resolvedDSName;
	
	private boolean defaultSchema;
	

	public void setLenientFallback(boolean lenientFallback) {
		this.lenientFallback = lenientFallback;
	}

	@Override
	public void afterPropertiesSet() {
		int defaultdb = 0;
		Properties connectionProperties = new Properties();
		connectionProperties.getProperty("maxIdle", "4");
		connectionProperties.getProperty("maxActive", "8");
		
	}

	protected Object resolveSpecifiedLookupKey(Object lookupKey) {
		return lookupKey;
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection connection=null;
		defaultSchema = false;
		try
		{
		   connection = determineTargetDataSource().getConnection();
		  
		}
		catch(Exception e)
		{
			//TODO need to uncomment code and verify code.
		/*	AppWebUtils.setSattribute("BRW_CUSTOM_EXCEPTION_MESSAGE",
					BusinessRWBBundle.getString(Messages.SELECTED_SCHEMA_NOT_AVAILABLE));*/
			connection =  this.resolvedDefaultDataSource.getConnection();
			defaultSchema = true;
			return connection;			
		}
		return connection;
		
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return determineTargetDataSource().getConnection(username, password);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T unwrap(Class<T> iface) throws SQLException {
		if (iface.isInstance(this)) {
			return (T) this;
		}
		return determineTargetDataSource().unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return (iface.isInstance(this) || determineTargetDataSource().isWrapperFor(iface));
	}

	protected DataSource determineTargetDataSource() {
		Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
		Long lookupKey = determineCurrentLookupKey();
		if (lookupKey == null) {
			return this.resolvedDefaultDataSource;
		}
		DataSource dataSource = this.resolvedDataSources.get(lookupKey);
		if (dataSource == null && (this.lenientFallback || lookupKey == null)) {
			dataSource = this.resolvedDefaultDataSource;
		}
		if (dataSource == null) {
			throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
		}
		return dataSource;
	}

	protected Long determineCurrentLookupKey() {
		//TODO need to uncomment code and verify code.
		//return ThreadLocalUtil.getdbName();
		return null;
	}

	

	public Long getResolvedDSName() {
		return resolvedDSName;
	}

	public boolean isDefaultSchema() {
		return defaultSchema;
	}

	
	
	
	
}
