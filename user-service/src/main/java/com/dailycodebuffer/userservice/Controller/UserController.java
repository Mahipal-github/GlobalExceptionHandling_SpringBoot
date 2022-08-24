package com.dailycodebuffer.userservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.userservice.Entity.Person;
import com.dailycodebuffer.userservice.Service.UserService;
import com.dailycodebuffer.userservice.Vo.RestTemplateVo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@PostMapping("/addUser")
	public String saveUser(@RequestBody Person person) {
		return userService.saveUser(person);
	}
	
	@GetMapping("/getUsers")
	public List<Person> viewUsers(){
		return userService.viewAllUsers();
	}
		
		@GetMapping("/userwithdep/{id}")
		public RestTemplateVo getAllDetailsById(@PathVariable("id") Long userId) {
			return userService.getAllDetailsById(userId);
		}
		
		@GetMapping("/{id}")
		public Person getUserDetailsById(@PathVariable("id") Long userId) {
				return userService.getUserDetailsById(userId);
				
		}
		
		@PutMapping("/updateuser")
		public String updateUser(@RequestBody Person person) {
			return userService.updateUser(person);
		}
		
		@DeleteMapping("/deleteuser/{id}")
		public String deleteUser(@PathVariable("id") Long userId) {
			return userService.deleteUser(userId);
			
	}
	
}
