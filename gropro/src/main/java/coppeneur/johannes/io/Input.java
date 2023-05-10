package coppeneur.johannes.io;

import coppeneur.johannes.data.RailroadNetwork;

import java.io.IOException;

/**
 * Interface for the input of a Rail Network
 *
 * @author Johannes Coppeneur
 */
public interface Input {

  /**
   * Returns a List of Trains which is located in the specified file.
   *
   * @return List of Trains
   * @throws IOException Throws an exception if the file cannot be found or opened
   */
  RailroadNetwork readInput() throws IOException;
}
