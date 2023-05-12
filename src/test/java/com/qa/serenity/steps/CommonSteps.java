package com.qa.serenity.steps;

import com.qa.serenity.pages.DashboardPage;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CommonSteps extends ScenarioSteps {

  private DashboardPage dashboardPage;

  @Step
  @Given("open orange hrm live application")
  public void givenStartAtHomepage() {
    dashboardPage.openApplication();
  }
}
