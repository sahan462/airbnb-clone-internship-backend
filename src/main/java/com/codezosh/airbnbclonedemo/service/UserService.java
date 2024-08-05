package com.codezosh.airbnbclonedemo.service;

import com.codezosh.airbnbclonedemo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User getUserProfile(String jwt);
    public List<User> getAllUsers();

}
