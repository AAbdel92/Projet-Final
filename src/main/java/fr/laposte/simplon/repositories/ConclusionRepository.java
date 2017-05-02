package fr.laposte.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.laposte.simplon.models.Conclusion;

@Repository
public interface ConclusionRepository extends CrudRepository<Conclusion, Integer> {

}
