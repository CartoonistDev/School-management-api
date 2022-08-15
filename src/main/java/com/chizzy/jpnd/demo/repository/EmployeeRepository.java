package com.chizzy.jpnd.demo.repository;

import com.chizzy.jpnd.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
