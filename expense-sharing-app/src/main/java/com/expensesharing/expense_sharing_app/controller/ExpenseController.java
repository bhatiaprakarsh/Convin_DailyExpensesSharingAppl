package com.expensesharing.expense_sharing_app.controller;

import com.expensesharing.expense_sharing_app.entity.Expense;
import com.expensesharing.expense_sharing_app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses") // saare users ko map krne ke liye
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService; // light coupling ke liye h dependies injection

    // endpoints serves as a request feature for every request that wee fire
    // jo maango go vahi milega
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense createdExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(createdExpense, HttpStatus.CREATED); // Return 201 Created status dega
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getUserExpenses(@PathVariable Long userId) {
        List<Expense> userExpenses = expenseService.getExpensesForUser(userId);
        return ResponseEntity.ok(userExpenses); // Return 200 OK status with a list of expenses
    }
}

