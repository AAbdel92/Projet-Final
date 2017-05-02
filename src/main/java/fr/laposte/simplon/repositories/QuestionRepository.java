package fr.laposte.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.laposte.simplon.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
