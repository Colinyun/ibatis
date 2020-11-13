package com.isoftstone.colin.ibatis.executor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.isoftstone.colin.ibatis.configuration.Configuration;

public class BaseExcutor implements Executor {

	private Configuration configuration;

	public BaseExcutor(Configuration configuration) {
		super();
		this.configuration = configuration;
	}

	@Override
	public <T> List<T> query(String sql, Class<?> clazz) {
		try {
			PreparedStatement preparedStatement = configuration.getConnection().prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			return transitionForObject(resultSet, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private <T> List<T> transitionForObject(ResultSet resultSet, Class<?> classzz) throws Exception {
		List<T> resultList = new ArrayList<>();
		Object object = null;
		Method method = null;
		Field[] fields = null;
		Object value = null;
		while (resultSet.next()) {
			object = classzz.getConstructor().newInstance();
			fields = classzz.getDeclaredFields();
			for (Field field : fields) {
				method = classzz.getMethod(_getMethodName(field.getName()), field.getType());
				value = field.getType().getName().equals("java.util.Date") ? resultSet.getDate(field.getName())
						: resultSet.getObject(field.getName(), field.getType());
				method.invoke(object, value);
			}
			resultList.add((T) object);
		}
		return resultList;
	}

	private String _getMethodName(String name) {
		return "set" + (name.charAt(0) + "").toUpperCase() + name.substring(1);
	}
}
