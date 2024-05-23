package com.project.expense.controller;

import com.project.expense.dtos.ExpenseDto;
import com.project.expense.services.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "CRUD REST APIs for Expense Resource", description = "CRUD REST APIs for Expense Resource - " +
        "Create, Read, Update and Delete Expense Resource")

@RestController
@RequestMapping("/api/expenses") //base path
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @Operation(summary = "Create a new expense",
            description = "Create Expense REST API and save it to the database")
    @ApiResponse(responseCode = "201", description = "HTTP status 201 - Created")
    //build createExpense REST API
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }
    @Operation(summary = "Get an expense",
            description = "Get Expense REST API to get expense from database")
    @ApiResponse(responseCode = "200", description = "HTTP status 200 - OK")
    //build getExpenseById REST API
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId) {
        ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);
        return new ResponseEntity<>(expenseDto, HttpStatus.OK);
    }
    @Operation(summary = "Get all expenses",
            description = "Get All Expenses REST API to get all expenses from database")
    @ApiResponse(responseCode = "200", description = "HTTP status 200 - OK")
    //build getAllExpenses REST API
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
    @Operation(summary = "Update an expense",
            description = "Update Expense REST API to update expense from database")
    @ApiResponse(responseCode = "200", description = "HTTP status 200 - OK")
    //build updateExpense REST API
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto updatedExpense = expenseService.updateExpense(expenseId, expenseDto);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }
    @Operation(summary = "Delete an expense",
            description = "Delete Expense REST API to delete expense from database")
    @ApiResponse(responseCode = "200", description = "HTTP status 200 - OK")
    //build deleteExpense REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId) {
        expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>("Expense deleted successfully",HttpStatus.OK);
    }

}
