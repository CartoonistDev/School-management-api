package com.chizzy.jpnd.demo.controllers;

import com.chizzy.jpnd.demo.dto.EmployeeDTO;
import com.chizzy.jpnd.demo.model.Employee;
import com.chizzy.jpnd.demo.services.EmployeeService;
import com.chizzy.jpnd.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeServices;

    private final UserService userServices;

    @PostMapping
    public EmployeeDTO saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
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
        EmployeeDTO employeeDTO = new EmployeeDTO(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhoneNumber());

        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());

        return employeeDTO;
    }
}
