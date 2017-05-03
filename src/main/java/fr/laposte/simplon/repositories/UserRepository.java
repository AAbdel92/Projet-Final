package fr.laposte.simplon.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.laposte.simplon.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public Iterable<User> findByRoleName(String roleName);

}
