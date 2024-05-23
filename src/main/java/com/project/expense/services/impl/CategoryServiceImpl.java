package com.project.expense.services.impl;

import com.project.expense.dtos.CategoryDto;
import com.project.expense.entities.Category;
import com.project.expense.exceptions.ResourceNotFoundException;
import com.project.expense.mapper.CategoryMapper;
import com.project.expense.repositories.CategoryRepository;
import com.project.expense.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
      private CategoryRepository categoryRepository;

        @Override
        public CategoryDto createCategory(CategoryDto categoryDto) {
            //convert CategoryDto to Category entity
            Category category = CategoryMapper.toCategory(categoryDto);

            //save category entity to database
          Category savedCategory =  categoryRepository.save(category);

            //convert Category entity to CategoryDto
            return CategoryMapper.toCategoryDto(savedCategory);
        }
        public CategoryDto getCategoryById(Long categoryId) {
            //get category entity from database
            Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

            //convert Category entity to CategoryDto
            return CategoryMapper.toCategoryDto(category);
        }

    @Override
    public List<CategoryDto> getAllCategories() {
        //get all categories from database
        List<Category> categories = categoryRepository.findAll();

        //convert Category entities to CategoryDtos
      return categories.stream()
              .map((category) -> CategoryMapper.toCategoryDto(category))
               .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        //get category entity from database
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        //update category entity with new data
        category.setName(categoryDto.name());

        //save updated category entity to database
        Category updatedCategory = categoryRepository.save(category); //perform update if it already exists else create a new one

        //convert Category entity to CategoryDto
        return CategoryMapper.toCategoryDto(updatedCategory);
    }
    public void deleteCategory(Long categoryId) {
        //delete category from database
        //check if category exists
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        categoryRepository.deleteById(categoryId);
    }
}
