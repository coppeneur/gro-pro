package coppeneur.johannes;

import coppeneur.johannes.algorithm.ServiceStationFinder;
import coppeneur.johannes.algorithm.reduction.ReductionStrategy;
import coppeneur.johannes.algorithm.reduction.StationReductionStrategy;
import coppeneur.johannes.algorithm.reduction.TrainReductionStrategy;
import coppeneur.johannes.data.RailroadNetwork;
import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;
import coppeneur.johannes.io.ReadFile;
import junit.framework.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Johannes Coppeneur
 */
public class ReductionTest {

//  @Nested
//  @DisplayName("Reduction Strategy")
//  class ReductionStrategyTest {
//
//    @Test
//    @DisplayName("Remove Duplicate Stations")
//    void testRemoveDuplicateStation() {
//      try {
//        ReadFile readFile = new ReadFile("src/main/resources/IHK-Beispiele/Reduktion1.txt");
//        RailroadNetwork railroadNetwork = readFile.readInput();
//        ReadFile solutionFile =
//            new ReadFile("src/main/resources/IHK-Beispiele/Reduktion1Solution.txt");
//        RailroadNetwork solutionNetwork = solutionFile.readInput();
//        Assert.assertEquals(railroadNetwork.getTrains(), solutionNetwork.getTrains());
//      } catch (IOException e) {
//        System.out.println(e.toString());
//      }
//    }
//
//    @Test
//    @DisplayName("Station Reduction")
//    void testStationReductionStrategy() {
//      try {
//        ReadFile readFile = new ReadFile("src/main/resources/IHK-Beispiele/Reduktion2.txt");
//        RailroadNetwork railroadNetwork = readFile.readInput();
//        ReductionStrategy stationReducer = new StationReductionStrategy();
//
//        List<Train> reduced = stationReducer.reduce(railroadNetwork.getTrains());
//
//
//
//        // solution can't be read because it's train whith single stations
//        Train train = new Train(new HashSet<>(Arrays.asList(new Station("H"))));
//        List<Train> list = Arrays.asList(train, train, train, train);
//        Assert.assertEquals(reduced, list);
//      } catch (IOException e) {
//        System.out.println(e.toString());
//      }
//    }
//
//    @Test
//    @DisplayName("Train Reduction")
//    void testTrainReductionStrategy() {
//      try {
//        ReadFile readFile = new ReadFile("src/main/resources/IHK-Beispiele/Reduktion3.txt");
//        //        RailroadNetwork railroadNetwork = readFile.readInput();
//        //        ReductionStrategy trainReducer = new TrainReductionStrategy();
//
//        //        List<Train> solutionTrain = solutionFile.readInput().getTrains();
//
//      } catch (IOException e) {
//        System.out.println(e.toString());
//      }
//    }
//  }
}
