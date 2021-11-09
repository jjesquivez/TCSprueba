package com.example.H2db.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.stereotype.Component;

import com.example.H2db.model.CustInfo;

@Component
@Endpoint(id="custinfo")
public class CustInfoEndpoint {
	
	private Map<String, Object> details = new LinkedHashMap<>();
	
	
	
	@ReadOperation
    public CustInfo info() {
		
		addToDetails();
		
        
        CustInfo info = new CustInfo();
        info.setInformation(details);
        return info;
    }
	
	@WriteOperation
	public void addToDetails() {
		details.put("Custom Info", "Info from Actuator");
        details.put("Team Name", "THDOnboarding");
        details.put("Developer", "Jesus Esquivez");
        details.put("version", "1.0");
        details.put("owner", "TCS");
        details.put("Description", "Aplication that shows user's information");
	}
		
	@WriteOperation
	public void addName(@Selector String name) {
		details.put("Other", name);
	}
	
	@DeleteOperation
	public void deleteName(@Selector String name) {
		details.remove(name);
	}
	
	
	

    

}
