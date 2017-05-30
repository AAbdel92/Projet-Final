package fr.laposte.simplon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.Conclusion;
import fr.laposte.simplon.repositories.ConclusionRepository;

@Service
@Transactional
public class ConclusionService {
	
	@Autowired
	private ConclusionRepository repository;
	
	public Conclusion saveOne(Conclusion conclusion) {
		return repository.save(conclusion);
	}
}
