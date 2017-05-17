package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.Diary;
import fr.laposte.simplon.models.User;
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
	@GetMapping
	public List<Diary> getAll(@RequestParam boolean consulter,
								@RequestParam String userRole,
								@RequestParam int promoId,
								@RequestParam int studentId){
		List<Diary> result;
		
		if (consulter) {			
			result = service.getForReading(userRole, promoId, studentId);		
			
		} else {
			result = service.getForEditing(userRole, promoId);
		}
		return result;
	}
		
	//@Formateur, @Tuteur, @Apprenant
//	@GetMapping
//	public List<Diary> getAll(@RequestParam String userRole, @RequestParam int userId) {
//		return service.getAll(userRole, userId);
//	}
	

}
