package com.example.microservices.MicroService_2.service;


import com.example.microservices.MicroService_2.entity.User;
import com.example.microservices.MicroService_2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	public User getUserByDevice_id(String val) {
		//System.out.println(val);
		return repo.findBydeviceId(val);
		
	}
	
	
	
}

