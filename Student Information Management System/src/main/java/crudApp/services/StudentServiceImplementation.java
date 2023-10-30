package crudApp.services;

import crudApp.entities.Student;
import crudApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addStudent(Student s) {
        studentRepository.save(s);
        return "Student added successfully!";
    }

    @Override
    public Student fetchStudentById(String kodId) {
        return studentRepository.findByKodId(kodId);
    }

    @Override
    public String updateStudent(Student s) {
        studentRepository.save(s);
        return "Student updated successfully!";
    }

    @Override
    public String deleteStudentById(String kodId) {
        studentRepository.deleteById(kodId);
        return "Student deleted successfully!";
    }

    @Override
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }
    
    

	

}
