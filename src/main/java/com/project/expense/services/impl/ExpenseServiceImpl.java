package com.project.expense.services.impl;

import com.project.expense.dtos.ExpenseDto;
import com.project.expense.entities.Category;
import com.project.expense.entities.Expense;
import com.project.expense.exceptions.ResourceNotFoundException;
import com.project.expense.mapper.ExpenseMapper;
import com.project.expense.repositories.CategoryRepository;
import com.project.expense.repositories.ExpenseRepository;
import com.project.expense.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

@Autowired
private ExpenseRepository expenseRepository;
@Autowired
private CategoryRepository categoryRepository;
    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
         //convert ExpenseDto to Expense entity
        Expense expense = ExpenseMapper.toExpense(expenseDto);
        Expense savedExpense = expenseRepository.save(expense);
        //convert saved Expense entity to ExpenseDto
        return ExpenseMapper.toExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense not found"));

     //convert Expense entity to ExpenseDto
        return ExpenseMapper.toExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map((expense) -> ExpenseMapper.toExpenseDto(expense))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());
        //get the category entity by id
        if(expenseDto.categoryDto() != null) {
           Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(() -> new RuntimeException("Category not found"));
            expense.setCategory(category);
        }
        //save updated Expense entity to database
        Expense updatedExpense = expenseRepository.save(expense);
        //convert updated Expense entity to ExpenseDto
        return ExpenseMapper.toExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
      expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        expenseRepository.deleteById(expenseId);
    }
}
