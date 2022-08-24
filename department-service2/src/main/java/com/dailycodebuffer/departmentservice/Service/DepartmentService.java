package com.dailycodebuffer.departmentservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.departmentservice.Entity.Department;
import com.dailycodebuffer.departmentservice.Repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		//Log.info("Inside saveDepartment of DepartmentRepository");
				return departmentRepository.save(department);
	}

	public Department getDepartmentById(Long departmentId) {
		//Log.info("Inside getDepartmentById of DepartmentRepository");
		return departmentRepository.findByDepartmentId(departmentId);
	}

	public List<Department> viewAllDepartments() {
		return departmentRepository.findAll();
	}
}
