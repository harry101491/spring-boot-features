package com.harshit.jpahibernate.service;

import java.util.ArrayList;
import java.util.List;

import com.harshit.jpahibernate.entity.Employee;
import com.harshit.jpahibernate.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service()
public class EmployeeService {
    
    @Autowired()
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);
 
        Page<Employee> pagedResult = employeeRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }
}