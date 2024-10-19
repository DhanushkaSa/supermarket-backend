package com.supermarket.system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.supermarket.system.entity.User;
import com.supermarket.system.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    

    @Override

    public User createUser(User user) {

        
        return userRepository.save(user);
    }



    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
