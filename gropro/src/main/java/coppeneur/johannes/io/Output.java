package coppeneur.johannes.io;


import coppeneur.johannes.data.Station;

import java.util.List;

/**
 * Interface for an output strategie
 */
public interface Output {
  void writeFile(List<Station> serviceStations);
}
