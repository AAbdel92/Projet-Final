package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.laposte.simplon.models.Answer;
import fr.laposte.simplon.repositories.AnswerRepository;

@Service
@Transactional
public class AnswerService {
	
	@Autowired
	private AnswerRepository repository;
	
	public List<Answer> getByDiaryAndStudent(int diaryId, int studentId) {
		Iterable<Answer> request = repository.findByUserId(studentId);
		List<Answer> result = filteringRequest(request, diaryId);
		if (result.size() == 10) {
			return result;
		} else {
			return null;
		}		
	}
	
	private List<Answer> filteringRequest(Iterable<Answer> answers, int diaryId) {
		List<Answer> result = new ArrayList<>();
		for (Answer answer : answers) {
			if (answer.getQuestion().getDiary().getId() == diaryId) {
				Answer answerDTO = new Answer();
				answerDTO.setId(answer.getId());
				answerDTO.setContent(answer.getContent());
				result.add(answerDTO);
			}
		}
		return result;
	}

}
