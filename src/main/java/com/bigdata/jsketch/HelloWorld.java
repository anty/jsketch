package com.bigdata.jsketch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
  private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

  private static void printLogo1(String subName) {
    System.out.println("  _____________        _________      _____        ");
    System.out.println("  ___  __ )__(_)______ ______  /_____ __  /______ _");
    System.out.println("  __  __  |_  /__  __ `/  __  /_  __ `/  __/  __ `/");
    System.out.println("  _  /_/ /_  / _  /_/ // /_/ / / /_/ // /_ / /_/ / ");
    System.out.println("  /_____/ /_/  _\\__, / \\__,_/  \\__,_/ \\__/ \\__,_/");
    System.out.println("               /____/   " + subName);
    System.out.println("");
  }
  
  private static void printLogo2(String subName) {
    // try to find logo in classpath
    ClassLoader classLoader = HelloWorld.class.getClassLoader();
    URL logoUrl = classLoader.getResource("logo.txt");
    if (logoUrl == null) {
      printLogo1(subName);
    } else {
      try {
        String logoPath = logoUrl.getFile();
        FileReader reader = new FileReader(logoPath);
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        while ((line = br.readLine()) != null) {
          System.out.println();
          System.out.print(line);
        }
        System.out.println(subName);
      } catch (Exception ex) {
        printLogo1(subName);
      }
    }
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // printLogo1("HelloWorld1");
    printLogo2("HelloWorld2");

    System.out.println("Hello World!");
    logger.info("Hello World!");
        
    for (int i = 0; i < args.length; i++) {
      System.out.println("args[" + i  + "] = " + args[i]);
    }
  }

}
