package com.harshit.jpahibernate.controller;

import java.util.List;

import com.harshit.jpahibernate.entity.Employee;
import com.harshit.jpahibernate.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired()
    EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployee(
        @RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        List<Employee> listOfEmployees = employeeService.getAllEmployees(
            pageNo, pageSize
        );
        return new ResponseEntity<List<Employee>>(listOfEmployees, HttpStatus.OK);
    }

}