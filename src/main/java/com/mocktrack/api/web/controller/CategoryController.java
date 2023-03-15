package com.mocktrack.api.web.controller;

import static com.mocktrack.api.business.constant.GenericConstanst.CATEGORIES;
import static com.mocktrack.api.business.constant.GenericConstanst.CATEGORY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mocktrack.api.business.service.CategoryService;
import com.mocktrack.api.web.model.CategoryModel;
import com.mocktrack.api.web.model.ResponseModel;
import jakarta.validation.Valid;

@RestController
@RequestMapping(CATEGORIES)
public class CategoryController extends BaseController
{
	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<ResponseModel> addCategory(@RequestBody @Valid CategoryModel categoryModel)
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(categoryService.addCategory(categoryModel));
		responseModel.setMessage("Category Added Successfylly !");
		responseModel.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ResponseModel> getAllCategories()
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(categoryService.getAllCategories());
		responseModel.setMessage("Data Fethed Successfully!");
		responseModel.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}

	@GetMapping(CATEGORY)
	public ResponseEntity<ResponseModel> getCategory(@PathVariable(name = "catId") Integer catId)
	{

		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(categoryService.getCategory(catId));
		responseModel.setMessage("Category fetched successfully!");
		responseModel.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}

	@PutMapping(CATEGORY)
	public ResponseEntity<ResponseModel> updateCategory(@PathVariable(name = "catId") Integer catId, @RequestBody  CategoryModel categoryModel)
	{
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(categoryService.updateCategory(catId, categoryModel));
		responseModel.setMessage("Updated");
		responseModel.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(responseModel, HttpStatus.OK);
	}
	
	@DeleteMapping(CATEGORY)
	public ResponseEntity<ResponseModel> deleteCategory(@PathVariable(name = "catId") Integer catId) {
		ResponseModel responseModel = ResponseModel.getInstance();
		responseModel.setData(categoryService.deleteCategory(catId));
		responseModel.setMessage("Deleted");
		responseModel.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(responseModel, HttpStatus.OK);	
	}

}
