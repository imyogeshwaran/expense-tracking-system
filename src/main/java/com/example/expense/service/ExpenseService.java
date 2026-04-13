package com.example.expense.service;

import com.example.expense.model.Expense;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        if (expense.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        expenses.add(expense);
    }

    public double getTotalExpense() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }
}