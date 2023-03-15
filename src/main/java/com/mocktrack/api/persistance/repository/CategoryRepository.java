package com.mocktrack.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mocktrack.api.persistance.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{
	Category findByCategoryCode(String categoryCode);
	
	boolean existsByCategoryCode(String categoryCode);
}
