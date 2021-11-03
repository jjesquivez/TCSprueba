package com.example.H2db.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.H2db.model.User;
import com.example.H2db.service.Services;

@RestController
@RequestMapping("/API")
public class UserController {
	
	private Services services;
	
	public UserController(Services services) {
		super();
		this.services = services;
	}

	@GetMapping("/firstelement/{id}")
	public ResponseEntity<?> firstElement(@PathVariable(value = "id") Integer  id) {
		return new ResponseEntity<>("The first element is: "+services.firstElement(id), HttpStatus.OK);
	}
	
	//User p1 = new User(3,"Lorena", Arrays.asList(234,35387,67,2,3,4,4,43,34,43));
		
	@PostMapping("/adduser")
	public String addUser (@RequestBody User user) {
        try {
        	services.saveUser(user);
    		return "User Saved!\n";
			
		}catch(Exception e){
			return "Invalid input, variable must be a number!";
		}
		
	}
	
	@PostMapping("/edituser/{id}")
	public String editUser (@PathVariable(value = "id") Integer  id, @RequestBody User user) {
        try {
        	if(services.existId(id)==true) {
    			return services.editUser(id, user);
    		}else {
    			return "User not found!";
    		}
		}catch(Exception e){
			return "Invalid input, variable must be a number!";
		}
		
		
	}

	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable(value = "id") Integer  id) {
		try {
			if(services.existId(id)==true) {
				return services.deleteUser(id);
			}else {
				return "User not found";			
			}
		}catch(Exception e){
			return "Invalid input, Path variable must be a number!";
		}
		
	}
	
	@GetMapping("/duplicated/{id}")
	public String duplicated(@PathVariable(value = "id") Integer  id) {
		try {
			if(services.existId(id)==true) {
				return services.duplicated(id);
			}else {
				return "User not found!";
			}
		}catch(Exception e){
			return "Invalid input, Path variable must be a number!";
		}
		
	}
	
	@GetMapping("/max/{id}")
	public String max(@PathVariable(value = "id") Integer  id) {
		try {
			if(services.existId(id)==true) {
				return services.maxValue(id);
			}else {
				return "User not found!";
			}
		}catch(Exception e){
			return "Invalid input, Path variable must be a number!";
		}
	}	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> nullPointerHandler(NullPointerException e){
		return new ResponseEntity<>("Invalid input, Path variable must be a number!", HttpStatus.BAD_REQUEST);
	}
	
	
	

}
