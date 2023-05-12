package com.qa.serenity.pages;

import com.qa.serenity.utils.Asserts;
import com.qa.serenity.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  private static final String pageTitleLocator = "//h5[contains(@class, 'orangehrm-login-title')]";

  @FindBy(xpath = pageTitleLocator)
  private WebElement pageTitle;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void verifyPageHeader(String pageHeader) {
    WebElement actualHeader =
        SeleniumUtils.waitForPresenceOfElement(driver, By.xpath(pageTitleLocator));
    Asserts.assertThatEquals(actualHeader.getText().trim(), pageHeader);
  }
}
