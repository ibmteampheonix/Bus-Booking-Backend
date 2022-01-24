package com.ibm.service;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Admin;
import com.ibm.repo.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	public AdminRepository repo;
	
	@Override
	public void addAdmin(Admin admin) {
		repo.save(admin);
	}
	
	@Override
	public Admin authenticateAdmin(LoginService login) {
		
		return repo.authAdmin(login.getEmail(), login.getPassword()).orElseThrow(()->new IllegalArgumentException("Invalid user or password"));
	}

	/*@Override
	public List<Admin> findaAll() {
		
		return repo.findAll();
	}*/

}
