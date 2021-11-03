package com.example.H2db.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.H2db.model.User;

import com.example.H2db.service.userRepository.UserRepository;

@Service 
public class Services {
	
	
	public UserRepository userRepository;



	public Services(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	public User saveUser(User user) {
		User p1 = userRepository.save(user);
		return p1; 
	}

	public String editUser(Integer id, User user) {
		userRepository.save(user);
		return "User "+id+" Modified\n"+user;
	}
//
	public boolean existId(int id) {
		return userRepository.existsById(id);
	}
	
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "User "+id+" deleted!\n";
		
	}

	public String firstElement (int id){
		List<Integer> intElements = userRepository.findById(id)
				.get()
				.getIntElements();
		return intElements.get(0)+"\n"+userId(id);
	}
	
	
	public String duplicated (int id) {
		List<Integer> intElements = userRepository.findById(id)
				.get()
				.getIntElements();
		Set<Integer> duplicatedElements = new HashSet<>();
		
		return "Duplicated elements list "
				+intElements.stream()
					.filter(n -> !duplicatedElements.add(n))
					.collect(Collectors.toSet())
				+"\n"+userId(id);
	}
	
	public String maxValue (int id) {
		List<Integer> intElements = userRepository.findById(id)
				.get()
				.getIntElements();
		int max = intElements.stream()
					.mapToInt(v -> v)
					.max().orElseThrow(NoSuchElementException::new);;
		return "The Highest value is: "+max+"\n"+userId(id);
	}

	private String userId(int id) {
		User user = userRepository.findById(id).get();
		return user.toString();
	}
	
	

}
