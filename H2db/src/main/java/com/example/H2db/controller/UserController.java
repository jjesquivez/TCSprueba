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
	public ResponseEntity<?> addUser (@RequestBody User user) {
		return new ResponseEntity<>("User Added! "+services.saveUser(user), HttpStatus.OK);
    }
	
	@PostMapping("/edituser/{id}")
	public ResponseEntity<?> editUser (@PathVariable(value = "id") Integer  id, @RequestBody User user) {
		return new ResponseEntity<>(services.editUser(id, user), HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer  id) {
		return new ResponseEntity<>(services.deleteUser(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/duplicated/{id}")
	public ResponseEntity<?> duplicated(@PathVariable(value = "id") Integer  id) {
		return new ResponseEntity<>(services.duplicated(id), HttpStatus.OK);
	}
	
	@GetMapping("/max/{id}")
	public ResponseEntity<?> max(@PathVariable(value = "id") Integer  id) {
		return new ResponseEntity<>(services.maxValue(id), HttpStatus.OK);
	}	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?> nullPointerHandler(NullPointerException e){
		return new ResponseEntity<>("Invalid input, Path variable must be a number!", HttpStatus.BAD_REQUEST);
	}
	
	
	

}
