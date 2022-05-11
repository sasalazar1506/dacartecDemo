package com.dacartec.demo.impl;



import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dacartec.demo.dao.CountryDao;
import com.dacartec.demo.dao.IsoCountryDAO;
import com.dacartec.demo.dto.ResponseApiDTO;
import com.dacartec.demo.dto.RespuestaDTO;
import com.dacartec.demo.entity.Country;
import com.dacartec.demo.entity.IsoCountry;
import com.dacartec.demo.services.CountryWS;
import com.dacartec.demo.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class CountryImpl extends Utils implements CountryWS  {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Value("${ipapi.key.asing}")
	private  String KEY_IPAPI;
	
	@Autowired
	CountryDao countryDao;
	
	@Autowired
	IsoCountryDAO isoCountryDAO;

	@Override
	public RespuestaDTO createCountry(String ipClient) {
		
		
		RespuestaDTO respData= new RespuestaDTO();
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String path="http://api.ipapi.com/"+ipClient+"?access_key="+KEY_IPAPI;
	
		try {
			
			HttpGet getRequest = new HttpGet(path);
		    getRequest.addHeader("accept", "application/xml");
		    HttpResponse response = httpClient.execute(getRequest);
		    
		    int statusCode = response.getStatusLine().getStatusCode();
		    if (statusCode == 200){
		    	HttpEntity httpEntity = response.getEntity();
		        String apiOutput = EntityUtils.toString(httpEntity);
		        Gson gson= new Gson();
		        ResponseApiDTO resp= gson.fromJson(apiOutput, ResponseApiDTO.class);

		        if(resp.getError()==null) {
		        	IsoCountry isoCountry= isoCountryDAO.isoCountryFindCodeAlpa(resp.getCountry_code());
		        	Country country= new Country();
		        	country.setId_isoCountry(isoCountry);
		        	country.setNameCountry(resp.getCountry_name());
		        	country.setIpClient(resp.getIp());
		        	country.setTimeDate(new Date());
		        
		        	country=countryDao.save(country);
		        	
		        	respData.setCodeTrx(CODE_OK);
		        	respData.setDescription(DES_OK); 
		        	respData.setResponseObject(country);
		        
		        	
		        }else {
		        	respData.setCodeTrx(CODE_FAIL);
		        	respData.setDescription(DES_FAIL);
		        	respData.setResponseObject(resp.getError());
		        }
		        
		    }else {	    
		    	respData.setCodeTrx(CODE_FAIL);
	        	respData.setDescription("Error Request Api Server IPAPI");	    	
		    }

		}catch (Exception e) {
			respData.setCodeTrx(CODE_FAIL);
        	respData.setDescription(e.getMessage());		
		}
		return respData;
	}

	@Override
	public RespuestaDTO listCountryFindNameCountry(String nameCountry) {
		
		RespuestaDTO<Country> respData = new RespuestaDTO();
		List<Country> listCountry= new ArrayList<Country>();
		
		listCountry=countryDao.listCountryFindNameCountry(nameCountry);
		
		log.info("data: {}", listCountry.toString());
		if(listCountry.size()!=0) {
			
			respData.setCodeTrx(CODE_OK);
        	respData.setDescription(DES_OK); 
        	respData.setListObject(listCountry);
        	respData.setRegAffected(Long.valueOf(listCountry.size()));
			
		}else {
			respData.setCodeTrx(CODE_FAIL);
        	respData.setDescription(DES_VACIO);
        	respData.setRegAffected(Long.valueOf(listCountry.size()));
		}
		
		
		
		return respData;
	}

}
