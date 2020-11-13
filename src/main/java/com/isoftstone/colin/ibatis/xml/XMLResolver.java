package com.isoftstone.colin.ibatis.xml;

import java.util.Map;

import org.dom4j.Element;

import com.isoftstone.colin.ibatis.bean.XMLMetaData;

public interface XMLResolver {

	Map<String, XMLMetaData> resolve(Element element);
}
