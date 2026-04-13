package com.example.expense;

import com.example.expense.model.Expense;
import com.example.expense.service.ExpenseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseServiceTest {

    @Test
    void testTotalExpense() {
        ExpenseService service = new ExpenseService();
        service.addExpense(new Expense("Food", 100));
        service.addExpense(new Expense("Travel", 200));

        assertEquals(300, service.getTotalExpense());
    }

    @Test
    void testInvalidExpense() {
        ExpenseService service = new ExpenseService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.addExpense(new Expense("Invalid", -10));
        });
    }
}