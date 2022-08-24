package com.dailycodebuffer.userservice.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.userservice.Entity.Person;
import com.dailycodebuffer.userservice.Exception.NoSuchCustmomerExistsException;
import com.dailycodebuffer.userservice.Exception.UserAlreadyExistsException;
import com.dailycodebuffer.userservice.Repository.UserRepository;
import com.dailycodebuffer.userservice.Vo.Department;
import com.dailycodebuffer.userservice.Vo.RestTemplateVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	public String saveUser(Person person) {
		Person personById = userRepository.findById(person.getUserId()).orElse(null);
		System.out.println(personById);
		if(personById==null) {
			userRepository.save(person);
			return "Person saved successfully";
		}
			else 
			throw new UserAlreadyExistsException("Person already exists");
			
	}

	public List<Person> viewAllUsers() {
				return userRepository.findAll();
	}
	
	public RestTemplateVo getAllDetailsById(Long userId) {
		
		RestTemplateVo vo = new RestTemplateVo();
		Person person = userRepository.findByUserId(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +person.getDepartmentId(), Department.class);
		
		vo.setPerson(person);
		vo.setDepartment(department);
		
		return vo;
		
		
	}

	public Person getUserDetailsById(Long userId) {
		return userRepository.findById(userId).orElseThrow(()->new 
            NoSuchCustmomerExistsException());
	}

	public String updateUser(Person person) {
		Person personById = userRepository.findById(person.getUserId()).orElse(null);
		System.out.println(personById);
		if(personById==null) {
			throw new NoSuchCustmomerExistsException();}
			else {
				personById.setFirstName(person.getFirstName());
            personById.setLastName(person.getLastName());
            personById.setEmailId(person.getEmailId());
            personById.setDepartmentId(person.getDepartmentId());
            userRepository.save(personById);
            return "Record updated Successfully";
			}
	}

public String deleteUser(Long userId) {
	Person personById = userRepository.findById(userId).orElse(null);
	System.out.println(personById);
	if(personById==null) {
		throw new NoSuchCustmomerExistsException();
		}
else {
	userRepository.deleteById(userId);
	return "Person removed successfully";
	 }
		 
		}
}
