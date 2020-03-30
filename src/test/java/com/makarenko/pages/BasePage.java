package com.makarenko.pages;


import static com.makarenko.config.Elements.BY_PRICE;
import static com.makarenko.config.Elements.SELECTOR_CURRENCY;
import static com.makarenko.config.Elements.XPATH_EUR;
import static com.makarenko.config.Elements.XPATH_UAH;
import static com.makarenko.config.Elements.XPATH_USD;

import com.makarenko.config.ConfigurationTest;
import com.makarenko.config.Currency;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class BasePage extends ConfigurationTest {

  private static final Logger LOG = LogManager.getLogger(BasePage.class);
  private List<WebElement> prices;

  protected void changeCurrency(Currency currency) {
    waitElementToByClickable(SELECTOR_CURRENCY).click();
    switch (currency) {
      case EUR:
        waitElementToByClickable(XPATH_EUR).click();
        break;
      case UAH:
        waitElementToByClickable(XPATH_UAH).click();
        break;
      case USD:
        waitElementToByClickable(XPATH_USD).click();
        break;
      default:
        throw new IllegalArgumentException("Not correct currency, should be: EUR, UAH, USD");
    }
    LOG.info("Currency successfully change on: " + currency);
  }

  protected boolean checkCurrency(Currency currency) {
    prices = waitElementToByClickable(BY_PRICE).findElements(BY_PRICE);

    LOG.info("Verifying product's price currency type ...");
    switch (currency) {
      case EUR:
        return checkCurrencySymbol("€", " is displayed in EUR currency. Verified.");
      case UAH:
        return checkCurrencySymbol("₴", " is displayed in UAH currency. Verified.");
      case USD:
        return checkCurrencySymbol("$", " is displayed in USD currency. Verified.");
      default:
        throw new IllegalArgumentException(
            "Not correct currency name, should be: EUR, UAH, USD");
    }
  }

  private boolean checkCurrencySymbol(String symbol, String text) {
    for (WebElement price : prices) {
      if (price.getText().contains(symbol)) {
        LOG.info(price.getText() + text);
      } else {
        return false;
      }
    }
    return true;
  }
}
