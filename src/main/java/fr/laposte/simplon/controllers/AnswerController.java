package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.Answer;
import fr.laposte.simplon.services.AnswerService;

@RestController
@RequestMapping("api/answers")
public class AnswerController {
	
	@Autowired
	AnswerService service;
	
	@GetMapping
	public List<Answer> getByDiaryAndStudent(@RequestParam int diaryId,
											@RequestParam int studentId) {
		return service.getByDiaryAndStudent(diaryId, studentId);
	}

}
