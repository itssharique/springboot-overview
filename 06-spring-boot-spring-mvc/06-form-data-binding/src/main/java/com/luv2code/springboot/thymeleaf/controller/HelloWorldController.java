package com.luv2code.springboot.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {

    // Need a controller method to show initial HTML form

    @RequestMapping("/showForm")
    public String sayForm() {
        return "helloworld-form";
    }

    // Need a controller method to process HTML form

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // Read the request parameter from HTML
        String theName = request.getParameter("studentName");

        // Convert the data to all capital letter
        theName = theName.toUpperCase();

        // Create the message
        String result = "Yo! " + theName;

        // Add message to the attribute
        model.addAttribute("message",result);

        return "helloworld";

    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        // Convert data to all capital letter
        theName = theName.toUpperCase();

        // Create the message
        String result = "Hey my friend from v3! " + theName;

        // Add message to model
        model.addAttribute("message",result);

        return "helloworld";
    }

}
