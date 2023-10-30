package crudApp.controller;

import crudApp.entities.Student;
import crudApp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.security.Provider.Service;
import java.util.List;

@Controller
@RequestMapping("/students")
public class CrudController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student s, Model model) {
        // Check if a student with the same ID already exists
        Student existingStudent = studentService.fetchStudentById(s.getKodId());
        if (existingStudent != null) {
            // If a student with the same ID exists, you can handle it accordingly, for example, by showing an error message
            //model.addAttribute("errorMessage", "A student with the same ID already exists.");
            return "student-already-exists"; // Replace "error-page" with the actual page for displaying an error message
        }

        // If no student with the same ID exists, add the new student
        studentService.addStudent(s);

        return "success-page"; // Redirect to the success page
    }


  @GetMapping("/read")
  public String getStudent(@RequestParam("kodId") String kodId, Model m) {
      Student s = studentService.fetchStudentById(kodId);
      if (s != null) {
          m.addAttribute("s", s);
          return "showStudent"; // Student found, show the student details
      } else {
          return "studentNotFound"; // Student not found, redirect to another page
      }
  }
  @PutMapping("/update")
  public String updateStudent(@ModelAttribute Student s) {
      // Check if the student exists
      Student existingStudent = studentService.fetchStudentById(s.getKodId());
      
      if (existingStudent != null) {
          // Student exists, update the information
          studentService.updateStudent(s);
          return "student-update-success"; 
      } else {
          // Student doesn't exist, redirect to the error page
          return "studentNotFound"; // You should define your error page in your view resolver
      }
  }
  @DeleteMapping("/delete")
  public String deleteStudent(@RequestParam("studentId") String studentId) {
      // Check if the student exists
      Student existingStudent = studentService.fetchStudentById(studentId);
      
      if (existingStudent != null) {
          // Student exists, proceed to delete
          studentService.deleteStudentById(studentId);
          return "student-delete-success"; // Redirect to a success page for delete
      } else {
          // Student doesn't exist, redirect to the error page
          return "studentNotFound"; // You should define your error page in your view resolver
      }
  }


    
    @GetMapping("/all")
    public String read(Model m) {
        List<Student> sList = studentService.fetchAllStudents();
        m.addAttribute("sList", sList);
        System.out.println("Fetched " + sList.size() + " students from the database."); // Debugging line
        return "showAllStudents";
    }


}
