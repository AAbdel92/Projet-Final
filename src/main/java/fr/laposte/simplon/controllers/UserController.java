package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.User;
import fr.laposte.simplon.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//@Admin, @Tuteur, @Formateur, @Apprenant
	@GetMapping("logged")
	public User isLogged() {
		return service.isLogged();
	}
	
	//@Admin
	@GetMapping
	public List<User> getAll(@RequestParam(required = false) String role) {
		if (role != null) {
			return service.getAllByRole(role);
		} else {
			return service.getAll();
		}		
	}
	
	//@Admin
	@PostMapping
	public User saveOne(@RequestBody User user) {
		return service.saveOne(user);
	}	
	 
	 //@Admin
	 @PutMapping("{userId}")
	 public User updateOne(@RequestBody User user) {
		 return service.updateOne(user);
	 }
}
