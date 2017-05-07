package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.Question;
import fr.laposte.simplon.services.QuestionService;

@RestController
@RequestMapping("api/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService service;
	
	//@Formateur
	@PostMapping
	public List<Question> saveAll(@RequestBody List<Question> questions) {
		return service.saveAll(questions);
	}

}
