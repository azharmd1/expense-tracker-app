package com.project.expense.mapper;

import com.project.expense.dtos.CategoryDto;
import com.project.expense.entities.Category;

public class CategoryMapper {

    //map Category entity to CategoryDto
    public static CategoryDto toCategoryDto(Category category) {
       return new CategoryDto(category.getId(), category.getName());
    }
    //map CategoryDto to Category entity
    public static Category toCategory(CategoryDto categoryDto) {
        return new Category(categoryDto.id(), categoryDto.name());
    }
}
