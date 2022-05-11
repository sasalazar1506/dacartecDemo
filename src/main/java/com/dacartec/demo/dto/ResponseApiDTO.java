package com.dacartec.demo.dto;

import lombok.Data;


public class ResponseApiDTO {
	

	private String ip;
	private boolean success;
	private ErrorResponseApiDTO error;
	private String country_name;
    private String region_name;
    private String country_code;
    
    public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ErrorResponseApiDTO getError() {
		return error;
	}
	public void setError(ErrorResponseApiDTO error) {
		this.error = error;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	@Override
	public String toString() {
		return "ResponseApiDTO [ip=" + ip + ", success=" + success + ", error=" + error + ", country_name="
				+ country_name + ", region_name=" + region_name + ", country_code=" + country_code + "]";
	}
	
	

}
