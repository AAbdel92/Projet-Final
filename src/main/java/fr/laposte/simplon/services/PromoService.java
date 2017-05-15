package fr.laposte.simplon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.laposte.simplon.models.Promo;
import fr.laposte.simplon.repositories.PromoRepository;

@Service
@Transactional
public class PromoService {
	
	@Autowired
	private PromoRepository repository;
	
	public Promo saveOne(Promo promo) {
		return repository.save(promo);
	}
	
	public List<Promo> getAll() {
		Iterable<Promo> request = repository.findAll();
		List<Promo> result = filterForList(request);
		return result;
	}
	
	public Promo updateOne(Promo promo) {
		Promo request = repository.findOne(promo.getId());
		request.setName(promo.getName());
		request.setStartDate(promo.getStartDate());
		request.setEndDate(promo.getEndDate());
		repository.save(request);
		return promo;
	}
	
	private List<Promo> filterForList(Iterable<Promo> request) {
		List<Promo> result = new ArrayList<>();
		for (Promo item : request) {
			Promo promo = new Promo();
			promo.setId(item.getId());
			promo.setName(item.getName());
			promo.setStartDate(item.getStartDate());
			promo.setEndDate(item.getEndDate());
			
			result.add(promo);
		}
		return result;
	}

}
