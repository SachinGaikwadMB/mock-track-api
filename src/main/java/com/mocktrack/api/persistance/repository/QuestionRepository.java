package com.mocktrack.api.persistance.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mocktrack.api.persistance.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>
{  
	//write a query to check question is already exist in same Quiz
	@Query(value ="SELECT q FROM Question AS q WHERE q.quesId =:quesId AND q.quiz.quizId =:quizId")
	List<Question> checkQuestionAlreadyAddedToQuiz(@Param("quesId")Integer quesId,  @Param("quizId") Integer quizId);
	
	Optional<Question> findByQuesId(Integer quesId);
	
	boolean existsByQuesId(Integer quesId);
	
	@Query(value ="SELECT q FROM Question AS q WHERE q.quiz.quizId =:quizId")
	List<Question>  getAllQuestionByQuizId(@Param("quizId")Integer quizId);
}
