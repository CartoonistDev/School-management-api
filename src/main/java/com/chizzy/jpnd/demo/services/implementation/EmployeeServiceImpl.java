package com.chizzy.jpnd.demo.services.implementation;

import com.chizzy.jpnd.demo.model.Employee;
import com.chizzy.jpnd.demo.repository.EmployeeRepository;
import com.chizzy.jpnd.demo.repository.RoleRepository;
import com.chizzy.jpnd.demo.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final RoleRepository roleRepository;

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
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

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
