package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.Conclusion;
import fr.laposte.simplon.models.Promo;
import fr.laposte.simplon.models.Role;
import fr.laposte.simplon.models.User;
import fr.laposte.simplon.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User isLogged() {
		return null;
	}
	
	public User onLogin(User user) {
		User request = repository.findByEmail(user.getEmail());		
		if (request.getPassword().equals(user.getPassword())) {			
			user.setId(request.getId());
			user.setFirstname(request.getFirstname());
			user.setLastname(request.getLastname());
			User pair = new User();
			pair.setId(request.getPair().getId());
			user.setPair(pair);
			Promo promo = new Promo();
			promo.setId(request.getPromo().getId());
			user.setPromo(promo);
			Role role = new Role();
			role.setId(request.getRole().getId());
			user.setRole(role);			
		}
		return user;
	}
	
	public List<User> getAll() {		
		Iterable<User> request = repository.findAll();			
		List<User> result = filterForList(request);			
		return result;
	}
	
	public List<User> getAllByRole(String roleName) {		
		Iterable<User> request = repository.findByRoleName(roleName);
		List<User> result = filterForListByRole(request);		
		return result;
	}
	
	public List<User> getAllByPromoAndDiary(int promoId, int diaryId) {
		List<User> result = new ArrayList<>();
		Iterable<User> request = repository.findByPromoId(promoId);
		boolean filled;
		for (User user : request) {
			if (!user.getConclusions().isEmpty()) {
				filled = checkingConclusions(user.getConclusions(), diaryId);
				if (!filled) {
					User userDTO = filteringUser(user);
					result.add(userDTO);
				} else {
					continue;
				}
			}
		}
		return result;
	}
	
	public User saveOne(User user) {
		return repository.save(user);
	}
	
	public User updateOne(User user) {
		User request = repository.findOne(user.getId());
		request.setPassword(user.getPassword());
		request.setFirstname(user.getFirstname());
		request.setLastname(user.getLastname());
		if (user.getPair() != null) {
			request.setPair(user.getPair());
		}
		if (user.getPromo() != null) {
			request.setPromo(user.getPromo());
		}
		request.setRole(user.getRole());		
		repository.save(request);
		User result = new User();
		Role role = new Role();		
		role.setId(request.getRole().getId());
		role.setName(request.getRole().getName());
		Promo promo = new Promo();
		promo.setId(request.getPromo().getId());
		promo.setName(request.getPromo().getName());
		result.setPromo(promo);
		result.setRole(role);
		result.setId(request.getId());
		result.setFirstname(request.getFirstname());
		result.setLastname(request.getLastname());
		result.setPassword(request.getPassword());
		result.setEmail(request.getEmail());		
		
		return result;
		
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
		return result;
	}
	
	private User filteringUser(User user) {
		User userDTO = new User();
		userDTO.setId(user.getId());
		userDTO.setFirstname(user.getFirstname());
		userDTO.setLastname(user.getLastname());
		return userDTO;
	}
	
	private boolean checkingConclusions(List<Conclusion> conclusions, int diaryId) {
		boolean result = false;
		for (Conclusion conclusion : conclusions) {
			if (conclusion.getDiary().getId() == diaryId) {
				result = true;
				break;
			}
		}
		return result;
	}
}
