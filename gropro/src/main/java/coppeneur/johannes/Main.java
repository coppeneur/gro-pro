package coppeneur.johannes;

import coppeneur.johannes.algorithm.ServiceStationFinder;
import coppeneur.johannes.data.RailroadNetwork;
import coppeneur.johannes.data.Station;
import coppeneur.johannes.io.Input;
import coppeneur.johannes.io.Output;
import coppeneur.johannes.io.ReadFile;
import coppeneur.johannes.io.WriteFile;

import java.io.File;
import java.util.Set;

/** Main Class where all the magic happens. */
public class Main {

  private static String OUTPUT_FILE_PATH;
  private static String INPUT_FILE_PATH;

  private static void handleArgs(String[] args) {

    if (args.length == 0) {
      throw new RuntimeException("No input file declared.");

    } else if (args.length == 1) {
      System.out.println("1 input params");
      // input file
      // output file default
      INPUT_FILE_PATH = args[0];
      File inputFile = new File(args[0]);
      OUTPUT_FILE_PATH = "output/" + inputFile.getName() + ".out";

    } else if (args.length == 2) {
      System.out.println("2 input params");
      INPUT_FILE_PATH = args[0];
      OUTPUT_FILE_PATH = args[1];
    }
  }

  /**
   * Main function to start the programm to find the minimum amount of servicestations in a railroad
   * network. The railroad network gets parsed through input file.
   *
   * @param args [0] input File name [1] output file name.
   */
  public static void main(String[] args) {
    try {
      handleArgs(args);

      Input readFile = new ReadFile(INPUT_FILE_PATH);
      RailroadNetwork railroadNetwork = readFile.readInput();

      System.out.println(railroadNetwork);

      Output writeFile = new WriteFile(OUTPUT_FILE_PATH);

      long startTime = System.nanoTime();
      ServiceStationFinder serviceStationFinder = new ServiceStationFinder();
      Set<Station> minServiceStation = serviceStationFinder.findMinServiceStation(railroadNetwork);

      long stopTime = System.nanoTime();
      System.out.println(
          "Finished in: " + ((double) (stopTime - startTime) / 1000000000) + " seconds");

      writeFile.writeFile(minServiceStation);

    } catch (Exception e) {
      try {
        System.out.println("\n An Error appeared: " + e);
        Output writeFile = new WriteFile(OUTPUT_FILE_PATH);
        writeFile.writeFile(e.toString());
      } catch (Exception exception) {
        System.out.println();
      }
    }
  }
}
