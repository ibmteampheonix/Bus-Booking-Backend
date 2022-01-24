package com.ibm.service;

//import java.util.List;

import com.ibm.entity.Admin;


public interface AdminService {
	
	void addAdmin(Admin admin);
	
	Admin authenticateAdmin(LoginService login);
	
	/*List<Admin> findaAll();*/
}
