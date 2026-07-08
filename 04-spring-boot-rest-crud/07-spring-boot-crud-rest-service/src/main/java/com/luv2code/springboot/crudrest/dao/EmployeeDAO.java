package com.luv2code.springboot.crudrest.dao;

import com.luv2code.springboot.crudrest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll() ;
}
