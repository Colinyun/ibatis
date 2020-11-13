package com.isoftstone.colin.ibatis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import com.isoftstone.colin.ibatis.bean.Mapper;
import com.isoftstone.colin.ibatis.bean.User;
import com.isoftstone.colin.ibatis.bean.XMLMetaData;
import com.isoftstone.colin.ibatis.sqlsession.DefaultSqlSession;

public class BaseDefaultMapperProxy implements InvocationHandler {

	private DefaultSqlSession sqlSession;

	public BaseDefaultMapperProxy(DefaultSqlSession defaultSqlSession) {
		this.sqlSession = defaultSqlSession;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Map<String, Mapper> metaDataMap = sqlSession.getConfiguration().getXmlMetaDataMap();
		Mapper mapper = metaDataMap.get(method.getDeclaringClass().getName());
		XMLMetaData xmlMetaData = mapper.getMetaDataMap().get(method.getName());
		return sqlSession.query(xmlMetaData.getSql(), User.class);
	}

}
