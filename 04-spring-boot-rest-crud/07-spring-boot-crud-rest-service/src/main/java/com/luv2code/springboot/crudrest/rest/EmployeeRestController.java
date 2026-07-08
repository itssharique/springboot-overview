package com.luv2code.springboot.crudrest.rest;

import com.luv2code.springboot.crudrest.dao.EmployeeDAO;
import com.luv2code.springboot.crudrest.entity.Employee;
import com.luv2code.springboot.crudrest.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService ;

    public EmployeeRestController(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll() ;
    }
}
