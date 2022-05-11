package com.dacartec.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dacartec.demo.entity.IsoCountry;

public interface IsoCountryDAO extends CrudRepository <IsoCountry, Long>{

	@Query(value="select * from iso_country where code_alpha=?", nativeQuery=true)
	IsoCountry isoCountryFindCodeAlpa(String codeAlpha);
	
}
