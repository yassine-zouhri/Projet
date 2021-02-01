package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Incident;
import com.example.entities.IncidentImage;

@Repository
@RepositoryRestResource
@CrossOrigin("*")
public interface IncidentImageRepository extends JpaRepository<IncidentImage,Long>{

}
