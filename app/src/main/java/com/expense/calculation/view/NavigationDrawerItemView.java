package com.expense.calculation.view;


import android.support.v4.app.Fragment;

public interface NavigationDrawerItemView {
  void render(Fragment fragment);

  void goToHome();
}
