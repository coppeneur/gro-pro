package coppeneur.johannes.io;

import coppeneur.johannes.data.Station;

import java.util.Set;

/** Interface for an output strategie */
public interface Output {
  void writeFile(Set<Station> serviceStations);

  void writeFile(String error);
}
