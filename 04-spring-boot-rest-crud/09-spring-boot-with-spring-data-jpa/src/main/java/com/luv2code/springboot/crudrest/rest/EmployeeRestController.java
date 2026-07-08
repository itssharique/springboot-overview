package com.luv2code.springboot.crudrest.rest;

import com.luv2code.springboot.crudrest.entity.Employee;
import com.luv2code.springboot.crudrest.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService ;

    private JsonMapper jsonMapper ;

    public EmployeeRestController(EmployeeService theEmployeeService,JsonMapper theJsonMapper){
        this.employeeService = theEmployeeService;
        jsonMapper = theJsonMapper ;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll() ;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId) ;

        if(theEmployee == null){
            throw new RuntimeException("Employee Id is not found : "+employeeId) ;
        }

        return theEmployee ;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // Also in case they pass an id JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0) ;

        Employee dbEmployee = employeeService.save(theEmployee) ;

        return dbEmployee ;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee) ;

        return dbEmployee ;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String,Object> patchPayLoad){

        // Step 1 : Retrieve the existing employee from the database
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee==null){
            throw new RuntimeException("Employee id is not found : " +employeeId) ;
        }

        // Step 2 : Security check for modifying the  id
        if(patchPayLoad.containsKey("id")){
            throw new RuntimeException(
                    "Employee id can not be modified. Remove id from request body."
            ) ;
        }

        // Step 3 : Apply the partial update
        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee,patchPayLoad);

        // Save the updated value to the database and return it
        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee==null){
            throw new RuntimeException("Employee id is not found : " +employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id : " +employeeId ;
    }
}
