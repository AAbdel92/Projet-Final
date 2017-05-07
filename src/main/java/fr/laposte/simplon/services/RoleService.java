package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.Role;
import fr.laposte.simplon.repositories.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public List<Role> getAll() {
		Iterable<Role> request = repository.findAll();
		List<Role> result = new ArrayList<>();
		for (Role role : request) {
			result.add(role);
		}
		return result;
	}

}
