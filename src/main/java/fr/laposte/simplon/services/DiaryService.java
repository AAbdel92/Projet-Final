package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.Diary;
import fr.laposte.simplon.models.Question;
import fr.laposte.simplon.repositories.DiaryRepository;

@Service
@Transactional
public class DiaryService {
	
	@Autowired
	private DiaryRepository repository;
		
	public Diary saveOne(Diary diary) {
		return repository.save(diary);
	}
	
	public List<Diary> getAll(String roleName) {
		Iterable<Diary> request = repository.findAll();
		List<Diary> result;
		if ("Formateur".equals(roleName)) {
			result = filterForFormateur(request);
		} else {
			result = filterForOtherRole(roleName, request);
		} 
		
		return result;
	}
	
	private List<Diary> filterForFormateur(Iterable<Diary> request) {
		List<Diary> result = new ArrayList<>();		
			for (Diary item : request) {
				if (item.getConclusions() == null) {
					result.add(item);
				}
			}		
		return result;
	}
	
	private List<Diary> filterForOtherRole(String roleName, Iterable<Diary> request) {
		List<Diary> result = new ArrayList<>();
		for (Diary item : request) {
			for (Question question : item.getQuestions()) {
				if (roleName.equals(question.getRole().getName()) && question.getAnswer() == null) {
					result.add(item);
					break;
				}
			}
		}
		
		return result;
	}
	
}
