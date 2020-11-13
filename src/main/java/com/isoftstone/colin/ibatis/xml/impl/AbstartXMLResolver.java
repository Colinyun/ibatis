package com.isoftstone.colin.ibatis.xml.impl;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;

import com.isoftstone.colin.ibatis.bean.XMLMetaData;
import com.isoftstone.colin.ibatis.xml.XMLResolver;

public abstract class AbstartXMLResolver implements XMLResolver {

	@Override
	public Map<String, XMLMetaData> resolve(Element element) {
		Map<String, XMLMetaData> _dataMap = new HashMap<>();
		XMLMetaData xmlMetaData = new XMLMetaData();
		xmlMetaData.setDdlType(element.getName().trim());
		xmlMetaData.setFunctionName(_getAttributeValue("id", element));
		xmlMetaData.setSql(element.getTextTrim());
		xmlMetaData.setResultType(_getAttributeValue("resultType", element));
		xmlMetaData.setParamType(_getAttributeValue("paramType", element));
		resolve(xmlMetaData, element);
		_dataMap.put(xmlMetaData.getFunctionName(), xmlMetaData);
		return _dataMap;
	}

	protected void resolve(XMLMetaData xmlMetaData, Element element) {

	}

	private String _getAttributeValue(String key, Element element) {
		String attributeValue = element.attributeValue(key);
		return attributeValue != null && attributeValue.length() > 0 ? attributeValue.trim() : null;
	}
}
