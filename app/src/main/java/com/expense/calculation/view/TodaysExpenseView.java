package com.expense.calculation.view;

import java.util.List;

import com.expense.calculation.model.Expense;

public interface TodaysExpenseView {
  void displayTotalExpense(Long totalExpense);
  void displayTodaysExpenses(List<Expense> expenses);
}
