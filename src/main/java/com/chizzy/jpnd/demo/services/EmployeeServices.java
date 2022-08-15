package com.chizzy.jpnd.demo.services;

import com.chizzy.jpnd.demo.model.Employee;
import com.chizzy.jpnd.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
       return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long employeeId){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        Employee employee;
        if (optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        } else {
            throw new RuntimeException("Employee with id: " + employeeId + " not found");
        }
        return employee;
    }

    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

}
