package es.alfa.centauri.springSecurity.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

	public void deleteByUserName(String name);

//	public User insert(User user);
	
	 User findByEmail(String email);
	 
	 public User findByUserName(String username);

}
