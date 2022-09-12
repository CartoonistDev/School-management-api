package com.chizzy.jpnd.demo.repository;

import com.chizzy.jpnd.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByClassId(String classId);
}