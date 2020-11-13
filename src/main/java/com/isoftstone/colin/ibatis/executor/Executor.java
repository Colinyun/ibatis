package com.isoftstone.colin.ibatis.executor;

import java.util.List;

public interface Executor {

	<T> List<T> query(String sql, Class<?> clazz);
}
