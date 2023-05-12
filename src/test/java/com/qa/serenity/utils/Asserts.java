package com.qa.serenity.utils;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

public class Asserts {

  public static void assertThatEquals(String actual, String Expected) {
    Assertions.assertThat(actual).isEqualTo(Expected);
  }

  public static void softAssertThatEquals(
      SoftAssertions softAssertions, String actual, String expected) {
    softAssertions.assertThat(actual).isEqualTo(expected);
  }

  public static void assertThatEquals(int actual, int Expected) {
    Assertions.assertThat(actual).isEqualTo(Expected);
  }

  public static void assertListShouldContains(List<String> actual, String Expected) {
    Assertions.assertThat(actual).contains(Expected);
  }

  public static void assertThatListEquals(List<String> actual, List<String> Expected) {
    Assertions.assertThat(actual).isEqualTo(Expected);
  }

  public static void assertThatEqualIgnoreCase(String actual, String Expected) {
    Assertions.assertThat(actual).isEqualToIgnoringCase(Expected);
  }

  public static void assertThatEqualsWithMessage(String actual, String Expected, String message) {
    Assertions.assertThat(actual).withFailMessage(message).isEqualTo(Expected);
  }

  public static void assertThatContains(String actual, String expected) {
    Assertions.assertThat(actual).contains(expected);
  }

  public static void assertThatNotContains(String actual, String expected) {
    Assertions.assertThat(actual).doesNotContain(expected);
  }

  public static void assertThatContainsIgnoreCase(String actual, String expected) {
    Assertions.assertThat(actual).containsIgnoringCase(expected);
  }

  public static void assertThatGreaterThan(int value1, int value2) {
    Assertions.assertThat(value1).isGreaterThan(value2);
  }

  public static void assertThatGreaterThanOrEqualsTo(int value1, int value2) {
    Assertions.assertThat(value1).isGreaterThanOrEqualTo(value2);
  }

  public static void assertThatLessThan(int value1, int value2) {
    Assertions.assertThat(value1).isLessThan(value2);
  }

  public static void assertThatLessThanOrEqualsTo(int value1, int value2) {
    Assertions.assertThat(value1).isLessThanOrEqualTo(value2);
  }

  public static void assertTrue(boolean condition, String failureMessage) {
    Assertions.assertThat(condition).withFailMessage(failureMessage).isTrue();
  }
}
