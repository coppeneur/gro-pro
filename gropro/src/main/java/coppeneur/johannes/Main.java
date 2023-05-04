package coppeneur.johannes;

import coppeneur.johannes.data.Measurement;
import coppeneur.johannes.io.Input;
import coppeneur.johannes.io.Output;
import coppeneur.johannes.io.ReadFile;
import coppeneur.johannes.io.WriteFile;

import java.io.File;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    // lets test reading files
    // https://www.geeksforgeeks.org/the-knights-tour-problem/

    try {
      String path = "src/main/resources/test.txt";
      Input readFile = new ReadFile(path);
      Measurement measurement = readFile.readInput(path);
      System.out.println(measurement);
      Output writeFile = new WriteFile();
      writeFile.writeFile(measurement);

    } catch (Exception e) {
      System.out.println("In main: \n" + e.toString());
    }
  }
}
