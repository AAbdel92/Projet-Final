package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.Question;
import fr.laposte.simplon.repositories.QuestionRepository;

@Service
@Transactional
public class QuestionService {
	
	@Autowired
	private QuestionRepository repository;
	
	public List<Question> saveAll(List<Question> questions) {		
		Iterable<Question> request = repository.save(questions);
		List<Question> result = new ArrayList<>();
		for (Question question : request) {
			Question questionDTO = new Question();
			questionDTO.setId(question.getId());
			questionDTO.setContent(question.getContent());
			result.add(questionDTO);
		}
		return result;
	}

}
