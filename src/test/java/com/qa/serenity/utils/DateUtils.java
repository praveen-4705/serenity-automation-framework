package com.qa.serenity.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DateUtils {

  private static final DateTimeFormatter longFormDate = DateTimeFormatter.ofPattern("MMM dd, yyyy");
  private static final DateTimeFormatter longFormDateAdj =
      DateTimeFormatter.ofPattern("MMM d, yyyy");
  private static final DateTimeFormatter shortFormDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");

  /**
   * This Date formatting method is used to validate dates in the 'Duration' section of the checkout
   * confirmation and reservation screens
   *
   * @param date
   * @return parsed form of the date, MM/DD/YYYY
   */
  public String formatDateMMDDYYYY(String date) {
    LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
    return parsedDate.format(shortFormDate);
  }

  /**
   * This date formatting method is used to validate dates on the Reservation screen only
   *
   * @param date
   * @return a fully expanded date string with a two digit date, for example: if date input is
   *     "20190601", return value will be "June 01, 2019"
   */
  public static String formatDateMMMDDYYYY(String date) {
    LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
    return parsedDate.format(longFormDate);
  }

  /**
   * This Date formatting method is used to validate information on the checkout confirmation page
   * only.
   *
   * @param date
   * @return parsed form of the date -- identical to the method directly above it, with the
   *     exception that this one will return a single digit date when possible. For example, if date
   *     input is "20190601", return value will be "June 1, 2019"
   */
  public static String formatDateMMMDYYYY(String date) {
    LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
    return parsedDate.format(longFormDateAdj);
  }

  static TemporalAdjuster nextWeekDay =
      TemporalAdjusters.ofDateAdjuster(
          temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd;
            switch (dayOfWeek) {
              case SATURDAY:
                dayToAdd = 2;
                break;
              case SUNDAY:
                dayToAdd = 1;
                break;
              default:
                dayToAdd = 0;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
          });

  public static String getNextWorkingDate() throws Exception {
    // If it's before 5PM local time, select tomorrow; otherwise, select day after tomorrow)
    Integer amountToAdd = LocalTime.now().getHour() < 17 ? 1 : 2;
    LocalDate nextDay = LocalDate.now().plus(amountToAdd, ChronoUnit.DAYS);
    LocalDate nextWeekDayDate = nextDay.with(nextWeekDay);
    String date = nextWeekDayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    while (getHolidayList(nextWeekDayDate.getYear()).contains(date)) {
      nextWeekDayDate = nextWeekDayDate.plusDays(1);
      date = nextWeekDayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    return nextWeekDayDate.format(DateTimeFormatter.BASIC_ISO_DATE);
  }

  public static String getFutureDate(int daysToAdd) throws Exception {
    LocalDate threeDaysFromNow = LocalDate.now().plus(daysToAdd, ChronoUnit.DAYS);
    LocalDate futureWeekDayDate = threeDaysFromNow.with(nextWeekDay);
    String date = futureWeekDayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    while (getHolidayList(futureWeekDayDate.getYear()).contains(date)) {
      futureWeekDayDate = futureWeekDayDate.plusDays(1);
      date = futureWeekDayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    return futureWeekDayDate.format(DateTimeFormatter.BASIC_ISO_DATE);
  }

  public static String getFutureDateForParameterBar(int daysToAdd) throws Exception {
    LocalDate threeDaysFromNow = LocalDate.now().plus(daysToAdd, ChronoUnit.DAYS);
    LocalDate futureWeekDayDate = threeDaysFromNow.with(nextWeekDay);
    String date = futureWeekDayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    while (getHolidayList(futureWeekDayDate.getYear()).contains(date)) {
      futureWeekDayDate = futureWeekDayDate.plusDays(1);
      date = futureWeekDayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    return futureWeekDayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

  public static String getDistantFutureDate() {
    LocalDate twoWeeksFromNow = LocalDate.now().plus(14, ChronoUnit.DAYS);
    LocalDate futureWeekDayDayte = twoWeeksFromNow.with(nextWeekDay);
    return futureWeekDayDayte.format(DateTimeFormatter.BASIC_ISO_DATE);
  }

  public static String getNextSaturdayDate() {
    LocalDate nextSaturday = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
    return nextSaturday.format(DateTimeFormatter.BASIC_ISO_DATE);
  }

  public static String getNextSundayDate() {
    LocalDate nextSunday = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
    return nextSunday.format(DateTimeFormatter.BASIC_ISO_DATE);
  }

  public static String convertDateFormat(
      String date, String dateCurrentFormat, String dateFormatToChange) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateCurrentFormat);
    LocalDate localDate = LocalDate.parse(date.trim(), formatter);
    return DateTimeFormatter.ofPattern(dateFormatToChange).format(localDate);
  }

  public static List<String> getHolidayList(int year) throws Exception {
    Response response =
        RestAssured.given().get(String.format("https://date.nager.at/api/v1/get/US/%d", year));
    List<String> holidayList = new ArrayList<>();
    if (response.statusCode() == 200) {
      JSONParser parser = new JSONParser();
      JSONArray jsonArray = (JSONArray) parser.parse(response.getBody().asPrettyString());
      for (Object object : jsonArray) {
        holidayList.add(String.valueOf(((JSONObject) object).get("date")));
      }
    }

    return holidayList;
  }

  public static List<Integer> getWeekEndDatesOfCurrentMonth() {
    LocalDate today = LocalDate.now();
    int year = today.getYear();
    Month month = today.getMonth();
    return IntStream.rangeClosed(1, YearMonth.of(year, month).lengthOfMonth())
        .mapToObj(day -> LocalDate.of(year, month, day))
        .filter(
            date ->
                date.getDayOfWeek() == DayOfWeek.SATURDAY
                    || date.getDayOfWeek() == DayOfWeek.SUNDAY)
        .map(LocalDate::getDayOfMonth)
        .collect(Collectors.toList());
  }

  public static List<Integer> getHolidayDateList() throws Exception {
    Response response =
        RestAssured.given()
            .get(
                String.format("https://date.nager.at/api/v1/get/US/%d", LocalDate.now().getYear()));
    Month currentMonth = LocalDate.now().getMonth();
    List<Integer> holidayList = new ArrayList<>();
    if (response.statusCode() == 200) {
      JSONParser parser = new JSONParser();
      JSONArray jsonArray = (JSONArray) parser.parse(response.getBody().asPrettyString());
      for (Object object : jsonArray) {
        String date = String.valueOf(((JSONObject) object).get("date"));
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (currentMonth == localDate.getMonth()) {
          holidayList.add(localDate.getDayOfMonth());
        }
      }
    }

    return holidayList;
  }

  public static void main(String[] args) throws Exception {
    System.out.println(getHolidayDateList());
  }
}
