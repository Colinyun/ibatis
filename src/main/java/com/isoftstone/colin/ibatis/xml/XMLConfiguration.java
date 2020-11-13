package com.isoftstone.colin.ibatis.xml;

import com.isoftstone.colin.ibatis.configuration.Configuration;

public class XMLConfiguration {

	public Configuration parse(String resource) {
		return new XMLParsing().parse(resource);
	}
}
