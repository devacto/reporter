package com.example.reporter;

import static java.lang.System.exit;

public class Application {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Needs 2 arguments: <path-to-survey.csv> <path-to-response.csv>");
      exit(1);
    }


  }
}
