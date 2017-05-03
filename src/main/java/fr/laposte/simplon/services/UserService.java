package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.User;
import fr.laposte.simplon.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getAll() {		
		Iterable<User> request = repository.findAll();			
		List<User> result = filterRequest(request);			
		return result;
	}
	
	public List<User> getAllWithRoleName(String roleName) {		
		Iterable<User> request = repository.findByRoleName(roleName);
		List<User> result = filterRequest(request);		
		return result;
	}
	
	private List<User> filterRequest(Iterable<User> request) {
		List<User> result = new ArrayList<>();
		for (User item : request) {
			User user = new User();
			user.setId(item.getId());
			user.setFirstname(item.getFirstname());
			user.setLastname(item.getLastname());
			user.setEmail(item.getEmail());
			result.add(user);
		}
		
		return result;
	}

}
