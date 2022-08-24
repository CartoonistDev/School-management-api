package com.chizzy.jpnd.demo.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {
    private Long id;
    @NotBlank(message = "firstname cannot be empty")
    private String firstName;
    @NotBlank(message = "lastname cannot be empty")
    private String lastName;
    @NotBlank(message = "password cannot be empty")
    private String password;
    @NotBlank(message = "email cannot be empty")
    private String email;

    public UserDTO(String firstName, String lastName, String password, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
