package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<Diary> getForReading(String userRole, int promoId, int pairId) {
		
		Iterable<Diary> request = repository.findByPromoId(promoId);
		List<Diary> result = new ArrayList<>();;
		if ("formateur".equals(userRole)) {
			result = filteringDiariesForFormateur(request);
		} else if ("tuteur".equals(userRole)) {
			result = filteringDiariesForTuteur(request, pairId);
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
	
	private List<Conclusion> filteringConclusionsForTuteur(List<Conclusion> conclusionsList, int pairId) {
		List<Conclusion> result = new ArrayList<>();
		for (Conclusion conclusion : conclusionsList) {
			if (conclusion.getUser().getId() == pairId) {
				Conclusion conclusionDTO = new Conclusion();
				conclusionDTO.setId(conclusion.getId());
				conclusionDTO.setContent(conclusion.getContent());
				result.add(conclusionDTO);
			}				
		}
		return result;
	}
	
	private List<Diary> filteringDiariesForFormateur(Iterable<Diary> request) {
		List<Diary> result = new ArrayList<>();
		for (Diary diary : request) {
			Diary diaryDTO;
			diaryDTO = filteringDiary(diary);
			diaryDTO.setConclusions(filteringConclusionsForFormateur(diary.getConclusions()));
			result.add(diaryDTO);
		}		
		return result;
	}
	
	private List<Diary> filteringDiariesForTuteur(Iterable<Diary> request, int pairId) {
		List<Diary> result = new ArrayList<>();
		for (Diary diary : request) {
			Diary diaryDTO;
			diaryDTO = filteringDiary(diary);
			diaryDTO.setConclusions(filteringConclusionsForTuteur(diary.getConclusions(), pairId));
		}
		return result;
	}
	
	private Diary filteringDiary(Diary diary) {	
		Diary diaryDTO = new Diary();
		if (diary.getConclusions() != null) {			
			diaryDTO.setId(diary.getId());
			diaryDTO.setStartDate(diary.getStartDate());
			diaryDTO.setEndDate(diary.getEndDate());
			diaryDTO.setIntroduction(diary.getIntroduction());
		}
		return diaryDTO;
	}
}
