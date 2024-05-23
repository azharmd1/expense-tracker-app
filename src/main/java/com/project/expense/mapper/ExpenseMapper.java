package com.project.expense.mapper;

import com.project.expense.dtos.CategoryDto;
import com.project.expense.dtos.ExpenseDto;
import com.project.expense.entities.Category;
import com.project.expense.entities.Expense;

public class ExpenseMapper {

    //map Expense entity to ExpenseDto
    public static ExpenseDto toExpenseDto(Expense expense) {
        return new ExpenseDto(expense.getId(), expense.getAmount(), expense.getExpenseDate(),
                new CategoryDto(expense.getCategory().getId(), expense.getCategory().getName()));
    }
    //map ExpenseDto to Expense entity
    public static Expense toExpense(ExpenseDto expenseDto) {

        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());
        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }
}
