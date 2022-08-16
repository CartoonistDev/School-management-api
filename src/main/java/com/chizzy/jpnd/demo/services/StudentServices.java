package com.chizzy.jpnd.demo.services;

import com.chizzy.jpnd.demo.model.Student;
import com.chizzy.jpnd.demo.model.StudentClass;
import com.chizzy.jpnd.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudent(Long studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student;
        if (studentOptional.isPresent()){
            return student = studentOptional.get();
        } else {
            throw new RuntimeException("Student with id: " + studentId + " not found");
        }
    }

    public Student saveStudent(Student student, StudentClass studentClass){
        student.setKlass(studentClass);
        return studentRepository.save(student);
    }

    

}
