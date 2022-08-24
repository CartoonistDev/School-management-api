package com.chizzy.jpnd.demo.services.implementation;

import com.chizzy.jpnd.demo.model.Student;
import com.chizzy.jpnd.demo.model.StudentClass;
import com.chizzy.jpnd.demo.repository.StudentRepository;
import com.chizzy.jpnd.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student;
        if (studentOptional.isPresent()){
            return student = studentOptional.get();
        } else {
            throw new RuntimeException("Student with id: " + studentId + " not found");
        }
    }

    @Override
    public Student saveStudent(Student student, StudentClass studentClass){
        student.setKlass(studentClass);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }
}
