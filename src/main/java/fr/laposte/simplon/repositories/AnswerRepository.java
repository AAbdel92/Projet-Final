package fr.laposte.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.laposte.simplon.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {

}
