package com.chizzy.jpnd.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "student_class")
@NoArgsConstructor
@AllArgsConstructor
public class StudentClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    private String className;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_class",
            joinColumns = {
                    @JoinColumn(name = "class_id", referencedColumnName = "id")
            }, inverseJoinColumns = {
            @JoinColumn(name = "employee_id", referencedColumnName = "id")
    }
    )
    private Set<Employee> employee;

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
