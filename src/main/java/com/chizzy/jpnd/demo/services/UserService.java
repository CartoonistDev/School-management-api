package com.chizzy.jpnd.demo.services;

import com.chizzy.jpnd.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    void delete(Long userId);
    UserDetails getUserByUsername(String username);
}
