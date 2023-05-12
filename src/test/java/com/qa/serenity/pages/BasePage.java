package com.qa.serenity.pages;

import com.qa.serenity.utils.SeleniumUtils;
import com.qa.serenity.utils.Timeouts;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage extends PageObject implements Timeouts {

  public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
  WebDriver driver = getDriver();

  public BasePage(WebDriver driver) {
    super(driver);
  }

  public abstract void verifyPageHeader(String pageHeader);

  /** Open Application. */
  public void openApplication() {
    SeleniumUtils.deleteAllCookies(driver);
    SeleniumUtils.maximizeWindow(driver);
    openAt(SeleniumUtils.getBaseUrl());
  }
}
