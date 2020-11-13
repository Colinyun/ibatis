package com.isoftstone.colin.ibatis;

import com.isoftstone.colin.ibatis.sqlsession.DefaultSqlSession;

public class SqlSessionBuilder {

	public static void builder(String resource) {
		new DefaultSqlSession().builder(resource);
	}
}
