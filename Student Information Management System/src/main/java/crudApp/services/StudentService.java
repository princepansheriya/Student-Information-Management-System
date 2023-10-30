package crudApp.services;

import crudApp.entities.Student;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

public interface StudentService {

    // Add a new student
    String addStudent(Student s);

    // Fetch a single student by ID
    Student fetchStudentById(String kodId);

    // Update an existing student
    String updateStudent(Student s);

    // Delete a student by ID
    String deleteStudentById(String kodId);

    // Fetch all students and return them as a list
    List<Student> fetchAllStudents();
    
    
}
