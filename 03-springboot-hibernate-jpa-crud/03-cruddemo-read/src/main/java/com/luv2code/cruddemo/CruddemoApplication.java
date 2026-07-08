package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			readStudent(studentDAO) ;
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Creating the object...");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code");

		// Save the object
		System.out.println("Saving the object...");
		studentDAO.save(tempStudent) ;

		// Display id of save student
		int theId = tempStudent.getId() ;
		System.out.println("Saved student. Generated Id: " +theId);

		// Retrieve student based on the id: Primary Key
		Student myStudent = studentDAO.findById(theId) ;

		// Display the student
		System.out.println("Found the student: " +myStudent);
	}


}
