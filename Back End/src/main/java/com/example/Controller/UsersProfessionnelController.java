package com.example.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.UserService;
import com.example.entities.Roles;
import com.example.entities.SpecialisationUser;
import com.example.entities.UserRole;
import com.example.entities.Users;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.repository.UserSpecialisationRepository;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UsersProfessionnelController {

	@Autowired
	private UserRepository usersRepository ;
	
	@Autowired
	private RoleRepository roleRepository ;
	
	@Autowired
	private UserSpecialisationRepository userSpecialisationRepository ;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/listUsers")
	public List<Users> listUsers(){
		return usersRepository.findAll();
	}
	

	
	@GetMapping(value="/listUsers/{id}")
	public Users listUsersById(@PathVariable(name = "id") Long id){
		return usersRepository.findById(id).get();
		
	}
	
	@PutMapping(value="/UpdateUsers/{id}")
	public Users UpdateProduits(@PathVariable(name = "id") Long id, @RequestBody Object p){
		Users user=usersRepository.findById(id).get();
		System.out.println("my user      :="+p.toString());
		String Info=p.toString().replaceAll("}","");
		String [] SplitInfo1=Info.split(",");
		ArrayList<String> SplitInfo2=new ArrayList();
		for(int i=0;i<SplitInfo1.length;i++) {
			SplitInfo2.add(SplitInfo1[i].split("=")[1]);
			System.out.println("  "+i+"=  "+SplitInfo1[i] );
			System.out.println("  "+i+"=  "+SplitInfo2.get(i) );
		}
		user.setUsername(SplitInfo2.get(0));
		user.setEmail(SplitInfo2.get(1));
		user.setPassword(SplitInfo2.get(2));
		user.setFirstName(SplitInfo2.get(3));
		user.setLastName(SplitInfo2.get(4));
		user.setN_telephone(SplitInfo2.get(5));
		SpecialisationUser specialisation=new SpecialisationUser(SplitInfo2.get(6), SplitInfo2.get(7));
		user.setSpecialisation(specialisation);
		return usersRepository.save(user);
		
	}
	
	@PostMapping(value="/AddUsers")
	public void AddProduits(@RequestBody Object p){
		String Info=p.toString().replaceAll("}","");
		String [] SplitInfo1=Info.split(",");
		ArrayList<String> SplitInfo2=new ArrayList();
		System.out.println("adddddddddddddddd uuuuuuuuuuserrrrrrrrrr="+p.toString());
		for(int i=0;i<SplitInfo1.length;i++) {
			SplitInfo2.add(SplitInfo1[i].split("=")[1]);
			System.out.println("  "+i+"=  "+SplitInfo1[i] );
			System.out.println("  "+i+"=  "+SplitInfo2.get(i) );
		}
		String username=SplitInfo2.get(0);
		String email=SplitInfo2.get(1);
		String password=SplitInfo2.get(2);
		String firstName=SplitInfo2.get(4);
		String lastName=SplitInfo2.get(5);
		String n_telephone=SplitInfo2.get(6);
		
		//Roles role=new Roles(SplitInfo2.get(8));
		Roles role=new Roles();
		SpecialisationUser specialisationUser=new SpecialisationUser();
		if(SplitInfo2.get(9)!=null && SplitInfo2.get(8)!=null) {
			specialisationUser=new SpecialisationUser(SplitInfo2.get(9),SplitInfo2.get(10));
		}else {
			specialisationUser=new SpecialisationUser(" "," ");
		}
		
		if(SplitInfo2.get(8).equals("ADMIN")) {
			role=new Roles((long) 2,"ADMIN");
		}else {role=new Roles((long) 1,"USER");}
		Collection<Roles> roles = new ArrayList<Roles>();
		roles.add(role);
		Users user=new Users(firstName, lastName, email, password, n_telephone, username, roles,specialisationUser);
		System.out.println("myyyyyyyyyyyyyy idddddddddddddd"+user.toString());
		Users a1=usersRepository.save(user);
		System.out.println("myyyyyyyyyyyyyy idddddddddddddd"+a1.getSpecialisation().getSecteur());
		//return usersProfessionnelRepository.save(p);
	}
	
	
	@GetMapping(value="/AjouterUser")
	public void AddProduits(){
		
		String username="walid";
		String email="walid@gmail.com";
		String password="admin";
		String firstName="walid";
		String lastName="rakha";
		String n_telephone="0666666630";
		

		SpecialisationUser specialisationUser=new SpecialisationUser("Incident routier","collision multiples");
		
		Roles role=new Roles((long) 2,"ADMIN");
		
		Collection<Roles> roles = new ArrayList<Roles>();
		roles.add(role);
		Users user=new Users(firstName, lastName, email, password, n_telephone, username, roles,specialisationUser);
		System.out.println("myyyyyyyyyyyyyy idddddddddddddd"+user.toString());
		Users a1=usersRepository.save(user);
		System.out.println("myyyyyyyyyyyyyy idddddddddddddd"+a1.getSpecialisation().getSecteur());
		//return usersProfessionnelRepository.save(p);
	}
	
	
	@DeleteMapping(value="/deleteUsers/{id}")
	public void deleteProfessionnel(@PathVariable(name = "id") Long id){
		usersRepository.deleteById(id);
	}
	
	@RequestMapping(value="/banque")
	public void aaaa(Principal principal) {
		System.out.println("usssssssssssrrrrrrrrrr="+principal.getName());
		System.out.println("ffffffffffffffffffffffffffffffffffffffffffffff");
		System.out.println("1111111111111111111111111111111111111111111111");
	}
	
	@GetMapping(value="/listSpecialisation")
	public List<SpecialisationUser> GetSpecialisationUser(){
		return userSpecialisationRepository.findAll();
		
	}
	
	@GetMapping(value="/GetUserByEmail")
	//@RequestParam("email") String email,@RequestParam("password") String password
	public Object[] getRoleUser(@RequestParam("email") String email) throws NoSuchFieldException, SecurityException {
		Users User= usersRepository.findByEmail(email);
		Collection<Roles> a=User.getRoles();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Object[] b=a.toArray();
		return b; 

		
	}
	
	

}
