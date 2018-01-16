package com.gradle.sample.service;

import com.gradle.sample.model.User;
import com.gradle.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    UserRepository userRepository;
    public int insert(String name,String username,String password){
        try{
            User user=new User(username,password,name);
            userRepository.save(user);
            return 1;
        }catch(Exception e){
            return 0;
        }

    }
}
