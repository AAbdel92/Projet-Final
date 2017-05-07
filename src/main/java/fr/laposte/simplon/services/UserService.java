package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.Role;
import fr.laposte.simplon.models.User;
import fr.laposte.simplon.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getAll() {		
		Iterable<User> request = repository.findAll();			
		List<User> result = filterForList(request);			
		return result;
	}
	
	public List<User> getAllWithRoleName(String roleName) {		
		Iterable<User> request = repository.findByRoleName(roleName);
		List<User> result = filterForListByRole(request);		
		return result;
	}
	
	public User saveOne(User user) {
		return repository.save(user);
	}
	
	public User updatePromoId(User user) {
		User request = repository.findOne(user.getId());
		request.setPromo(user.getPromo());
		return repository.save(request);
		
	}
	
	public User updateOne(User user) {
		return repository.save(user);
		
	}
	
	private List<User> filterForList(Iterable<User> request) {
		
		List<User> result = new ArrayList<>();
		for (User item : request) {
			User user = new User();
			Role role = new Role();
			role.setId(item.getRole().getId());
			role.setName(item.getRole().getName());
			user.setRole(role);
			user.setId(item.getId());
			user.setFirstname(item.getFirstname());
			user.setLastname(item.getLastname());
			user.setPassword(item.getPassword());
			user.setEmail(item.getEmail());
			
			result.add(user);
		}
		
		return result;
	}
	
	private List<User> filterForListByRole(Iterable<User> request) {
		List<User> result = new ArrayList<>();
		for (User item : request) {
			if (item.getPromo() == null) {
				User user = new User();
				Role role = new Role();	
				role.setId(item.getId());
				role.setName(item.getRole().getName());				
				user.setRole(role);
				user.setId(item.getId());
				user.setFirstname(item.getFirstname());
				user.setLastname(item.getLastname());			
				user.setEmail(item.getEmail());
				
				result.add(user);
			}
		}
		
		return result;
	}
}
