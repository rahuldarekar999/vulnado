package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cowsay {
  public static String run(String input) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";
    System.out.println(cmd);
    if (isValidCommand(cmd)) {
      processBuilder.command("bash", "-c", cmd);
    } else {
      "invlid operation";
    }
    //processBuilder.command("bash", "-c", cmd);

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return output.toString();
  }
  public static boolean isValidCommand(String cmd) {
    return cmd.matches("[a-zA-Z0-9\\-\\_]+");
  }

}
