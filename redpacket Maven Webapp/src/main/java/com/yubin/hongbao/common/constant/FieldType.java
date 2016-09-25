package com.yubin.hongbao.common.constant;

/**
 * 内部字段数据类型字典
 * 
 */
public enum FieldType {
	
	STR("String"),
	INT("Integer"),
	DOUBLE("double");

	private final String fldType;
	 

	private FieldType(String fldType) {
		this.fldType = fldType;
	}

	public String getType() {
		return this.fldType;
	}
}
