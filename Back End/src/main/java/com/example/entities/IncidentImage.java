package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name="IncidentImage")
@ToString
public class IncidentImage {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", unique = true, nullable = false)
	
	private Long Id;
	private Long Id_Incident;
	
	@Lob
	private byte[] data;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getId_Incident() {
		return Id_Incident;
	}

	public void setId_Incident(Long id_Incident) {
		Id_Incident = id_Incident;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public IncidentImage(Long id_Incident, byte[] data) {
		super();
		Id_Incident = id_Incident;
		this.data = data;
	}

	public IncidentImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
