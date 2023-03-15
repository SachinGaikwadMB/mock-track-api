package com.mocktrack.api.business.service;

import java.util.List;
import com.mocktrack.api.persistance.entity.Category;
import com.mocktrack.api.web.model.CategoryModel;

public interface CategoryService
{
	String addCategory(CategoryModel categoryModel);
	
	Category getCategory(Integer catId);
	
	List<Category> getAllCategories();
	
	String updateCategory(Integer catId, CategoryModel categoryModel);
	
	String deleteCategory(Integer catId);
}
