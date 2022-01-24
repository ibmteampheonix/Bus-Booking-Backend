package com.ibm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	@Query(value="select * from admin where admin_email=:email and admin_password=:pass",nativeQuery = true)
	Optional<Admin> authAdmin(@Param("email") String email,@Param("pass")String password);

}
