package com.expensesharing.expense_sharing_app.repository;

import com.expensesharing.expense_sharing_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
