package com.isoftstone.colin.ibatis.configuration;

import java.sql.Connection;
import java.util.Map;

import com.isoftstone.colin.ibatis.bean.Mapper;
import com.isoftstone.colin.ibatis.datasource.DataSourceMananger;

public class Configuration {

	private Connection connection;

	private Map<String, Mapper> xmlMetaDataMap;

	public Configuration(Map<String, Mapper> xmlMetaDataMap) {
		this.xmlMetaDataMap = xmlMetaDataMap;
		this.connection = new DataSourceMananger().getConnection();
	}

	public Connection getConnection() {
		return connection;
	}

	public Map<String, Mapper> getXmlMetaDataMap() {
		return xmlMetaDataMap;
	}
}
