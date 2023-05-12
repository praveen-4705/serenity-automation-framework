package com.qa.serenity.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonUtils {
  private String fileSeparator = File.separator;

  private static JsonObject getJsonObject(String fileName) throws Exception {
    Path path =
        new File(
                System.getProperty("user.dir")
                    + "\\src\\test\\resources\\jira\\status\\"
                    + fileName
                    + ".json")
            .toPath();
    return JsonParser.parseReader(Files.newBufferedReader(path)).getAsJsonObject();
  }

  public static String updateJson(String transitionId, String comment) throws Exception {
    JsonObject rootObject = getJsonObject("JiraStatusUpdate");
    JsonObject commentObject =
        rootObject
            .getAsJsonObject("update")
            .getAsJsonArray("comment")
            .get(0)
            .getAsJsonObject()
            .getAsJsonObject("add");
    JsonObject transitionObject = rootObject.getAsJsonObject("transition");
    transitionObject.addProperty("id", transitionId);
    commentObject.addProperty("body", comment);
    return rootObject.toString();
  }

  public static void main(String[] args) throws Exception {
    System.out.println(updateJson("54698", "Test Automation"));
  }
}
