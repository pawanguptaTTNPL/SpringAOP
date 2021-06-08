package com.example.SpringAOP.service;

import com.example.SpringAOP.entities.User;
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

    public User getUser(Long id) {
        Optional<User> user=userRepository.findById(id);
        System.out.println("after null");
        if(user.isEmpty())
        {
            try {
                throw new Exception("User Not Found");


            } catch (Exception e) {
                //
            }

        }
       return user.get();
    }
}
