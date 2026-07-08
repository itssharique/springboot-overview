package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public String getDailyWorkout(){
        return "Run hard for 5 KM" ;
    }
}
