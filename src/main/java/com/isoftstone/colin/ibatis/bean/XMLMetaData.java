package com.isoftstone.colin.ibatis.bean;

public class XMLMetaData {

	private String ddlType;

	private String sql;

	private String resultType;

	private String paramType;

	private String functionName;

	public String getDdlType() {
		return ddlType;
	}

	public void setDdlType(String ddlType) {
		this.ddlType = ddlType;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

}
