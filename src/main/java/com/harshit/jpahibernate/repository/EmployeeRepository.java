package com.harshit.jpahibernate.repository;

import com.harshit.jpahibernate.entity.Employee;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}