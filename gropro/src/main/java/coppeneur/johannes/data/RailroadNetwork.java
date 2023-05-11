package coppeneur.johannes.data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class which represents a railroad network
 *
 * @author Johannes Coppeneur
 */
public class RailroadNetwork {

  /** List of Trains in the Railroad network */
  private List<Train> trains;

  /**
   * Constructor
   *
   * @param trains List of trains
   */
  public RailroadNetwork(List<Train> trains) {
    this.trains = trains;
  }

  /**
   * Returns the Trains of the railroad network
   *
   * @return List of trains
   */
  public List<Train> getTrains() {
    return trains;
  }

  /**
   * Displays the railroad network as a String
   *
   * @return string
   */
  @Override
  public String toString() {
    return "RailroadNetwork{"
        + "\n\t"
        + trains.stream().map(Train::toString).collect(Collectors.joining(",\n\t"))
        + "\n}";
  }
}
