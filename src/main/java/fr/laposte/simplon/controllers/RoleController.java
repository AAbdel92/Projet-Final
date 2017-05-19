package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.Role;
import fr.laposte.simplon.services.RoleService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/roles")
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	//@Admin
	@GetMapping
	public List<Role> getAll() {
		return service.getAll();
	}

}
