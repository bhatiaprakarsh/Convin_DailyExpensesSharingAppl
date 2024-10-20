package com.expensesharing.expense_sharing_app.service;

import com.expensesharing.expense_sharing_app.entity.Expense;
import com.expensesharing.expense_sharing_app.repository.ExpenseRepository;
import com.expensesharing.expense_sharing_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository; // light coupling ke liye h dependies injection

    // Method to add an expense
    public Expense addExpense(Expense expense) {
        if ("Percentage".equals(expense.getSplitMethod())) {
            validatePercentageSplit(expense);
        }
        //  expenses save krne ke liye
        return expenseRepository.save(expense);
    }


    public List<Expense> getExpensesForUser(Long userId) {
        return expenseRepository.findAll().stream()
                .filter(exp -> exp.getParticipants().stream()
                        .anyMatch(user -> user.getId().equals(userId)))
                .collect(Collectors.toList());
    }

    private void validatePercentageSplit(Expense expense) {
        double totalPercentage = expense.getAmountSplit().values().stream()
                .mapToDouble(Double::doubleValue).sum();
        if (totalPercentage != 100) {
            throw new IllegalArgumentException("Percentage split must add up to 100%");
        }
    }
}

