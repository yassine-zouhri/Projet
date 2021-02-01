package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.SpecialisationUser;



@Repository
@RepositoryRestResource
@CrossOrigin("*")
public interface UserSpecialisationRepository extends JpaRepository<SpecialisationUser,Long>{

}
