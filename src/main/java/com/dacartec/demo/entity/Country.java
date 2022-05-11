package com.dacartec.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "country")
public class Country implements Serializable {

	
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 private String nameCountry;
	 private IsoCountry id_isoCountry;
	 private String ipClient;
	 
	
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date timeDate;


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


	public IsoCountry getId_isoCountry() {
		return id_isoCountry;
	}


	public void setId_isoCountry(IsoCountry id_isoCountry) {
		this.id_isoCountry = id_isoCountry;
	}


	public String getIpClient() {
		return ipClient;
	}


	public void setIpClient(String ipClient) {
		this.ipClient = ipClient;
	}


	public Date getTimeDate() {
		return timeDate;
	}


	public void setTimeDate(Date timeDate) {
		this.timeDate = timeDate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	@Override
	public String toString() {
		return "Country [id=" + id + ", nameCountry=" + nameCountry + ", id_isoCountry=" + id_isoCountry + ", ipClient="
				+ ipClient + ", timeDate=" + timeDate + "]";
	}


	 
}
