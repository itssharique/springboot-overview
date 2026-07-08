package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{

			createMultipleStudent(studentDAO) ;

			// readStudent(studentDAO) ;

			// queryForStudent(studentDAO) ;

			// queryForStudentByLastName(studentDAO) ;

			// updateStudent(studentDAO) ;

			// deleteStudent(studentDAO) ;

			//deleteAllStudents(studentDAO) ;
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com") ;
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com") ;
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com") ;

		System.out.println("Saving the student...") ;
		studentDAO.save(tempStudent1) ;
		studentDAO.save(tempStudent2) ;
		studentDAO.save(tempStudent3) ;
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Delete all the student...");
		int numRowsDeleted = studentDAO.deleteAll() ;
		System.out.println("Delete row count: " +numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3 ;
		System.out.println("Deleting student id: " +studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on id
		int studentId = 1 ;
		System.out.println("Getting student with studentId : " +studentId);
		Student myStudent = studentDAO.findById(studentId) ;

		// Change first nam to John
		System.out.println("Updating student...");
		myStudent.setFirstName("John") ;

		// Update the student
		studentDAO.update(myStudent) ;

		// Display the updated student
		System.out.println("Updated student: " +myStudent) ;
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.findByLastName("Marry") ;

		// Display list of student
		for(Student tempStudent : theStudent){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll() ;

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

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
