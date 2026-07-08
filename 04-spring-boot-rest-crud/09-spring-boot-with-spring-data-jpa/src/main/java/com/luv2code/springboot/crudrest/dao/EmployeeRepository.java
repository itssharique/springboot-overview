package com.luv2code.springboot.crudrest.dao;

import com.luv2code.springboot.crudrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
