package com.example.SpringAOP;

import com.example.SpringAOP.entities.User;
import com.example.SpringAOP.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Test
	void contextLoads() {
		User user=new User();
		user.setName("Pawan");

		user.setEmailId("pawan@gmail.com");
		userRepository.save(user);
	}

}
