package com.chizzy.jpnd.demo.services;

import com.chizzy.jpnd.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long employeeId);
    void deleteEmployee(Long employeeId);
//   public Optional<Employee> getEmployeeRole(Long employeeId){
//        Optional<Employee> employee = employeeRepository.findById(employeeId);
//        List<Role> employeeRole = roleRepository.findAll();
//        employee.stream().map(employee1 -> employeeRole).collect(Collectors.toList());
//
//        return employee;
//    }
}
