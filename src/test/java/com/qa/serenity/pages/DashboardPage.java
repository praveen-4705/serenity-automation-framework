package com.qa.serenity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.qa.serenity.utils.Asserts.assertThatEquals;
import static com.qa.serenity.utils.SeleniumUtils.waitForPresenceOfElement;

public class DashboardPage extends BasePage {

  public DashboardPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void verifyPageHeader(String pageHeader) {}
}
