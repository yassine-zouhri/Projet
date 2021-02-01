package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Incident;
import com.example.entities.Roles;

@Repository
@RepositoryRestResource
@CrossOrigin("*")
public interface RoleRepository extends JpaRepository<Roles,Long>{
	
	/*@RestResource(path="/ByUsername")
	public List<UsersProfessionnel> FindByUsername(@Param("Username") String Username);
	
	@RestResource(path="/ByEmail")
	public List<UsersProfessionnel> FindByIEmail(@Param( "Email") String Email);*/
}
