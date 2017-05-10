package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.User;
import fr.laposte.simplon.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//@Admin, @Tuteur, @Formateur, @Apprenant
	@GetMapping("login")
	public User onLogin(@RequestBody User user) {
		return service.onLogin(user);
	}
	
	//@Admin
	@GetMapping
	public List<User> getAll() {
		return service.getAll();
	}
	
	//@Admin
	@GetMapping("{roleName}")
	public List<User> getAllWithRoleName(@PathVariable String roleName) {
		return service.getAllWithRoleName(roleName);
	}
	
	//@Admin
	@PostMapping
	public User saveOne(@RequestBody User user) {
		return service.saveOne(user);
	}
	
	//Inutile ?
	//@Admin
	 @PutMapping("osef")
	 public User updatePromoId(@RequestBody User user) {
		 return service.updatePromoId(user);
	 }
	 
	 //@Admin
	 @PutMapping
	 public User updateOne(@RequestBody User user) {
		 return service.updateOne(user);
	 }

}
