package com.makarenko.config;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  private EventFiringWebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = getEventDriver();
    driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
  }

  @AfterClass
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  private WebDriver getDriver() {
    System.setProperty("webdriver.gecko.driver",
        new File(getClass().getResource("/geckodriver.exe").getFile()).getPath());
    return new FirefoxDriver();
  }

  private EventFiringWebDriver getEventDriver() {
    WebDriver driver = getDriver();
    driver.manage().window().maximize();
    EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
    eventDriver.register(new EventListener());
    eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return eventDriver;
  }
}
