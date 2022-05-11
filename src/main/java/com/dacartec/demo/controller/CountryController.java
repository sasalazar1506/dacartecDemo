package com.dacartec.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacartec.demo.dto.RequestIpDTO;
import com.dacartec.demo.dto.RespuestaDTO;
import com.dacartec.demo.impl.CountryImpl;
import com.dacartec.demo.services.CountryWS;

@Controller
@RequestMapping("dacartec")
public class CountryController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CountryWS countryWS;
	
	
	@PostMapping("/create")
	public  @ResponseBody RespuestaDTO crearReg(@RequestBody RequestIpDTO data)  {
		
		RespuestaDTO response= new RespuestaDTO();
		
		//log.info("data: {}", data.getIp());
		response=countryWS.createCountry(data.getIp());
		return response;
	}
	
	@GetMapping("/consulta/{nameCountry}")
	public  @ResponseBody RespuestaDTO consultarReg(@PathVariable String nameCountry)  {
		
		RespuestaDTO response= new RespuestaDTO();
		
		//log.info("data: {}", data.getIp());
		response=countryWS.listCountryFindNameCountry(nameCountry);
		
		log.info("data: {}", response);
		return response;
	}

}
