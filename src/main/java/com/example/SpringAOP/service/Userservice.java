package com.example.SpringAOP.service;

import com.example.SpringAOP.entities.User;

import com.example.SpringAOP.exceptionhandling.UserNotFoundException;
import com.example.SpringAOP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userservice {

    @Autowired
    UserRepository userRepository;
//    public void throwuserException() throws Exception {
//       throw new Exception("something wrong");
//     //   System.out.println("hello");
//    }

    public User getUser(Long id) throws Exception {
        Optional<User> user=userRepository.findById(id);
       if(user.isEmpty()){
            //  throw new Exception("User Not Found");
            throw new UserNotFoundException("User Not Found");
       }
       return user.get();
    }
}
