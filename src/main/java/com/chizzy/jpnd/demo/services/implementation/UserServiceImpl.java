package com.chizzy.jpnd.demo.services.implementation;

import com.chizzy.jpnd.demo.model.Role;
import com.chizzy.jpnd.demo.model.User;
import com.chizzy.jpnd.demo.repository.UserRepository;
import com.chizzy.jpnd.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void delete(Long userId){
        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails getUserByUsername(String username){
        User user = userRepository.findByEmail(username);
        if (user!= null){
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapUserToRoles(user.getRoles()));
        } else {
            throw new UsernameNotFoundException("Invalid username!");
        }
    }


    private Collection<? extends GrantedAuthority> mapUserToRoles(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
