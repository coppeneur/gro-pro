package coppeneur.johannes.algorithm;

import coppeneur.johannes.algorithm.reduction.ReductionStrategy;
import coppeneur.johannes.algorithm.reduction.StationReductionStrategy;
import coppeneur.johannes.algorithm.reduction.TrainReductionStrategy;
import coppeneur.johannes.data.RailroadNetwork;
import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;
import coppeneur.johannes.util.Util;

import java.util.*;

/**
 * Class which contains algorithms and helper function to determine the minimum numbers of
 * servicestation in a RailRoadNetwork
 */
public class ServiceStationFinder {

  /** List of reducers */
  private final List<ReductionStrategy> reducers = new ArrayList<>();

  private List<Train> trains;
  /** Set of Servicestations */
  private Set<Station> serviceStationSet;

  /** Upper bound, amount of stations in the best known solution */
  private int upperBound;

  /** Constructor */
  public ServiceStationFinder() {
    setDefaultReducers();
  }

  /** Defines StationReducerStrategy and TrainReducerStrategy as default reducer */
  private void setDefaultReducers() {
    this.reducers.add(new StationReductionStrategy());
    this.reducers.add(new TrainReductionStrategy());
  }

  /**
   * Helper function to reduce the number of trains and stations with the strategy's in the
   * attribute reducers
   *
   * @param trains to be reduced
   * @return List of reduced Trains
   */
  private List<Train> reduce(List<Train> trains) {
    int i = 2;
    List<Train> reducedTrains = new ArrayList<>();
    System.out.println("before reduction " + i + ": " + trains.size() + " trains");
    for (ReductionStrategy reduction : this.reducers) {
      reducedTrains = reduction.reduce(trains);
      System.out.println(reducedTrains);
      System.out.println("after reduction " + i + ": " + reducedTrains.size() + " trains");
      i++;
    }
    return reducedTrains;
  }

  /**
   * Method to get the Minimum service-stations of a railroad network with a greedy approach
   *
   * @param listoftrains list of Train of which the greedy upper limit should be determined
   * @return List of Strings, with the names of the Service-points
   */
  private Set<Station> findMinServiceStationsGreedy(List<Train> listoftrains) {

    Set<Station> serviceStations = new HashSet<>();

    List<Train> trains = listoftrains;

    while (!trains.isEmpty()) {

      List<Station> allStations =
          trains.stream().flatMap(train -> train.getStations().stream()).toList();

      Optional<Map.Entry<Station, Integer>> mostFrequentStation =
          Util.countFrequencies(allStations).entrySet().stream().max(Map.Entry.comparingByValue());

      Station currenServiceStation;
      currenServiceStation = mostFrequentStation.map(Map.Entry::getKey).orElse(null);
      serviceStations.add(currenServiceStation);
      trains =
          trains.stream()
              .filter(train -> !train.getStations().contains(currenServiceStation))
              .toList();
    }
    return serviceStations;
  }

  /**
   * Finds the minimum servicestations to cover every station of the railroadnetwork uses greedy as
   * an upperbound
   *
   * @param railroadNetwork of which the servicestations should be determined
   * @return servicestations, set of station
   */
  public Set<Station> findMinServiceStation(RailroadNetwork railroadNetwork) {
    List<Train> reducedTrains = reduce(railroadNetwork.getTrains());
    this.trains = reducedTrains;
    this.serviceStationSet =
        new HashSet<>(
            this.trains.stream().map(Train::getStations).flatMap(Collection::stream).toList());

    this.serviceStationSet = findMinServiceStationsGreedy(reducedTrains);
    this.upperBound = this.serviceStationSet.size();

    System.out.println(
        "Greedy upper limit: " + this.serviceStationSet.size() + "\n" + this.serviceStationSet);

    findMinServiceStationRek(new HashSet<>());

    System.out.println(
        "Minimum Servicesations " + this.serviceStationSet.size() + "\n" + serviceStationSet);

    return this.serviceStationSet;
  }

  // Recursive method that backtracks to find the minimum hitting set

  /**
   * Backtrack to find the minimum amount of Servicestations so that atleast every train has one
   * skip solutions greater than upperbound
   *
   * @param selected temp Servicestations
   */
  private void findMinServiceStationRek(Set<Station> selected) {
    if (everyTrainHasServicestation(selected)) {
      this.serviceStationSet = new HashSet<>(selected);
      this.upperBound = this.serviceStationSet.size();

    } else if (selected.size() < this.upperBound - 1) {
      for (Station elem : getStationsOfUnreachableTrains(selected)) {
        selected.add(elem);
        List<Train> prevTrains = this.trains;
        this.trains =
            this.trains.stream().filter(train -> !train.getStations().contains(elem)).toList();
        findMinServiceStationRek(selected);
        this.trains = prevTrains;
        selected.remove(elem);
      }
    }
  }

  /**
   * Returns true if each train trains contains at least one of the selected stations, otherwise
   * returns false
   *
   * @param stationSet, Set of Station
   * @return bool
   */
  private boolean everyTrainHasServicestation(Set<Station> stationSet) {
    for (Train train : trains) {
      if (Collections.disjoint(train.getStations(), stationSet)) {
        return false;
      }
    }
    return true;
  }

  // Returns the set of unselected elements

  /**
   * Return all stations that do not occur in the trains from the stationSet stations
   *
   * @param stationSet, Set von Stationen
   * @return stationsOfUnreachableTrains,
   */
  private Set<Station> getStationsOfUnreachableTrains(Set<Station> stationSet) {
    Set<Station> stationsOfUnreachableTrains = new HashSet<>();
    trains.stream()
        .map(Train::getStations)
        .filter(stationss -> Collections.disjoint(stationss, stationSet))
        .forEach(stationsOfUnreachableTrains::addAll);
    return stationsOfUnreachableTrains;
  }
}
