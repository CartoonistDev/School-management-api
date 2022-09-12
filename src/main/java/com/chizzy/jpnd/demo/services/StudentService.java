package com.chizzy.jpnd.demo.services;

import com.chizzy.jpnd.demo.dto.StudentClassDTO;
import com.chizzy.jpnd.demo.model.Student;
import com.chizzy.jpnd.demo.model.StudentClass;

import javax.validation.constraints.NotBlank;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudent(Long studentId);
    Student saveStudent(Student student, StudentClass studentClass);
    void deleteStudent(Long studentId);
}
