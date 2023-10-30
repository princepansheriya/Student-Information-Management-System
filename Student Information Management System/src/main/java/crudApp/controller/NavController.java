package crudApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/mainMenu")
	public String mainMenu() {
		return "index";
	}
	
	@GetMapping("/addStudent")
	public String addStudent() {
		return "addStudent";
	}

	@GetMapping("/fetchStudent")
	public String fetchStudent() {
		return "fetchStudent";
	}

	@GetMapping("/updateStudent")
	public String updateStudent() {
		return "updateStudent";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent() {
		return "deleteStudent";
	}

	@GetMapping("/allStudents")
	public String allStudents() {
		return "showAllStudents";
	}
}
