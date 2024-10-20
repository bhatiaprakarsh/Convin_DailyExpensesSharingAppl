package com.expensesharing.expense_sharing_app.test;

import com.expensesharing.expense_sharing_app.entity.Expense;
import com.expensesharing.expense_sharing_app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertThrows;

@SpringBootTest
public final class ExpenseServiceTest {
    @Autowired
    private ExpenseService expenseService;

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

