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
			createManyStudent(studentDAO) ;
		};
	}

	public void createManyStudent(StudentDAO studentDAO){
		// Creating the object of student
		System.out.println("Creating student object...");
		Student tempStudent1 = new Student("John","Marry","john@luv2code") ;
		Student tempStudent2 = new Student("Anna","Marry","anna@luv2code") ;
		Student tempStudent3 = new Student("Wales","Public","wales@luv2code") ;

		// Safe the object
		System.out.println("Saving the object of student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		// Display id of save student
		System.out.println("Saved student. Generated Id: " +tempStudent1.getId());
		System.out.println("Saved student. Generated Id: " +tempStudent2.getId());
		System.out.println("Saved student. Generated Id: " +tempStudent3.getId());
	}


	private void createStudent(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("Creating the student object ...") ;
		Student tempStudent = new Student("Paul","Doe","paul@luv2code") ;

		// Save the student object
		System.out.println("Saving the student object ...") ;
		studentDAO.save(tempStudent);

		// Display id of save student
		System.out.println("Saved student. Generated id: " +tempStudent.getId());
	}

}
