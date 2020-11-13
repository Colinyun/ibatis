package com.isoftstone.colin.ibatis.bean;

import java.util.Map;

public class Mapper {

	private String interfaceName;

	private Map<String, XMLMetaData> metaDataMap;

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public Map<String, XMLMetaData> getMetaDataMap() {
		return metaDataMap;
	}

	public void setMetaDataMap(Map<String, XMLMetaData> metaDataMap) {
		this.metaDataMap = metaDataMap;
	}
}
