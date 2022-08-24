package com.dailycodebuffer.departmentservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.departmentservice.Entity.Department;
import com.dailycodebuffer.departmentservice.Service.DepartmentService;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@CrossOrigin
	@PostMapping(value="/addDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		//Log.info("Inside saveDepartment of DepartmentController");
		
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/getDepartments")
	public List<Department> viewAllDepartments() {
		return departmentService.viewAllDepartments();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) {
		//Log.info("Inside getDepartmentById of DepartmentController");
		return departmentService.getDepartmentById(departmentId);
	}
}
