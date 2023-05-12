package com.qa.serenity.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {

  public static ProductFields productFields = new ProductFields();
  public static final String LOGIN_PASSWORD = "United123";

  public static final String PHONE = "PHONE";
  public static final String EMAIL = "EMAIL";
  public static final String NO_REPLY = "NO REPLY";
  public static final Map<String, String> STEP_DATA = new HashMap<>();
  public static final String FIELD_CONTACT = "Test Field Contact";
  public static final String FIELD_CONTACT_PHONE = "4587963254";
  public static final String JOB_DESCRIPTION = "Test Job Description";
  public static final String CC_NUMBER = "4111111111111111";
  public static final String CC_CVV = "555";
  public static final String CC_EXPIRE_MONTH = "2";
  public static final String CC_EXPIRE_YEAR = "2030";
  public static final Map<String, String> RUN_TIME_STEP_DATA = new HashMap<>();
  public static final String CART_EMPTY_TEXT = "Your cart is empty.";
  public static final List<String> BUSINESS_HOURS =
      Arrays.asList(
          "7:00am", "7:30am", "8:00am", "8:30am", "9:00am", "9:30am", "10:00am", "10:30am",
          "11:00am", "11:30am", "12:00pm", "12:30pm", "1:00pm", "1:30pm", "2:00pm", "2:30pm",
          "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm");
  public static final List<String> ALL_BRANCH_DROPDOWN_VALUES =
      Arrays.asList(
          "All Branches",
          "Equipment & Tool Rentals",
          "Aerial Equipment",
          "Climate Solutions",
          "Commercial Heating & Fuel",
          "Commercial Trucks",
          "Communications & Industrial Blinds",
          "Customer Equipment Solutions",
          "Flooring & Facility Solutions",
          "Fluid Solutions",
          "Power & HVAC",
          "Reliable Onsite Services",
          "Scaffolding",
          "Storage Containers & Mobile Offices",
          "Trench Safety");
  public static final List<String> FOOTER_LEGAL_MENU =
      Arrays.asList(
          "Privacy Policy",
          "Terms of Use",
          "Legal Terms and Conditions",
          "Equipment Directory",
          "Branch Directory");
  public static final List<String> FOOTER_URONE_MENU =
      Arrays.asList(
          "Mobile App",
          "Download for Android",
          "Download for Apple",
          "Contact Us",
          "Catalog Request",
          "Credit Application",
          "Email Us",
          "GSA Contract Holder",
          "About Us",
          "Corporate Fact Sheet",
          "Corporate Responsibility",
          "Mission & Values",
          "Project Uptime",
          "Careers",
          "Campus",
          "Events",
          "Military",
          "Search Jobs",
          "Investor Relations",
          "Annual Reports",
          "Presentations");

  public static final List<String> COMPANY_PAGE_SUB_HEADERS =
      Arrays.asList("About United Rentals", "Our Careers", "News & Events", "Investor Relations");
}
