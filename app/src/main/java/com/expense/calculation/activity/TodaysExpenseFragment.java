package com.expense.calculation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import com.expense.calculation.R;
import com.expense.calculation.adapter.TodaysExpenseListViewAdapter;
import com.expense.calculation.database.ExpenseDatabaseHelper;
import com.expense.calculation.model.Expense;
import com.expense.calculation.presenter.TodaysExpensePresenter;
import com.expense.calculation.view.TodaysExpenseView;

public class TodaysExpenseFragment extends Fragment implements TodaysExpenseView {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.todays_expenses, container, false);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    ExpenseDatabaseHelper expenseDatabaseHelper = new ExpenseDatabaseHelper(this.getActivity());
    TodaysExpensePresenter todaysExpensePresenter = new TodaysExpensePresenter(this, expenseDatabaseHelper);

    todaysExpensePresenter.renderTodaysExpenses();
    todaysExpensePresenter.renderTotalExpense();
    expenseDatabaseHelper.close();
  }

  @Override
  public void displayTotalExpense(Long totalExpense) {
    TextView totalExpenseTextBox = (TextView) getActivity().findViewById(R.id.total_expense);
    totalExpenseTextBox.setText(getActivity().getString(R.string.total_expense) + " " + getActivity().getString(R.string.rupee_sym) + totalExpense.toString());
  }

  @Override
  public void displayTodaysExpenses(List<Expense> expenses) {
    ListView listView = (ListView) getActivity().findViewById(R.id.todays_expenses_list);
    listView.setAdapter(new TodaysExpenseListViewAdapter(expenses, getActivity(), android.R.layout.simple_list_item_1));
  }
}
