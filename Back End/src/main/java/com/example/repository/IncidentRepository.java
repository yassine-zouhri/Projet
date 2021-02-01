package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Incident;


@Repository
@RepositoryRestResource
@CrossOrigin("*")
public interface IncidentRepository extends JpaRepository<Incident,Long>{
	
	/*@RestResource(path="/searchByIME")
	public List<Incident> FindByIME(@Param( "IME") String IME);*/
	
}
