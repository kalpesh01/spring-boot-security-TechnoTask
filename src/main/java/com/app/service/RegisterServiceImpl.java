package com.app.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.User;
import com.app.repo.UserRepo;

@Service
public class RegisterServiceImpl {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	UserRepo userRepo;
	
//	@Autowired
//	 JavaMailSender javaMailSender;
	
	public User registerUser(User user)
	{
		
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		String autoPass = generateRandomPassword(10);
		System.out.println("Password is....."+autoPass);
		user.setPassword(passwordEncoder.encode(autoPass));
		userRepo.save(user);
		sendRgisterCredMail(user.getEmail(),autoPass);
		return user;
	}
	
	public boolean userExist(String email) {
		User user = userRepo.findUser(email);
		if(user == null)
			return true;
		return false;
	}  
	
	public void sendRgisterCredMail(String email,String str)
	{
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kpraje5141@gmail.com");
        message.setTo(email);
        message.setSubject("Welcome to ABC Corporation");
        message.setText("you have registered successfully your credentials are.  username: "+email+" AND  password: "+str);
        mailSender.send(message);
	}
	
	//generate random password
	public  String generateRandomPassword(int len)
    {
        
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
	
	
	public List<User> allUsers()
	{
		List<User> userList = userRepo.getAllUsers();
		return userList;
	}
 
   public int updateUser(User user)
   {
	   
	   return this.userRepo.updateUser(user.getFirstName(), user.getLastName(),
			   						   user.getCompany(),user.getTitle(),
			   						   user.getPhNum(), user.getDepartment(),
			   						   user.getJobType(),user.getEmail());
   }
	
   
   public User findUser(String email)
   {
	   return this.userRepo.findUser(email);
   }
   
   public int deleteUser(String email)
   {
	   return this.userRepo.deleteUser(email);
   }
}
