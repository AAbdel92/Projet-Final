package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.Answer;
import fr.laposte.simplon.models.Conclusion;
import fr.laposte.simplon.models.Diary;
import fr.laposte.simplon.models.Question;
import fr.laposte.simplon.models.User;
import fr.laposte.simplon.repositories.DiaryRepository;

@Service
@Transactional
public class DiaryService {
	
	@Autowired
	private DiaryRepository repository;
		
	public Diary saveOne(Diary diary) {
		return repository.save(diary);
	}
	
	public List<Diary> getForEditing(String userRole, int promoId) {
		Iterable<Diary> request = repository.findByPromoId(promoId);
		List<Diary> result;
		if ("formateur".equals(userRole)) {
			result = filterForFormateur(request);
		} else {
			result = filterForOtherRole(userRole, request);
		} 
		
		return result;
	}
	
	public List<Diary> getForReading(String userRole, int promoId, int studentId) {
		
		Iterable<Diary> request = repository.findByPromoId(promoId);
		List<Diary> result;
		if ("formateur".equals(userRole)) {
			result = filteringDiariesForFormateur(request);
		} else {
			result = filteringDiariesForOther(request, studentId);
		}
		return result;
	}	
	
	private List<Diary> filterForFormateur(Iterable<Diary> request) {
		List<Diary> result = new ArrayList<>();		
			for (Diary item : request) {				
				if (item.getConclusions().isEmpty() && !item.getQuestions().isEmpty()) {					
						
						Diary diaryDTO = new Diary();
						List<Question> questionsDTO = new ArrayList<>();
						for (Question question : item.getQuestions()) {
							if (question.getAnswer() != null) {								
								diaryDTO = filteringDiary(item);	
								Question questionDTO = new Question();
								questionDTO.setId(question.getId());
								questionDTO.setContent(question.getContent());							
								Answer answerDTO = new Answer();
								answerDTO.setId(question.getAnswer().getId());
								answerDTO.setContent(question.getAnswer().getContent());
								User userDTO = new User();
								userDTO.setId(question.getAnswer().getUser().getId());
								userDTO.setFirstname(question.getAnswer().getUser().getFirstname());
								userDTO.setLastname(question.getAnswer().getUser().getLastname());
								answerDTO.setUser(userDTO);
								questionDTO.setAnswer(answerDTO);
								questionsDTO.add(questionDTO);
								if (!questionsDTO.isEmpty()) {
									diaryDTO.setQuestions(questionsDTO);
									}
								
							}							
						}	
						if (diaryDTO.getName() != null) {
							result.add(diaryDTO);
						}
				} else if (item.getQuestions().isEmpty()){
					Diary diaryDTO = filteringDiary(item);
					result.add(diaryDTO);
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
	
	private List<Conclusion> filteringConclusionsForFormateur(List<Conclusion> conclusionsList) {
		List<Conclusion> result = new ArrayList<>();
		for (Conclusion conclusion : conclusionsList) {
			Conclusion conclusionDTO = new Conclusion();
			User userDTO = new User();
			userDTO.setId(conclusion.getUser().getId());
			userDTO.setFirstname(conclusion.getUser().getFirstname());
			userDTO.setLastname(conclusion.getUser().getLastname());
			conclusionDTO.setId(conclusion.getId());
			conclusionDTO.setUser(userDTO);
			conclusionDTO.setContent(conclusion.getContent());
			result.add(conclusionDTO);
		}
		return result;
	}
	
	private List<Conclusion> filteringConclusionsForOther(List<Conclusion> conclusionsList, int studentId) {
		List<Conclusion> result = new ArrayList<>();
		for (Conclusion conclusion : conclusionsList) {
			if (conclusion.getUser().getId() == studentId) {
				Conclusion conclusionDTO = new Conclusion();
				User userDTO = new User();
				userDTO.setId(conclusion.getUser().getId());
				userDTO.setFirstname(conclusion.getUser().getFirstname());
				userDTO.setLastname(conclusion.getUser().getLastname());
				conclusionDTO.setId(conclusion.getId());
				conclusionDTO.setUser(userDTO);
				conclusionDTO.setContent(conclusion.getContent());
				result.add(conclusionDTO);
			}				
		}
		return result;
	}
	
	private List<Diary> filteringDiariesForFormateur(Iterable<Diary> request) {
		List<Diary> result = new ArrayList<>();
		for (Diary diary : request) {
			if (!diary.getConclusions().isEmpty()) {
				Diary diaryDTO;
				diaryDTO = filteringDiary(diary);
				diaryDTO.setConclusions(filteringConclusionsForFormateur(diary.getConclusions()));
				result.add(diaryDTO);
			}
		}		
		return result;
	}
	
	private List<Diary> filteringDiariesForOther(Iterable<Diary> request, int studentId) {
		List<Diary> result = new ArrayList<>();
		for (Diary diary : request) {
			if (!diary.getConclusions().isEmpty()) {
				Diary diaryDTO;
				diaryDTO = filteringDiary(diary);
				diaryDTO.setConclusions(filteringConclusionsForOther(diary.getConclusions(), studentId));
				result.add(diaryDTO);
			}
		}
		return result;
		
	}
	
	private Diary filteringDiary(Diary diary) {	
		Diary diaryDTO = new Diary();					
		diaryDTO.setId(diary.getId());
		diaryDTO.setStartDate(diary.getStartDate());
		diaryDTO.setEndDate(diary.getEndDate());
		diaryDTO.setIntroduction(diary.getIntroduction());
		diaryDTO.setName(diary.getName());
		
		return diaryDTO;
	}
}
