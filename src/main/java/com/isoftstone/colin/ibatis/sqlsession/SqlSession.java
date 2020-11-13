package com.isoftstone.colin.ibatis.sqlsession;

import java.util.List;

public interface SqlSession {

	public void builder(String resource);

	public <T> List<T> query(String sql, Class<?> clazz);

	public <T> T getMapper(Class<?> interfaces);
}
