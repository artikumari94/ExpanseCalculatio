package com.expense.calculation.view;

import java.util.List;
import java.util.Map;

import com.expense.calculation.model.Expense;

public interface CurrentWeekExpenseView {
  void displayCurrentWeeksExpenses(Map<String, List<Expense>> expensesByDate);

  void displayTotalExpenses(Long totalExpense);
}
