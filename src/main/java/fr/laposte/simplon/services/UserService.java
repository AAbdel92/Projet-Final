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
		List<User> result = new ArrayList<>();
		Iterable<User> request = repository.findAll();		
		
		for (User item : request) {
			User user = new User();
			user.setFirstname(item.getFirstname());
			user.setLastname(item.getLastname());
			user.setEmail(item.getEmail());
			result.add(user);
		}
		
		return result;
	}

}
