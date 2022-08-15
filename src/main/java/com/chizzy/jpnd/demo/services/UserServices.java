package com.chizzy.jpnd.demo.services;

import com.chizzy.jpnd.demo.model.Role;
import com.chizzy.jpnd.demo.model.User;
import com.chizzy.jpnd.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        User newUser = new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return userRepository.save(newUser);
    }

    public void delete(Long userId){
        userRepository.deleteById(userId);
    }
    public UserDetails getUserByUsername(String username){
        User user = userRepository.findByEmail(username);
        if (user!= null){
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapUserToRoles(user.getRoles()));
        } else {
            throw new UsernameNotFoundException("Username or password invalid!");
        }
    }

    private Collection<? extends GrantedAuthority> mapUserToRoles(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
