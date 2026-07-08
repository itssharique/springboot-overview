package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Students> theStudents ;

    // Define @PostConstructor to load student data

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>() ;

        theStudents.add(new Students("Poornima","Patel")) ;
        theStudents.add(new Students("Mario","Rossi")) ;
        theStudents.add(new Students("Mary","Smith")) ;
    }

    @GetMapping("/students")
    public List<Students> getStudents(){
        return theStudents ;
    }
}
