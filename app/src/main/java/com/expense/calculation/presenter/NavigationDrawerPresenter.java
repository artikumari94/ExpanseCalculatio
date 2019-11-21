package com.expense.calculation.presenter;

import com.expense.calculation.activity.CurrentMonthExpenseFragment;
import com.expense.calculation.activity.CurrentWeekExpenseFragment;
import com.expense.calculation.view.NavigationDrawerItemView;

public class NavigationDrawerPresenter {

  public static final String THIS_WEEK = "This Week";
  public static final String THIS_MONTH = "This Month";
  public static final String HOME = "Home";
  private NavigationDrawerItemView view;

  public NavigationDrawerPresenter(NavigationDrawerItemView view) {
    this.view = view;
  }

  public void onItemSelected(String drawerItem) {
    switch (drawerItem){
      case THIS_WEEK:
        view.render(new CurrentWeekExpenseFragment());
        break;
      case THIS_MONTH:
        view.render(new CurrentMonthExpenseFragment());
        break;
      case HOME:
        view.goToHome();
        break;
    }
  }
}
