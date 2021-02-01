package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.UserRole;
import com.example.entities.Users;


@Repository
@RepositoryRestResource
@CrossOrigin("*")
public interface UserRepository extends JpaRepository<Users, Long> {
	
	Users findByEmail(String email);
	
	/*@Query("SELECT user_id,role_id FROM users_roles")
	public List<Object> getUserRole();*/
}
