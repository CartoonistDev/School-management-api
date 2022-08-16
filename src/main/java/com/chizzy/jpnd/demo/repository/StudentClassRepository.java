package com.chizzy.jpnd.demo.repository;

import com.chizzy.jpnd.demo.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
}
