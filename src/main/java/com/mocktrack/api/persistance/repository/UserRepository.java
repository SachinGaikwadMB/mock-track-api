package com.mocktrack.api.persistance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mocktrack.api.persistance.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	  boolean existsByEmail(String email);
	 
	  Optional<User> findByEmail(String email);
	
}
