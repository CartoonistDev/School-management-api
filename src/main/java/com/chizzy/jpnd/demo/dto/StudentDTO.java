package com.chizzy.jpnd.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentDTO {
    private Long studentId;
    @NotBlank(message = "firstname cannot be empty")
    private String firstName;
    @NotBlank(message = "lastname cannot be empty")
    private String lastName;
    @NotNull
    private int age;
    @NotBlank(message = "student class cannot be blank")
    private StudentClassDTO klass;

    private StudentClassDTO getKlass() {
        return klass;
    }

    public void setKlass(StudentClassDTO klass) {
        this.klass = klass;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
