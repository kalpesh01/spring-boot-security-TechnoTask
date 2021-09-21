package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.User;
import com.app.service.RegisterServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	RegisterServiceImpl userService;
	
	
	
	@GetMapping("/")
	public String homePage()
	{
		return "Welcome To Home Page";
	}
	
	@PostMapping("/registerUser")
	public String add(@RequestBody User user)
	{
		boolean res = userService.userExist(user.getEmail());
		if(res)
		{
			this.userService.registerUser(user);
			return "Successfully registered...";
		}else
		{
			return "Alredy regestered with this email use another one...!";
		}
		 
	}
	
	@GetMapping("/getAllUsersList")
	public List<User> getAllUsers()
	{
		return this.userService.allUsers();
	}
	
	@PostMapping("/update")
	public boolean updateUsers(@RequestBody User user)
	{
		int res=this.userService.updateUser(user);
		if(res!=1)
		{
			return false;
		}else {
			return true;
		}
		
	}
	
//	http://localhost:8080/users/abcd@gmail.com
	
	@GetMapping("/getUser/{email}")
	public User getUser(@PathVariable("email")String email)
	{
		return this.userService.findUser(email); 
	}
	
	@PutMapping("/delete/{email}")
	public String deleteUser(@PathVariable("email")String email)
	{
		int res=this.userService.deleteUser(email);
		if(res!=1)
		{
			return "Failed to Delete....!";
		}else {
			return "Succefully Deleted...";
		}
		 
	}
}
