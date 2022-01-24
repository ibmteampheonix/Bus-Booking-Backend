package com.ibm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.User;
//import com.ibm.service.EmailService;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select * from user where email_id=:email_id and password=:pass",nativeQuery = true)
	Optional<User> authUser(@Param("email_id") String email_id,@Param("pass") String password);
	
	@Query(value="select * from user where email_id=:email_id", nativeQuery = true)
	User findUserById(@Param("email_id") String email_id);
	
	

}
