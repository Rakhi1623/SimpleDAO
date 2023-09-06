package com.canddella.dbconnectionpool;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class DBConnectionPool {
	
	
	
	private static ComboPooledDataSource dataSource;
	static{
		try {
			dataSource = new ComboPooledDataSource();
			Properties properties = new Properties();
			InputStream inputStream = new FileInputStream("resource/db.properties");
			properties.load(inputStream);
			
			
			dataSource.setDriverClass(properties.getProperty("DRIVER_CLASS")); // loads the jdbc driver
			dataSource.setJdbcUrl(properties.getProperty("CONNECTION_STRING"));
			dataSource.setUser(properties.getProperty("USERNAME"));
			dataSource.setPassword(properties.getProperty("PASSWORD"));
			// the settings below are optional

			// c3p0 can work with defaults
			dataSource.setInitialPoolSize(5);
			dataSource.setMinPoolSize(5);

			dataSource.setAcquireIncrement(5);
			dataSource.setMaxPoolSize(20);

			} catch (IOException | PropertyVetoException e) {
				
			e.printStackTrace();
			}
			}

			public static javax.sql.DataSource getDataSource() {
			return dataSource;
			}

}
