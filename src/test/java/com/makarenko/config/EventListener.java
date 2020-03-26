package com.makarenko.config;

import java.util.Arrays;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventListener extends AbstractWebDriverEventListener {

  private static final Logger LOG = LogManager.getLogger(EventListener.class);

  @Override
  public void beforeAlertAccept(WebDriver driver) {
    LOG.info("Trying to receive an alert");
  }

  @Override
  public void afterAlertAccept(WebDriver driver) {
    LOG.info("Alert accepted");
  }

  @Override
  public void afterAlertDismiss(WebDriver driver) {
    LOG.info("Alert canceled");
  }

  @Override
  public void beforeAlertDismiss(WebDriver driver) {
    LOG.info("Trying to cancel alert");
  }

  @Override
  public void beforeNavigateTo(String url, WebDriver driver) {
    LOG.info("Before navigating to: '" + url + "'");
  }

  @Override
  public void afterNavigateTo(String url, WebDriver driver) {
    LOG.info("Navigated to: '" + url + "'");
  }

  @Override
  public void beforeNavigateBack(WebDriver driver) {
    LOG.info("Before navigating back to previous page");
  }

  @Override
  public void afterNavigateBack(WebDriver driver) {
    LOG.info("After navigating back to previous page");
  }

  @Override
  public void beforeNavigateForward(WebDriver driver) {
    LOG.info("Before navigating forward to next page");
  }

  @Override
  public void afterNavigateForward(WebDriver driver) {
    LOG.info("After navigating forward to next page");
  }

  @Override
  public void beforeNavigateRefresh(WebDriver driver) {
    LOG.info("Before refresh the current page");
  }

  @Override
  public void afterNavigateRefresh(WebDriver driver) {
    LOG.info("After refresh the current page");
  }

  @Override
  public void beforeFindBy(By by, WebElement element, WebDriver driver) {
    LOG.info("Before to find: " + getElement(element) + " by: " + by.toString());
  }

  @Override
  public void afterFindBy(By by, WebElement element, WebDriver driver) {
    LOG.info("Found Element By : " + by.toString());
  }

  @Override
  public void beforeClickOn(WebElement element, WebDriver driver) {
    LOG.info("Before to click on " + getElement(element));
  }

  @Override
  public void afterClickOn(WebElement element, WebDriver driver) {
    LOG.info("After to click on " + getElement(element));
  }

  @Override
  public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    LOG.info("Before to change value of " + getElement(element) + " on "
        + Arrays.toString(keysToSend));
  }

  @Override
  public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    LOG.info("After to change value of " + getElement(element) + " on "
        + Arrays.toString(keysToSend));
  }

  @Override
  public void beforeScript(String script, WebDriver driver) {
    LOG.info("Before to execute script " + script);
  }

  @Override
  public void afterScript(String script, WebDriver driver) {
    LOG.info("After to execute script " + script);
  }

  @Override
  public void onException(Throwable throwable, WebDriver driver) {
    LOG.info("An exception " + throwable + " was thrown");
  }

  private String getElement(WebElement element) {
    if (element.getText() != null) {
      return element.getText();
    } else if (element.getTagName() != null) {
      return element.getTagName();
    }
    return null;
  }
}
