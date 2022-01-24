package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ibm.entity.User;
import com.ibm.pojo.Login;
import com.ibm.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public void addUser(User user) {
		repo.save(user);

	}

	@Override
	public User findUserById(String email_id) {
		return repo.findUserById(email_id);
	}
	
	@Override
	public User authenticateUser(Login login) {
		return repo.authUser(login.getEmail_id(), login.getPassword()).orElseThrow(()->new IllegalArgumentException("invalid emailid or password"));
	}


}
