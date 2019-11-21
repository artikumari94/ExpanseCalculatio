package com.expense.calculation.view;

import java.util.List;

public interface ExpenseView {
  String getAmount();
  String getType();
  void renderExpenseTypes(List<String> expenseTypes);
  void displayError();
}
