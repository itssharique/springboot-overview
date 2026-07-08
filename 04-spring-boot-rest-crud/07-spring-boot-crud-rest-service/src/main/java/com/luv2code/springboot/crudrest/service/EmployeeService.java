package com.luv2code.springboot.crudrest.service;

import com.luv2code.springboot.crudrest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll() ;
}
