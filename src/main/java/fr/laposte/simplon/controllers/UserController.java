package fr.laposte.simplon.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	//@Admin, @Tuteur, @Formateur, @Apprenant
	@PostMapping("logged")
	public User isLogged(@RequestBody User user) {
		return service.isLogged(user);
	}
	
	//@Admin
	@GetMapping
	public List<User> getAll(@RequestParam Optional<String> role,
								@RequestParam Optional<Integer> promoId,
								@RequestParam Optional<Integer> diaryId) {
		List<User> result;
		if (role.isPresent()) {
			result = service.getAllByRole(role.get());
		} else if (promoId.isPresent() && diaryId.isPresent()){
			result = service.getAllByPromoAndDiary(promoId.get(), diaryId.get());
		} else {
			result = service.getAll();
		}
		return result;
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
