package com.isoftstone.colin.ibatis.datasource;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DataSourceMananger {

	public Connection getConnection() {
		Properties properties = new Properties();
		try {
			properties.load(ClassLoader.getSystemResourceAsStream("mysql.peroperties"));
			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
