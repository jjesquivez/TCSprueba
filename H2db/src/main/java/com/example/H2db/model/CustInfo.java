package com.example.H2db.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustInfo {
	private Map<String, Object> information;

	@JsonAnyGetter
	public Map<String, Object> getInformation() {
		return information;
	}

	@JsonAnySetter
	public void setInformation(Map<String, Object> information) {
		this.information = information;
	}
	
	
	
	

}
