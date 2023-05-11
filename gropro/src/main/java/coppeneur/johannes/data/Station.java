package coppeneur.johannes.data;

import java.util.Objects;

/** This class represents a station of a train */
public class Station {

  private final String name;

  /**
   * Constructor
   *
   * @param name unique name of the station
   */
  public Station(String name) {
    this.name = name;
  }

  /**
   * Returns the name of the station
   *
   * @return name of the station
   */
  public String getName() {
    return this.name;
  }

  /**
   * Overrides the toString to display the station as a string
   *
   * @return
   */
  @Override
  public String toString() {
    return this.name;
  }

  /**
   * A station is equal when the name is the same
   *
   * @return true if the name is the same
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Station station)) return false;
    return Objects.equals(getName(), station.getName());
  }

  /**
   * Returns the hashcode of Station
   *
   * @return int hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
