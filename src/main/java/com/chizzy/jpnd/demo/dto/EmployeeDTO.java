package com.chizzy.jpnd.demo.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "firstname cannot be empty")
    private String firstName;

    @NotBlank(message = "lastname cannot be empty")
    private String lastName;

    @NotBlank(message = "email cannot be empty")
    private String email;
    @NotNull(message = "phone number cannot be empty")
    private int phoneNumber;

    public EmployeeDTO(String firstName, String lastName, String email, int phoneNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
