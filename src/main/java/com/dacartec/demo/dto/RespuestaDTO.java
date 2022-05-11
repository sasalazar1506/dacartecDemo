package  com.dacartec.demo.dto;

import java.util.List;
import java.util.Map;





import lombok.Data;

@Data
public class RespuestaDTO<T>{
	
	private String codeTrx;
	private String description;
	private Long regAffected;
	private T responseObject;;
	private List<T> listObject;
	public String getCodeTrx() {
		return codeTrx;
	}
	public void setCodeTrx(String codeTrx) {
		this.codeTrx = codeTrx;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getRegAffected() {
		return regAffected;
	}
	public void setRegAffected(Long regAffected) {
		this.regAffected = regAffected;
	}
	public T getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(T responseObject) {
		this.responseObject = responseObject;
	}
	public List<T> getListObject() {
		return listObject;
	}
	public void setListObject(List<T> listObject) {
		this.listObject = listObject;
	}
	
	
	

}
