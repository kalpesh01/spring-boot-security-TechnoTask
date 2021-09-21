package com.app.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.dao.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	
	
	@Query(value= "SELECT * FROM user WHERE email = ?",nativeQuery = true)
	public User findUser(String email);
	
	@Query(value= "SELECT * from user",nativeQuery = true)
	List<User> getAllUsers();
	
	
	@Transactional
	@Modifying
	@Query(value= "UPDATE user SET first_Name = ?, last_Name = ?,company=?,title=?,ph_Num=?,department=?,job_Type=? where email = ?",nativeQuery = true)
	int updateUser(
			String fName,
			String lastName,
			String company,
			String title,
			String phNum,
			String department,
			String jobType,
			String email);
	
	
	
	
	@Transactional
	@Modifying
	@Query(value= "delete from user where email =?",nativeQuery = true)
	int deleteUser(String email);
}
