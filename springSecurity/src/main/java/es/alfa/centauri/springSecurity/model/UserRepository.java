package es.alfa.centauri.springSecurity.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	public User findByName(String name);

	public void deleteByName(String name);
}
