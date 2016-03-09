package com.hdy.enums;

public enum EnumResultCode {
	SUCCESS("成功"),FAIL("失败");

	private String value;

	private EnumResultCode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static EnumResultCode setValue(String str) {
		return valueOf(str);

	}

}
