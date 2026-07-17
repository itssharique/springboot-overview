package com.luv2code.springboot.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /*
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // Read the request parameter from HTML
        String theName = request.getParameter("studentName");

        // Convert the data to all capital letter
        theName = theName.toUpperCase();

        // Create the message
        String result = "Yo! " + theName;

        // Add message to the attribut
        model.addAttribute("message",result);

        return "helloworld";



    }
     */

}
