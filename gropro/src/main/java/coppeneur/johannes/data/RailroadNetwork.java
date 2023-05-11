package coppeneur.johannes.data;

import coppeneur.johannes.algorithm.reduction.ReductionStrategy;
import coppeneur.johannes.algorithm.reduction.StationReductionStrategy;
import coppeneur.johannes.algorithm.reduction.TrainReductionStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class which represents a railroad network contains a Method to find the minimum of services
 * tations of a given List of Trains
 *
 * @author Johannes Coppeneur
 */
public class RailroadNetwork {

  private List<Train> trains;

  public RailroadNetwork(List<Train> trains) {
    this.trains = trains;
  }

  public List<Train> getTrains() {
    return trains;
  }

  public void setTrains(List<Train> trains) {
    this.trains = trains;
  }

  @Override
  public String toString() {
    return "RailroadNetwork{" +
            "\n\t" + trains.stream().map(Train::toString).collect(Collectors.joining(",\n\t")) +
            "\n}";
  }
}
