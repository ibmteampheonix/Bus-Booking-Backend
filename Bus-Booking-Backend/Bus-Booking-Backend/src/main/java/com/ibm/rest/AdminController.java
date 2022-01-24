package com.ibm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Admin;
import com.ibm.service.AdminService;
import com.ibm.service.LoginService;

@CrossOrigin
@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping(value="/admin", consumes = {"application/json"})
	void addAdmin(@RequestBody Admin admin)
	{
		service.addAdmin(admin);
	}
	
	@GetMapping(value="/admin/{email}/{password}",produces = "application/json")
	public ResponseEntity<?> validate(@PathVariable String email,@PathVariable String password)
	{
		LoginService login=new LoginService(email,password);
		try {
			Admin admin=service.authenticateAdmin(login);
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Invalid Email Id or Password",HttpStatus.NOT_FOUND);
		}
	}
	

}
