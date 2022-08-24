package com.dailycodebuffer.userservice.Vo;

import com.dailycodebuffer.userservice.Entity.Person;

public class RestTemplateVo {

	private Person person;
	private Department department;
	
	public RestTemplateVo() {
		
	}
	
	public RestTemplateVo(Person person, Department department) {
		super();
		this.person = person;
		this.department = department;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
