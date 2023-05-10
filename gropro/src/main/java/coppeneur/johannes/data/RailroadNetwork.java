package coppeneur.johannes.data;

import coppeneur.johannes.algorithm.reduction.ReductionStrategy;
import coppeneur.johannes.algorithm.reduction.StationReductionStrategy;
import coppeneur.johannes.algorithm.reduction.TrainReductionStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents a railroad network contains a Method to find the minimum of services
 * tations of a given List of Trains
 *
 * @author Johannes Coppeneur
 */
public class RailroadNetwork {

  private List<Train> trains;
  private final List<ReductionStrategy> reducers = new ArrayList<>();

  public RailroadNetwork(List<Train> trains) {
    setDefaultReducers();
    this.trains = reduce(trains);
  }

  private List<Train> reduce(List<Train> trains) {
    int i = 2;
    List<Train> reducedTrains = new ArrayList<>();
    for (ReductionStrategy reduction : this.reducers) {
      //                System.out.println("\n");
      System.out.println("Reduktion " + i);

      //                System.out.println(trains.size());
      reducedTrains = reduction.reduce(trains);
      //                System.out.println(trains.size());
      System.out.println(trains);
      System.out.println("\n");
      i++;
    }
    return reducedTrains;
  }

  private void setDefaultReducers() {
    this.reducers.add(new StationReductionStrategy());
    this.reducers.add(new TrainReductionStrategy());
  }

  public List<Train> getTrains() {
    return trains;
  }

  public void setTrains(List<Train> trains) {
    this.trains = trains;
  }
}
