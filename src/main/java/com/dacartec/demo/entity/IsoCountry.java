package com.dacartec.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Entity
@Table(name = "iso_country")
public class IsoCountry implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String nameCountry;
	 private String isoNumber;
	 private String codeAlpha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameCountry() {
		return nameCountry;
	}
	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	public String getIsoNumber() {
		return isoNumber;
	}
	public void setIsoNumber(String isoNumber) {
		this.isoNumber = isoNumber;
	}
	public String getCodeAlpha() {
		return codeAlpha;
	}
	public void setCodeAlpha(String codeAlpha) {
		this.codeAlpha = codeAlpha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	 

}
