package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="Incident")
@ToString
public class Incident {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", unique = true, nullable = false)
	
	private Long Id;
	private String Secteur;
	private String Type;
	private String Etat_validation;
	private String Motif_rejet;
	private Double Latitude;
	private Double Longitude;
	private String Province;
	private String Region;
	private String Ville;
	private String Description;
	private String IME_declarant;
	private java.util.Date Date;
	public Incident() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Incident(String secteur, String type, String etat_validation, String motif_rejet, Double latitude,
			Double longitude, String province, String region, String ville, String description, String iME_declarant,
			java.util.Date date) {
		super();
		Secteur = secteur;
		Type = type;
		Etat_validation = etat_validation;
		Motif_rejet = motif_rejet;
		Latitude = latitude;
		Longitude = longitude;
		Province = province;
		Region = region;
		Ville = ville;
		Description = description;
		IME_declarant = iME_declarant;
		Date = date;
	}
	@Override
	public String toString() {
		return "Incident [Id=" + Id + ", Secteur=" + Secteur + ", Type=" + Type + ", Etat_validation=" + Etat_validation
				+ ", Motif_rejet=" + Motif_rejet + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Province="
				+ Province + ", Region=" + Region + ", Ville=" + Ville + ", Description=" + Description
				+ ", IME_declarant=" + IME_declarant + ", Date=" + Date + "]";
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
	public String getEtat_validation() {
		return Etat_validation;
	}
	public void setEtat_validation(String etat_validation) {
		this.Etat_validation = etat_validation;
	}
	public String getMotif_rejet() {
		return Motif_rejet;
	}
	public void setMotif_rejet(String motif_rejet) {
		Motif_rejet = motif_rejet;
	}
	public Double getLatitude() {
		return Latitude;
	}
	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}
	public Double getLongitude() {
		return Longitude;
	}
	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getIME_declarant() {
		return IME_declarant;
	}
	public void setIME_declarant(String iME_declarant) {
		IME_declarant = iME_declarant;
	}
	public java.util.Date getDate() {
		return Date;
	}
	public void setDate(java.util.Date date) {
		Date = date;
	} 
	
	
}
