package com.qa.serenity.utils;

import java.io.File;

public class FileUtils {

  public static boolean isFilePresent(String directory, String fileNameWithExtension) {
    return new File(directory + fileNameWithExtension).exists();
  }

  public static boolean isGenerateSignatureFilePresent() {
    String directory =
        System.getProperty("user.dir") + File.pathSeparator + "target" + File.pathSeparator;
    return new File(directory + "newsignature.txt").exists();
  }
}
