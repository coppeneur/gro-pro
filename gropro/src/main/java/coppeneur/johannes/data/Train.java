package coppeneur.johannes.data;

import java.util.HashSet;
import java.util.Set;

/**
 * The Train class represents Set of stations. Stations.
 *
 * @author Johannes Coppeneur
 */
public class Train {

  /** Set of stations which are on the train route. */
  private Set<Station> stations;

  /**
   * Constructor.
   *
   * @param stations Set of Station of the train route
   */
  public Train(Set<Station> stations) {
    this.stations = new HashSet<>(stations);
  }

  /**
   * Return the Set of stations of the train route.
   *
   * @return stations
   */
  public Set<Station> getStations() {
    return this.stations;
  }


  /**
   * Removes the given station from the train route.
   *
   * @param stationToRemove String, name of the station to be removed
   */
  public void removeStation(Station stationToRemove) {
    this.stations.remove(stationToRemove);
  }

  /**
   * Returns a string representation of the train route.
   *
   * @return Returns a string representation of the train route.
   */
  @Override
  public String toString() {
    return "Train{" + "Stations=" + stations + "}";
  }
}
