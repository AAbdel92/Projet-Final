package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.User;
import fr.laposte.simplon.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{roleName}")
	public List<User> getAllWithRoleName(@PathVariable String roleName) {
		return service.getAllWithRoleName(roleName);
	}

}
