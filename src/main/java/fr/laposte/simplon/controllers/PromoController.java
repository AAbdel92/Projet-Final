package fr.laposte.simplon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.simplon.models.Promo;
import fr.laposte.simplon.services.PromoService;

@RestController
@RequestMapping("api/promos")
public class PromoController {
	
	@Autowired
	private PromoService service;
	
	//@Admin
	@PostMapping
	public Promo saveOne(@RequestBody Promo promo) {
		return service.saveOne(promo);
	}
	
	//@Admin
	@GetMapping
	public List<Promo> getAll() {
		return service.getAll();
	}
	
	//@Admin
	@PutMapping
	public Promo updateOne(@RequestBody Promo promo) {
		return service.updateOne(promo);
	}

}
