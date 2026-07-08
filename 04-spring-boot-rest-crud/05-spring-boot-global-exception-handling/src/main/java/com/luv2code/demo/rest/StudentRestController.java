package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Students;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students/{studentId}")
    public Students getStudent(@PathVariable int studentId){

        if(studentId>=theStudents.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found: "+studentId);
        }
        return theStudents.get(studentId);
    }


}
