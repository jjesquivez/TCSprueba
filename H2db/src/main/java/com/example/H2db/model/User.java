package com.example.H2db.model;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	public User(int i, String string, List<Integer> asList) {
		this.id = i;
		this.intElements = asList;
		this.userName = string;
		
	}

	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKey
    private int id;

	@Column
    private String userName;
    
//    @ElementCollection
    @Column
    private List<Integer> intElements = new ArrayList<Integer>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	
	public List<Integer> getIntElements() { 
		 return intElements; 
	}
	  
	  
	public void setIntElements(List<Integer> intElements) { 
		this.intElements = intElements; 
	}
	 

    public User(){

    }

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", intElements=" + intElements + "]";
	}
    


}
