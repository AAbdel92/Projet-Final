package fr.laposte.simplon.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonInclude(Include.NON_NULL)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String password;	
	
	private String email;
		
	@OneToOne
	private User pair;
	
	@ManyToOne
	private Role role;
	
	@ManyToOne
	private Promo promo;
	
//	@OneToMany(mappedBy = "user")
//	private List<Answer> answers; 	

}
