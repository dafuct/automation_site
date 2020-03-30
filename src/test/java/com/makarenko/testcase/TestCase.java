package com.makarenko.testcase;

import static org.testng.Assert.assertTrue;

import com.makarenko.config.Currency;
import com.makarenko.pages.SearchPage;
import org.testng.annotations.Test;

public class TestCase extends SearchPage {

  @Test
  public void testAll() {
    changeCurrency(Currency.USD);
    assertTrue(checkCurrency(Currency.USD));

    changeCurrency(Currency.EUR);
    assertTrue(checkCurrency(Currency.EUR));

    changeCurrency(Currency.UAH);
    assertTrue(checkCurrency(Currency.UAH));

    changeCurrency(Currency.USD);
    searchByWord();
    assertTrue(checkCountFoundedProducts());
    assertTrue(checkCurrencyFoundedProducts(Currency.USD));

    setSortingFromHighToLow();
    assertTrue(checkSortingWithoutDiscount());

    assertTrue(checkDiscount());
  }
}
