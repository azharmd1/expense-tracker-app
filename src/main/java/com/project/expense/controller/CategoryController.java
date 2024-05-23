package com.project.expense.controller;

import com.project.expense.dtos.CategoryDto;
import com.project.expense.services.CategoryService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "CRUD REST APIs for Category Resource", description = "CRUD REST APIs for Category Resource - " +
        "Create, Read, Update and Delete Category Resource")
@RestController
@RequestMapping("/api/categories") //Define the base URL for all the endpoints in this controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Create a new category",
    description = "Create Category REST API and save it to the database")
    @ApiResponse(responseCode = "201", description = "HTTP status 201 - Created")
    //build createCategory REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
    @Operation(summary = "Get a category",
            description = "Get Category REST API to get category from database")
    @ApiResponse(responseCode = "200", description = "HTTP status 200 - OK")
    //build getCategoryById REST API
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId){
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @Operation(summary = "Get all categories",
            description = "Get All Categories REST API to get all categories from database")
    @ApiResponse(responseCode = "200", description = "HTTP status 200 - OK")
    //build getAllCategories REST API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @Operation(summary = "Update a category",
            description = "Update Category REST API to update category from database")
    @ApiResponse(responseCode = "200", description = "HTTP status 200 - OK")
    //build updateCategory REST API
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId, @RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory = categoryService.updateCategory(categoryId, categoryDto);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
    @Operation(summary = "Delete a category",
            description = "Delete Category REST API to delete category from database")
    @ApiResponse(responseCode = "200", description = "HTTP status 200 - OK")
    //build deleteCategory REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>("Category deleted successfully",HttpStatus.OK);
    }
}
