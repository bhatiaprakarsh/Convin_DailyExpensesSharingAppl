package com.expensesharing.expense_sharing_app.test;

import com.expensesharing.expense_sharing_app.entity.Expense;
import com.expensesharing.expense_sharing_app.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class ExpenseServiceTest {
    @Autowired
    private ExpenseService expenseService;


    @org.junit.Test
    @Test
    public void testPercentageSplitValidation() {
        Expense expense = new Expense();
        expense.setSplitMethod("Percentage");
        Map<Long, Double> amountSplit = new HashMap<>();
        amountSplit.put(1L, 40.0);
        amountSplit.put(2L, 70.0); // Error case: Sum exceeds 100%
        expense.setAmountSplit(amountSplit);

        assertThrows(IllegalArgumentException.class, () -> expenseService.addExpense(expense));
    }
}
