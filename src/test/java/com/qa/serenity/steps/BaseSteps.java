package com.qa.serenity.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class BaseSteps extends ScenarioSteps {

  @Before
  public void beforeMethod(Scenario scenario) {
    EnvironmentVariables environmentVariables =
        SystemEnvironmentVariables.createEnvironmentVariables();
    Serenity.setSessionVariable("scenarioName").to(scenario.getName());
  }

  @After
  public void afterMethod(Scenario scenario) throws Exception {
  }
}
