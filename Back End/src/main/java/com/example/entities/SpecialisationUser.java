package com.example.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="SpecialisationUser")
@ToString
public class SpecialisationUser implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	
	private Long Id;
	private String Secteur;
	private String Type;
	public SpecialisationUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpecialisationUser(String secteur, String type) {
		super();
		Secteur = secteur;
		Type = type;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getSecteur() {
		return Secteur;
	}
	public void setSecteur(String secteur) {
		Secteur = secteur;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
}
