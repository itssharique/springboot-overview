package com.luv2code.springboot.crudrest.service;

import com.luv2code.springboot.crudrest.dao.EmployeeRepository;
import com.luv2code.springboot.crudrest.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }
        else{
            throw new RuntimeException("Did not find the employee : " +theId);
        }

        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee){
        return employeeRepository.save(theEmployee) ;
    }

    @Transactional
    @Override
    public void deleteById(int theId){
        employeeRepository.deleteById(theId) ;
    }
}
