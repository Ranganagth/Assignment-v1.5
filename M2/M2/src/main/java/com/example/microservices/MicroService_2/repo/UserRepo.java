package com.example.microservices.MicroService_2.repo;


import com.example.microservices.MicroService_2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,String>{
	public User findBydeviceId(final String val);
	
	

}
