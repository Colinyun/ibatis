package com.isoftstone.colin.ibatis.enums;

public enum DDLLabel {
	SELECT("select"), UPDATE("update"), DELETE("delete");

	private String label;

	DDLLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public static DDLLabel transitionDDLLabelByValue(String value) {
		for (DDLLabel label : values()) {
			if (label.getLabel().equals(value.toLowerCase())) {
				return label;
			}
		}
		return null;
	}

}
