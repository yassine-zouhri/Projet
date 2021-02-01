package com.example.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.entities.Incident;
import com.example.entities.IncidentImage;

import com.example.entities.Users;
import com.example.repository.IncidentImageRepository;
import com.example.repository.IncidentRepository;


//@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8100","http://localhost:8101","http://localhost:9090"})
@CrossOrigin("*")
@RestController
public class InterfaceMapController {
	@Autowired
	private IncidentRepository incidentRepository;
	
	@Autowired
	private IncidentImageRepository incidentImageRepository;
	
	
	
	@GetMapping(value="/listIncident")
	public List<Incident> listIncident(){
		System.out.println("my userv innnnnnnn methode");
		return incidentRepository.findAll();
	}
	

	//@RequestMapping(value = "/photo" , method = RequestMethod.POST)
	@PostMapping("/AddIncident")
	//@RequestParam("data")
	public void addPhotoData(@RequestBody MultipartFile imageData,@RequestParam("MonSecteur") String MonSecteur,
			@RequestParam("MonType") String MonType,@RequestParam("longitude") String longitude,
			@RequestParam("latitude") String latitude,@RequestParam("MaRegion") String MaRegion,
			@RequestParam("MaProvince") String MaProvince,@RequestParam("MaVille") String MaVille,
			@RequestParam("Description") String Description,@RequestParam("IMEIcode") String IMEIcode) {
		System.out.println("aaaaaaaaaaaaa          ="+MonSecteur+" "+MonType+" "+longitude+" "+latitude+" "+MaRegion+" "+MaProvince+" "+MaVille+" "+Description+"  "+IMEIcode);
		System.out.println("innnnnnnnnnn   "+(imageData.getSize()/1024)+"ko");
		
	
	    try {
	    	Incident newIncident= incidentRepository.save(new Incident(MonSecteur, MonType, null, null,Double.valueOf(latitude),Double.valueOf(longitude), MaProvince, MaRegion, MaVille, Description, IMEIcode, new Date()));
	    	System.out.println("myyyyyyyyyyyyyyyyyyyyyyyy idddddddddddddddddddd=     "+newIncident.getId());
	    	incidentImageRepository.save(new IncidentImage(newIncident.getId(), imageData.getBytes()));
	    	//PhotoFile doc = new PhotoFile(imageData.getBytes());
	        //photoFileRepository.save(doc);
	        System.out.println(imageData.getInputStream());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	@PostMapping("/AddPhoto")
	//@RequestParam("data")
	public void addPhotoData(@RequestParam("imageData")  MultipartFile imageData,@RequestParam("id_incident") Long id_incident ) {
		
		System.out.println("innnnnnnnnnn   "+(imageData.getSize()/1024)+"ko");
		
	
	    try {
	    	
	    	incidentImageRepository.save(new IncidentImage(id_incident, imageData.getBytes()));
	    	//PhotoFile doc = new PhotoFile(imageData.getBytes());
	        //photoFileRepository.save(doc);
	        System.out.println(imageData.getInputStream());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	@GetMapping(value="/onGetAllPhotoBy")
	public List<IncidentImage> GetPhotoByIdIncident(){
		System.out.println("getttttttttt aulllllllll phoooootooooooo");
		return incidentImageRepository.findAll();
		
	}
	
	@PostMapping("/ValiderStatut")
	public void ValiderStatut(@RequestParam("Id") String Id,@RequestParam("statut") String statut
			,@RequestParam("motif") String motif) {

		System.out.println("    "+motif+" 1");
		System.out.println("    "+Long.parseLong(Id)+" "+statut+"  "+motif);
		Incident incident=incidentRepository.findById(Long.parseLong(Id)).get();
		System.out.println(incident.toString());
		incident.setMotif_rejet(motif);
		incident.setEtat_validation(statut.toString());
		incidentRepository.save(incident);
	}
}
