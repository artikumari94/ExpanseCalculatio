package com.expense.calculation.presenter;

import com.expense.calculation.database.ExpenseDatabaseHelper;
import com.expense.calculation.model.Expense;
import com.expense.calculation.view.ExpenseView;

import static com.expense.calculation.utils.DateUtil.getCurrentDate;

public class ExpensePresenter {

  private ExpenseDatabaseHelper database;
  private ExpenseView view;

  public ExpensePresenter(ExpenseDatabaseHelper expenseDatabaseHelper, ExpenseView view) {
    this.database = expenseDatabaseHelper;
    this.view = view;
  }

  public boolean addExpense() {
    String amount = view.getAmount();

    if(amount.isEmpty()) {
      view.displayError();
      return false;
    }

    Expense expense = new Expense(Long.valueOf(amount), view.getType(), getCurrentDate());
    database.addExpense(expense);
    return true;
  }

  public void setExpenseTypes() {
    view.renderExpenseTypes(database.getExpenseTypes());
  }
}
