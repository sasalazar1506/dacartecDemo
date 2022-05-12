package com.dacartec.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dacartec.demo.entity.Country;

public interface CountryDao extends CrudRepository<Country, Long> {
	
	
	
	@Query(value="select * from country where name_country=? ORDER BY time_date ASC", nativeQuery=true)
	List<Country>  listCountryFindNameCountry(String nameCountry);
	
	

}
