package com.project.expense.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
@Schema(name = "ExpenseDto", description = "Data Transfer Object for Expense to transfer data between client and server")
public record ExpenseDto(Long id,
                         @Schema(description = "Expense amount")
                         double amount,
                            @Schema(description = "Expense creation date")
                         LocalDate expenseDate,
                         @Schema(description = "Associated expense category")
                         CategoryDto categoryDto) {
}
