package com.dacartec.demo.services;



import java.util.List;

import com.dacartec.demo.dto.RespuestaDTO;
import com.dacartec.demo.entity.Country;


public interface CountryWS {
	
	public RespuestaDTO createCountry(String ipClient);
	
	public RespuestaDTO  listCountryFindNameCountry(String nameCountry);

}
