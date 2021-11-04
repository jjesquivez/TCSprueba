package com.example.H2db.controller;


import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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
		return new ResponseEntity<>("User Added! \n"+services.saveUser(user), HttpStatus.OK);
    }
	
	@PostMapping("/edituser/{id}")
	public ResponseEntity<?> editUser (@PathVariable(value = "id") Integer  id, @RequestBody User user) {
		if(services.existId(id)){
			return new ResponseEntity<>(services.editUser(id, user), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User not found! ", HttpStatus.BAD_REQUEST);
		}
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
	
	
	
		
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> noSuchElementHandler(NoSuchElementException e){
		return new ResponseEntity<>("User not found !", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> methodArgumentTypeMismatchHandler(MethodArgumentTypeMismatchException e){
		return new ResponseEntity<>("Invalid Input, Path variable must be a number!", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> HttpMessageNotReadableHandler(HttpMessageNotReadableException e){
		return new ResponseEntity<>("User's LIST must contain only integer numbers !", HttpStatus.BAD_REQUEST);
	}

}
