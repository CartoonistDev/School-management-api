package com.chizzy.jpnd.demo.model;

import com.chizzy.jpnd.demo.dto.StudentClassDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String firstName;
    private String lastName;
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = StudentClass.class, cascade = CascadeType.ALL)
    @JoinTable(name = "student_class",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id")
            }, inverseJoinColumns = {
            @JoinColumn(name = "class_id", referencedColumnName = "id")
    }
    )
    private @NotBlank(message = "student class cannot be blank") StudentClass klass;

    public Long getStudentId() {
        return studentId;
    }

    public StudentClass getKlass() {
        return klass;
    }

    public void setKlass(StudentClass klass) {
        this.klass = klass;
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
