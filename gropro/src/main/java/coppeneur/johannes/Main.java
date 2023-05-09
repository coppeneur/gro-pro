package coppeneur.johannes;

import coppeneur.johannes.data.Train;
import coppeneur.johannes.io.Input;
import coppeneur.johannes.io.Output;
import coppeneur.johannes.io.ReadFile;
import coppeneur.johannes.io.WriteFile;
import coppeneur.johannes.util.ReductionStrategy;
import coppeneur.johannes.util.Solver;
import coppeneur.johannes.util.StationReductionStrategy;
import coppeneur.johannes.util.TrainReductionStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Class where all the magic happens.
 */
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
            handleArgs(new String[]{"src/main/resources/gereon5.txt"});


            Input readFile = new ReadFile(INPUT_FILE_PATH);
            List<Train> trains = readFile.readInput();

            List<ReductionStrategy> reductionStrategies = new ArrayList<>();
            reductionStrategies.add(new StationReductionStrategy());
            reductionStrategies.add(new TrainReductionStrategy());
            System.out.println("START ");
            System.out.println(trains);

            int i = 2;
            for (ReductionStrategy reduction : reductionStrategies) {
                System.out.println("\n");
                System.out.println("Reduktion " + i);

                trains = reduction.reduce(trains);
                System.out.println(trains);
                System.out.println("\n");
                i++;
            }


            Solver solver = new Solver();
            System.out.println(trains);
            System.out.println("\n");
            System.out.println(solver.getMinServiceStation(trains));


//            testTrainReductionStrategy();
            Output writeFile = new WriteFile(OUTPUT_FILE_PATH);
//            writeFile.writeFile(measurement);

        } catch (Exception e) {
            System.out.println("In main: \n" + e.toString());
        }
    }
}
