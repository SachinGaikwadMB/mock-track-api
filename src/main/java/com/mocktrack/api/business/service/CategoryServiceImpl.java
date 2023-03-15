package com.mocktrack.api.business.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mocktrack.api.business.constant.MessageConstant;
import com.mocktrack.api.business.constant.StatusCode;
import com.mocktrack.api.business.exception.CustomException;
import com.mocktrack.api.persistance.entity.Category;
import com.mocktrack.api.persistance.repository.CategoryRepository;
import com.mocktrack.api.web.model.CategoryModel;

@Service
public class CategoryServiceImpl implements CategoryService
{

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addCategory(CategoryModel categoryModel)
	{
		if (categoryRepository.existsByCategoryCode(categoryModel.getCategoryCode()))
		{
			throw new CustomException("Category Already Exists!", StatusCode.CATEGORY_ALREADY_EXIST);
		}

		try
		{
			Category category = modelMapper.map(categoryModel, Category.class);
			categoryRepository.save(category);
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}

		return MessageConstant.SUCCESS;
	}

	@Override
	public Category getCategory(Integer catId)
	{
		Optional<Category> categotyOpt = categoryRepository.findById(catId);

		if (categotyOpt.isEmpty())
		{
			throw new CustomException("No Category Found of ID :: " + catId, StatusCode.CATEGORY_NOT_FOUND);
		}

		return categotyOpt.get();
	}

	@Override
	public List<Category> getAllCategories()
	{
		List<Category> categories = null;

		try
		{
			categories = categoryRepository.findAll();
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}
		return categories;
	}

	@Override
	public String updateCategory(Integer catId, CategoryModel categoryModel)
	{
		Category category = getCategory(catId);

		category.setName(categoryModel.getName());
		category.setDescription(category.getDescription());
		category.setCategoryCode(categoryModel.getCategoryCode());

		try
		{
			categoryRepository.save(category);
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}

		return "Category Updated Successfully";
	}

	@Override
	public String deleteCategory(Integer catId)
	{
		if (!categoryRepository.existsById(catId))
		{
			throw new CustomException("Category Not found with ID :: " + catId, StatusCode.CATEGORY_NOT_FOUND);
		}

		try
		{
			categoryRepository.deleteById(catId);
		}
		catch (Exception e)
		{
			throw new CustomException(e.getMessage(), StatusCode.INTERNAL_SERVER_ERROR);
		}

		return "Category of ID :: " + catId + " is deleted successfully!";
	}

}
