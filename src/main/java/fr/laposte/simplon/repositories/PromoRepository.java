package fr.laposte.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.laposte.simplon.models.Promo;

@Repository
public interface PromoRepository extends CrudRepository<Promo, Integer> {

}
