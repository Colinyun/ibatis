package com.isoftstone.colin.ibatis.sqlsession;

import java.lang.reflect.Proxy;
import java.util.List;

import com.isoftstone.colin.ibatis.configuration.Configuration;
import com.isoftstone.colin.ibatis.executor.BaseExcutor;
import com.isoftstone.colin.ibatis.proxy.BaseDefaultMapperProxy;
import com.isoftstone.colin.ibatis.xml.XMLConfiguration;

public class DefaultSqlSession implements SqlSession {

	private Configuration configuration;

	private BaseExcutor executor;

	@Override
	public void builder(String resource) {
		configuration = new XMLConfiguration().parse(resource);
		executor = new BaseExcutor(configuration);
		
	}

	@Override
	public <T> List<T> query(String sql, Class<?> clazz) {
		return executor.query(sql, clazz);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<?> interfaces) {
		return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[] { interfaces },
				new BaseDefaultMapperProxy(this));
	}

	public Configuration getConfiguration() {
		return configuration;
	}
}
