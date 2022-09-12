package com.chizzy.jpnd.demo.controllers;

import com.chizzy.jpnd.demo.dto.StudentClassDTO;
import com.chizzy.jpnd.demo.dto.StudentDTO;
import com.chizzy.jpnd.demo.model.Student;
import com.chizzy.jpnd.demo.model.StudentClass;
import com.chizzy.jpnd.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    public final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO, StudentClassDTO classDTO){
        try {
            Student student = new Student();
            student.setKlass(student.getKlass());
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setAge(studentDTO.getAge());

            StudentClass studentClass = new StudentClass();
            studentClass.setClassName(classDTO.getClassName());

            return studentDTO(studentService.saveStudent(student, studentClass));
        } catch (RuntimeException e){
            throw new RuntimeException("Student was not saved, please try again");
        }

    }

    @GetMapping("/{studentId}")
    public StudentDTO getStudent(@RequestBody Long studentId){
        Student student = studentService.getStudent(studentId);
        if (student != null){
            return studentDTO(student);
        } else {
            throw new UsernameNotFoundException("Student was not found, please enter correct student ID!");
        }
    }

    @GetMapping("/delete/{studentId}")
    public void deleteStudent(@PathVariable(value = "id") Long studentId){
        try {
            this.studentService.deleteStudent(studentId);
        } catch (RuntimeException e){
            throw new RuntimeException("Student was not found, please enter correct student ID!");
        }
    }


    private StudentDTO studentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());
        return studentDTO;

    }

    private StudentClassDTO classDTO(StudentClass studentClass){
        StudentClassDTO studentClassDTO = new StudentClassDTO();

        studentClassDTO.setClassName(studentClass.getClassName());

        return studentClassDTO;
    }
}
