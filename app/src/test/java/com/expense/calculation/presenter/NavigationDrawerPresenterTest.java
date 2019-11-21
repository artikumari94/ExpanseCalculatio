package com.expense.calculation.presenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.expense.calculation.activity.CurrentMonthExpenseFragment;
import com.expense.calculation.activity.CurrentWeekExpenseFragment;
import com.expense.calculation.view.NavigationDrawerItemView;

import static com.expense.calculation.presenter.NavigationDrawerPresenter.HOME;
import static com.expense.calculation.presenter.NavigationDrawerPresenter.THIS_MONTH;
import static com.expense.calculation.presenter.NavigationDrawerPresenter.THIS_WEEK;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NavigationDrawerPresenterTest {

  private NavigationDrawerItemView view;
  private NavigationDrawerPresenter presenter;

  @Before
  public void setUp() throws Exception {
    view = mock(NavigationDrawerItemView.class);
    presenter = new NavigationDrawerPresenter(view);
  }

  @Test
  public void shouldRenderCurrentWeeksFragment() throws Exception {
    presenter.onItemSelected(THIS_WEEK);
    ArgumentCaptor<CurrentWeekExpenseFragment> fragmentCaptor = ArgumentCaptor.forClass(CurrentWeekExpenseFragment.class);
    verify(view).render(fragmentCaptor.capture());

    CurrentWeekExpenseFragment fragment = fragmentCaptor.getValue();
    assertTrue(fragment.getClass().equals(CurrentWeekExpenseFragment.class));
  }

  @Test
  public void shouldRenderCurrentMonthsFragment() throws Exception {
    presenter.onItemSelected(THIS_MONTH);
    ArgumentCaptor<CurrentMonthExpenseFragment> fragmentCaptor = ArgumentCaptor.forClass(CurrentMonthExpenseFragment.class);
    verify(view).render(fragmentCaptor.capture());

    CurrentMonthExpenseFragment fragment = fragmentCaptor.getValue();
    assertTrue(fragment.getClass().equals(CurrentMonthExpenseFragment.class));
  }

  @Test
  public void shouldRenderHomeFragment() throws Exception {
    presenter.onItemSelected(HOME);
    verify(view).goToHome();
  }
}