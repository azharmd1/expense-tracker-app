package com.project.expense.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private LocalDate expenseDate;

    //many to one relationship with category entity (many expenses can belong to one category)
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) //foreign key column in expenses table
    private Category category;
}
