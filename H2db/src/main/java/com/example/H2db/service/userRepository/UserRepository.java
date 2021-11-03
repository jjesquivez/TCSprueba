package com.example.H2db.service.userRepository;

import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.H2db.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, Integer> {

}
