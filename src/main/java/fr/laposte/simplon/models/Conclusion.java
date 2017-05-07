package fr.laposte.simplon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Conclusion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String content;
	
	@JsonIgnore
	@ManyToOne
	private Diary diary;
	
	@JsonIgnore
	@ManyToOne
	private User user;

}
