package fr.laposte.simplon.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	@Column(name = "persomail")
	private String email;
	
	@OneToOne
	private User pair;
	
	@ManyToOne
	private Role role;
	
	@ManyToOne
	private Promo promo;
	
	@OneToMany(mappedBy = "user")
	private List<Answer> answers; 	

}