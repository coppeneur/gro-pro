package coppeneur.johannes.algorithm;

import coppeneur.johannes.algorithm.reduction.ReductionStrategy;
import coppeneur.johannes.algorithm.reduction.StationReductionStrategy;
import coppeneur.johannes.algorithm.reduction.TrainReductionStrategy;
import coppeneur.johannes.data.RailroadNetwork;
import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;
import coppeneur.johannes.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ServiceStationFinder {

  private final List<ReductionStrategy> reducers = new ArrayList<>();

  public ServiceStationFinder(){
    setDefaultReducers();

}
  /**
   * Method to get the Minimum service-stations of a railroad network with a greedy approach
   *
   * @param railroadNetwork network of which the minimum servicestation should be determined
   * @return List of Strings, with the names of the Service-points
   */
  public List<Station> getMinServiceStation(RailroadNetwork railroadNetwork) {

    List<Station> serviceStations = new ArrayList<>();

    List<Train> trains = reduce(railroadNetwork.getTrains());

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
}
