package com.mocktrack.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mocktrack.api.persistance.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>
{  

}
