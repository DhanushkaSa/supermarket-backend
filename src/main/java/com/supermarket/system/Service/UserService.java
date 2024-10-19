package com.supermarket.system.Service;

import org.springframework.stereotype.Service;

import com.supermarket.system.entity.User;

import java.util.*;

@Service
public interface UserService {
    
    public User createUser(User user);

    public User getUser(Long id);

    public List<User> getAllUsers();
}
