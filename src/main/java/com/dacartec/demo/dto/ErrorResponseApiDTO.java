package com.dacartec.demo.dto;

public class ErrorResponseApiDTO {
	
	private Integer code;
	private String type;
	private String info;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "ErrorResponseApiDTO [code=" + code + ", type=" + type + ", info=" + info + "]";
	}
	
	
	
}
