package com.chizzy.jpnd.demo.controllers;

import com.chizzy.jpnd.demo.dto.EmployeeDTO;
import com.chizzy.jpnd.demo.model.Employee;
import com.chizzy.jpnd.demo.services.EmployeeServices;
import com.chizzy.jpnd.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeServices;

    @Autowired
    private UserServices userServices;

    @PostMapping
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        try {
            //Using DTOs to help eliminate client input directly in sync with services

            Employee newEmployee = new Employee();
            newEmployee.setEmail(employeeDTO.getEmail());
            newEmployee.setFirstName(employeeDTO.getFirstName());
            newEmployee.setLastName(employeeDTO.getLastName());
            newEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());

            return employeeDTO(employeeServices.saveEmployee(newEmployee));
        } catch (RuntimeException e){
            throw new RuntimeException("Employee was not saved, please try again");
        }
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@RequestBody Long employeeId){
        try {
            Employee employee = employeeServices.getEmployeeById(employeeId);
            return employeeDTO(employee);
        } catch (RuntimeException e){
            throw new RuntimeException("Employee with id: " + employeeId + " was not found, please try again");
        }
    }

    @GetMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable(value = "id") Long employeeId){
        try {
            employeeServices.deleteEmployee(employeeId);
        } catch (RuntimeException e){
            throw new RuntimeException("Employee was not deleted, please try again");
        }
    }


    //Converting user input "DTO" to actual objects to be used by the database
    private EmployeeDTO employeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());

        return employeeDTO;
    }
}
