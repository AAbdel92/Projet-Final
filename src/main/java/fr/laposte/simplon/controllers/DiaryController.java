package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.Diary;
import fr.laposte.simplon.services.DiaryService;

@RestController
@RequestMapping("api/diaries")
public class DiaryController {
	
	@Autowired
	private DiaryService service;
	
	//@Formateur
	@PostMapping
	public Diary saveOne(@RequestBody Diary diary) {
		return service.saveOne(diary);
	}
	//@Formateur, @Tuteur, @Apprenant
	@GetMapping("role/{roleName}/promo/{promoId}")
	public List<Diary> getAllByRole(@PathVariable String roleName, @PathVariable int promoId) {
		return service.getAllByRole(roleName, promoId);
	}
	
	//@Formateur, @Tuteur, @Apprenant
	@GetMapping
	public List<Diary> getAllByUser() {
		return service.getAllByUser();
	}
	

}
