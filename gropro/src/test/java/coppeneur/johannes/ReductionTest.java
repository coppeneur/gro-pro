package coppeneur.johannes;

import coppeneur.johannes.data.Train;
import coppeneur.johannes.io.ReadFile;
import coppeneur.johannes.util.ReductionStrategy;
import coppeneur.johannes.util.StationReductionStrategy;
import coppeneur.johannes.util.TrainReductionStrategy;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Coppeneur
 */
public class ReductionTest {


    @Test
    void testTrainReductionStrategy() {
        try {
            ReadFile readFile = new ReadFile("src/main/resources/Reduction3.txt");
            List<Train> trains = new ArrayList<>();
            trains = readFile.readInput();
            ReductionStrategy strategy3 = new TrainReductionStrategy();

            System.out.println(strategy3.reduce(trains));
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    @Test
    void testStationReductionStrategy() {
        try {

            //TODO
            // OBJ PARSEN
            // schöner PRINTER für Train Liste?
            ReadFile readFile = new ReadFile("src/main/resources/Reduction2.txt");
            List<Train> trains = new ArrayList<>();
            trains = readFile.readInput();
            ReductionStrategy strategy2 = new StationReductionStrategy();

            System.out.println(strategy2.reduce(trains));

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
    @Test
    void testBastiStationReductionStrategy() {
        try {

            //TODO
            // OBJ PARSEN
            // schöner PRINTER für Train Liste?
            ReadFile readFile = new ReadFile("src/main/resources/Reduktion2Basti.txt");
            List<Train> trains = new ArrayList<>();
            trains = readFile.readInput();
            ReductionStrategy strategy2 = new StationReductionStrategy();

            System.out.println(strategy2.reduce(trains));

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    @Test
    void testAlgoBspStationReductionStrategy() {
        try {

            //TODO
            // OBJ PARSEN
            // schöner PRINTER für Train Liste?
            ReadFile readFile = new ReadFile("src/main/resources/test.in");
            List<Train> trains = new ArrayList<>();
            trains = readFile.readInput();
            ReductionStrategy strategy2 = new StationReductionStrategy();

            System.out.println(strategy2.reduce(trains));

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }


    @Test
    void testRANDOMStationReductionStrategy() {
        try {

            //TODO
            // OBJ PARSEN
            // schöner PRINTER für Train Liste?
            ReadFile readFile = new ReadFile("src/main/resources/random.txt");
            List<Train> trains = new ArrayList<>();
            trains = readFile.readInput();
            ReductionStrategy strategy2 = new StationReductionStrategy();

            System.out.println(strategy2.reduce(trains));

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
