package coppeneur.johannes.algorithm;

import coppeneur.johannes.algorithm.reduction.ReductionStrategy;
import coppeneur.johannes.algorithm.reduction.StationReductionStrategy;
import coppeneur.johannes.algorithm.reduction.TrainReductionStrategy;
import coppeneur.johannes.data.RailroadNetwork;
import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;
import coppeneur.johannes.util.Util;

import java.util.*;

public class ServiceStationFinder {

  private final List<ReductionStrategy> reducers = new ArrayList<>();

  private List<Train> trains;
  private Set<Station> stations;

  public ServiceStationFinder() {
    setDefaultReducers();
  }

  private List<Station> currentServiceStation;


  private void setDefaultReducers() {
    this.reducers.add(new StationReductionStrategy());
    this.reducers.add(new TrainReductionStrategy());
  }

  private List<Train> reduce(List<Train> trains) {
    int i = 2;
    List<Train> reducedTrains = new ArrayList<>();
    for (ReductionStrategy reduction : this.reducers) {
      //                System.out.println("\n");
      //      System.out.println("Reduktion " + i);

      //                System.out.println(trains.size());
      reducedTrains = reduction.reduce(trains);
      //                System.out.println(trains.size());
      //      System.out.println(trains);
      //      System.out.println("\n");
      i++;
    }
    return reducedTrains;
  }

  // int stepsTillSkip = shortest.size() - current.size();
  // if (shortest.size() != 0 && remainingConnections.size() >= stepsTillSkip *
  // station.getConnectionCount()) {
  //  return;
  // }

  /**
   * Method to get the Minimum service-stations of a railroad network with a greedy approach
   *
   * @param listoftrains list of Train of which the greedy upper limit should be determined
   * @return List of Strings, with the names of the Service-points
   */
  public List<Station> findMinServiceStationsGreedy(List<Train> listoftrains) {

    List<Station> serviceStations = new ArrayList<>();

    List<Train> trains = reduce(listoftrains);

    while (!trains.isEmpty()) {

      List<Station> allStations =
          trains.stream().flatMap(train -> train.getStations().stream()).toList();

      Map<Station, Integer> test = Util.countFrequencies(allStations);

      Optional<Map.Entry<Station, Integer>> mostFrequentStation =
          Util.countFrequencies(allStations).entrySet().stream().max(Map.Entry.comparingByValue());

      //            if (mostFrequentStation.isEmpty()) {
      //                System.out.println("mostFrequentStation ist Empty. Kann das sein?");
      //            }

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



  public Set<Station> findMinServiceStation(RailroadNetwork railroadNetwork) {
    List<Train> reducedTrains = reduce(railroadNetwork.getTrains());

    this.trains = reducedTrains;
    this.stations = new HashSet<>(this.trains.stream().map(Train::getStations).flatMap(Collection::stream).toList());
    List<Station> greedyUpperLimit =findMinServiceStationsGreedy(reducedTrains);
    System.out.println("Greedy upper limit: " + greedyUpperLimit.size() + "\n" + greedyUpperLimit);

    backtrack(new HashSet<>(), greedyUpperLimit.size());
    System.out.println("Minimum Servicesations " + stations.size() + "\n" + stations);

    return stations;
  }

  // Recursive method that backtracks to find the minimum hitting set
  private void backtrack(Set<Station> selected, int upperBound) {
    if (isCovered(selected)) {
      stations = new HashSet<>(selected);
      // only consider hitting sets better than the current solution and better than the solution
      // from the greedy algo
    } else if (selected.size() < upperBound && selected.size() < stations.size() - 1) {
      // For each unselected element, add it to the selected set and backtrack
      for (Station elem : getUnselectedElements(selected)) {
        selected.add(elem);
        List<Train> prev = this.trains;
        this.trains = this.trains.stream().filter(train -> !train.getStations().contains(elem)).toList();
        backtrack(selected, upperBound);
        //        System.out.println(selected.size());
        this.trains = prev;
        selected.remove(elem);
      }
    }
  }

  // Returns true if the selected set covers all sets
  private boolean isCovered(Set<Station> selected) {
    // For each set, if it does not intersect with the selected set, the selection does not cover
    // all sets
    for (Train train : trains) {
      if (Collections.disjoint(train.getStations(), selected)) {
        return false;
      }
    }
    // If the selection covers all sets, return true
    return true;
  }

  // Returns the set of unselected elements
  private Set<Station> getUnselectedElements(Set<Station> selected) {
//        return sets.stream().filter(set -> Collections.disjoint(set, selected)).flatMap(Collection::stream).collect(Collectors.toSet());
//
//        Set<String> unselected = new HashSet<>();
//        // For each set, if it doesn't intersect with the selected set, add its elements to the
//        // unselected set
//        for (Set<String> set : sets) {
//            if (Collections.disjoint(set, selected)) {
//                unselected.addAll(set);
//            }
//        }
//        return unselected;

    Set<Station> unselected = new HashSet<>();
    // For each set, if it doesn't intersect with the selected set, add its elements to the
    // unselected set
    trains.stream().map(Train::getStations).filter(stationss -> Collections.disjoint(stationss, selected)).forEach(unselected::addAll);
    return unselected;
  }

}
