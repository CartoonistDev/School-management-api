package com.chizzy.jpnd.demo.controllers;

import com.chizzy.jpnd.demo.dto.UserDTO;
import com.chizzy.jpnd.demo.model.User;
import com.chizzy.jpnd.demo.services.implementation.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userServices;

    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        try {
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setPassword(userDTO.getPassword());
            return myUserDTO(userServices.saveUser(user));
        } catch (RuntimeException e){
            throw new RuntimeException("User was not saved, please try again");
        }
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@RequestBody String username){
        try {
            User user = (User) userServices.getUserByUsername(username);
            return myUserDTO(user);
        } catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("User was not found, please try again");
        }
    }

    @GetMapping("/delete/{userId}")
    public void deleteUser(@PathVariable(value = "id") Long userId){
        this.userServices.delete(userId);
    }


    private UserDTO myUserDTO(User user){

        UserDTO userDTO = new UserDTO(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());

        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
