package com.mocktrack.api.persistance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mocktrack.api.persistance.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>
{
	boolean existsByQuizCode(String quizCode);
	
	Optional<Quiz> findByQuizCode(String quizCode);
	
}
