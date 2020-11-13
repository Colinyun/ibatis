package com.isoftstone.colin.ibatis.xml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.isoftstone.colin.ibatis.bean.Mapper;
import com.isoftstone.colin.ibatis.bean.XMLMetaData;
import com.isoftstone.colin.ibatis.configuration.Configuration;
import com.isoftstone.colin.ibatis.enums.DDLLabel;
import com.isoftstone.colin.ibatis.xml.impl.SelectXMLResolver;

public class XMLParsing {

	private Map<String, Mapper> _dataMap = new HashMap<>();

	public Configuration parse(String resource) {
		try {
			Mapper mapper = new Mapper();
			InputStream inputStream = ClassLoader.getSystemResourceAsStream(resource);
			Element rootElement = new SAXReader().read(inputStream).getRootElement();
			String namespace = rootElement.attributeValue("namespace").trim();
			mapper.setInterfaceName(namespace);
			subElementParse(rootElement, mapper);
			_dataMap.put(namespace, mapper);
			return new Configuration(_dataMap);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void subElementParse(Element rootElement, Mapper mapper) {
		Iterator<?> iterator = rootElement.elementIterator();
		Map<String, XMLMetaData> metaDataMap = new HashMap<>();
		while (iterator != null && iterator.hasNext()) {
			Element element = (Element) iterator.next();
			metaDataMap.putAll(_getXMLResolver(element.getName().trim()).resolve(element));
		}
		mapper.setMetaDataMap(metaDataMap);
	}

	private XMLResolver _getXMLResolver(String labelName) {
		switch (DDLLabel.transitionDDLLabelByValue(labelName)) {
		case SELECT:
			return new SelectXMLResolver();
		case UPDATE:
			break;
		case DELETE:
			break;
		}
		return null;
	}

}
