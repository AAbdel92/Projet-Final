package fr.laposte.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.laposte.simplon.models.Diary;

@Repository
public interface DiaryRepository extends CrudRepository<Diary, Integer> {

}
