package coppeneur.johannes;

import coppeneur.johannes.algorithm.ServiceStationFinder;
import coppeneur.johannes.data.RailroadNetwork;
import coppeneur.johannes.io.Input;
import coppeneur.johannes.io.Output;
import coppeneur.johannes.io.ReadFile;
import coppeneur.johannes.io.WriteFile;

import java.io.File;

/** Main Class where all the magic happens. */
public class Main {
  private static final String OUTPUT_FILE_PATH_DEFAULT = "output/output.txt";

  private static String OUTPUT_FILE_PATH;
  private static String INPUT_FILE_PATH;

  private static void handleArgs(String[] args) {

    // number handeling

    //            int firstArg;
    //            if (args.length > 0) {
    //              try {
    //                firstArg = Integer.parseInt(args[0]);
    //              } catch (NumberFormatException e) {
    //                System.err.println("Argument" + args[0] + " must be an integer.");
    //                System.exit(1);
    //              }
    //            }

    // input output file
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
   * Main function to start the programm
   *
   * @param args [0] input File name [1] output file name. default: TODO
   */
  public static void main(String[] args) {
    try {
      //            String [] test = new
      // String[]{"src/main/resources/ErrorCases/B723StreckenBiszu39HaltepunkteRandom.txt"};
      String[] test = new String[] {"src/main/resources/Felix/random_60_100.txt"};
      handleArgs(test);

      Input readFile = new ReadFile(INPUT_FILE_PATH);
      RailroadNetwork railroadNetwork = readFile.readInput();
      System.out.println(railroadNetwork);
      ServiceStationFinder serviceStationFinderA = new ServiceStationFinder();
      ServiceStationFinder serviceStationFinderB = new ServiceStationFinder();
      Output writeFile = new WriteFile(OUTPUT_FILE_PATH);
//      System.out.println("Optimal: " + serviceStationFinderA.findMinimumHittingSet(railroadNetwork));
      long startTime = System.nanoTime();
      System.out.println("MIN: " + serviceStationFinderB.findMinServiceStation(railroadNetwork));
      long stopTime = System.nanoTime();
      System.out.println(stopTime - startTime);
//      writeFile.writeFile(serviceStationFinder.findMinServiceStationsGreedy(railroadNetwork));

    } catch (Exception e) {
      System.out.println("\n" + e);
    }
  }
}
