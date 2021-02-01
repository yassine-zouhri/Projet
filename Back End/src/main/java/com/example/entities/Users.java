package com.example.entities;
import javax.persistence.*;

import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@ToString
public class Users implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String N_telephone;
    private String Username;
	   
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(
	                    name = "user_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(
	                    name = "role_id", referencedColumnName = "id"))
	    
	
	    
	    
	    private Collection<Roles> roles;
    private SpecialisationUser Specialisation;

    public Users() {
    }

    public Users(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    
    public Users(String firstName, String lastName, String email, String password, String n_telephone, String username,
			Collection<Roles> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		N_telephone = n_telephone;
		Username = username;
		this.roles = roles;
	}

	public Users(String firstName, String lastName, String email, String password, String n_telephone, String username,
			Collection<Roles> roles, SpecialisationUser specialisation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		N_telephone = n_telephone;
		Username = username;
		this.roles = roles;
		Specialisation = specialisation;
	}

	public Users(String firstName, String lastName, String email, String password, Collection<Roles> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getN_telephone() {
		return N_telephone;
	}

	public void setN_telephone(String n_telephone) {
		N_telephone = n_telephone;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

	public SpecialisationUser getSpecialisation() {
		return Specialisation;
	}

	public void setSpecialisation(SpecialisationUser specialisation) {
		Specialisation = specialisation;
	}

			

    
}
