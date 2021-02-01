package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.core.userdetails.User;

import com.example.entities.Roles;
import com.example.entities.SpecialisationUser;
import com.example.entities.Users;

import com.example.repository.UserRepository;


@SpringBootApplication
@ComponentScan({"com.example.demo","com.example.entities","com.example.repository","com.example.Controller","com.example.SpringSecurity","com.example.Service"})
@EntityScan("com.example.entities")
@EnableJpaRepositories("com.example.repository")
@EnableJpaAuditing
public class ProjetGeoInfo1Application implements CommandLineRunner{

	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetGeoInfo1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		//usersProfessionnelRepository.save(new UsersProfessionnel("Zouhri", "Yassine", "0623742230", "yassinezouhri98@gmail.com", "yassinezouhri98@gmail.com", "yassine1998", "secteur", "type"));
		//usersProfessionnelRepository.save(new UsersProfessionnel("Zouhri", "Yassine", "0623742230", "yassinezouhri98@gmail.com", "yassinezouhri98@gmail.com", "yassine1998", "secteur", "type"));
		//usersProfessionnelRepository.findAll().forEach(p->{System.out.println(p.toString());});
		//Roles role=new Roles((long) 1,"ADMIN");
		//Collection<Roles> roles = new ArrayList<Roles>();
		//roles.add(role);
		//SpecialisationUser specialisationUser=new SpecialisationUser(" "," ");
		//Users user=new Users("Yassine", "Zouhri","yassine@gmail.com","admin1", "0623742230", "admin", roles,specialisationUser);
		//userRepository.save(user);
		userRepository.findAll().forEach(p->{System.out.println("    "+p.getEmail());});
		
	}

}
