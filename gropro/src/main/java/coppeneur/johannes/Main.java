package coppeneur.johannes;

import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;
import coppeneur.johannes.io.Input;
import coppeneur.johannes.io.Output;
import coppeneur.johannes.io.ReadFile;
import coppeneur.johannes.io.WriteFile;
import coppeneur.johannes.util.ReductionStrategy;
import coppeneur.johannes.util.TrainReductionStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String OUTPUT_FILE_PATH_DEFAULT = "output/output.txt";

    private static String OUTPUT_FILE_PATH;
    private static String INPUT_FILE_PATH;

    private static void handleArgs(String[] args) {

        // number handeling

        //    int firstArg;
        //    if (args.length > 0) {
        //      try {
        //        firstArg = Integer.parseInt(args[0]);
        //      } catch (NumberFormatException e) {
        //        System.err.println("Argument" + args[0] + " must be an integer.");
        //        System.exit(1);
        //      }
        //    }

        // input output file
        if (args == null || args.length == 0) {
//            throw new RuntimeException("No input file declared");

        } else if (args.length == 1) {
            System.out.println("1 input params");
            // input file
            // output file default
            INPUT_FILE_PATH = args[0];
            OUTPUT_FILE_PATH = OUTPUT_FILE_PATH_DEFAULT;

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
            File test = new File("hs.produktion");
            System.out.println(test.getAbsolutePath());
            handleArgs(new String[]{"src/main/resources/test.in"});
            // lets test reading files
            // https://www.geeksforgeeks.org/the-knights-tour-problem/
            // String path = "src/main/resources/test.txt";
            Input readFile = new ReadFile(INPUT_FILE_PATH);
            List<Train> trains = readFile.readInput();


            System.out.println(trains);


            testTrainReductionStrategy();
            Output writeFile = new WriteFile(OUTPUT_FILE_PATH);
//            writeFile.writeFile(measurement);

        } catch (Exception e) {
            System.out.println("In main: \n" + e.toString());
        }
    }


    static void testTrainReductionStrategy() {
        try {
            ReadFile readFile = new ReadFile("resources/Reduction3.txt");
            List<Train> trains = new ArrayList<>();
            trains = readFile.readInput();
            ReductionStrategy strategy3 = new TrainReductionStrategy();

            System.out.println(strategy3.reduce(trains));
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
