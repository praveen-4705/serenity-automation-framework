package com.qa.serenity.steps;

import com.qa.serenity.pages.LoginPage;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

  private LoginPage loginPage;

  @Step
  @Then("user should see {} page")
  public void givenStartAtHomepage(String pageHeader) {
    loginPage.verifyPageHeader(pageHeader);
  }
}
