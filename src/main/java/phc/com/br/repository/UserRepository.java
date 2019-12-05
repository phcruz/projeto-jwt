package phc.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phc.com.br.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
