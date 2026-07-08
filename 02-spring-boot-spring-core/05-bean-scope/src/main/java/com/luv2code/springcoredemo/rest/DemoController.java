package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define private field for dependency
    private Coach myCoach ;
    private Coach anotherCoach ;

    // Define constructor for dependency
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnotheCoach){

        System.out.println("In constructor "+getClass().getSimpleName());
        myCoach = theCoach ;
        anotherCoach = theAnotheCoach ;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){

        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans myCoach = anotherCoach " +(myCoach==anotherCoach) ;
    }
}
