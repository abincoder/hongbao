package com.yubin.hongbao.common.constant;


public enum RPDict implements IDict {
	RP_NAME("00000", "操作成功", FieldType.STR) ;

	private final String code;
	private final String description;
	private final FieldType type;

	private RPDict(String code, String description, FieldType type) {
		this.code = code;
		this.description = description;
		this.type = type;
	}

	public String getCode() {
		return this.code;
	}

	/**
	 * 获取字段数据类型
	 */
	public FieldType getType() {
		return this.type;
	}

	public String getDescription() {
		return this.description;
	}

}
