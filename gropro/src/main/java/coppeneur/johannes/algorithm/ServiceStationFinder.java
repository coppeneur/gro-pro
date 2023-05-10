package coppeneur.johannes.algorithm;

import coppeneur.johannes.data.RailroadNetwork;
import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;
import coppeneur.johannes.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ServiceStationFinder {

  /**
   * Method to get the Minimum service-stations of a railroad network with a greedy approach
   *
   * @param railroadNetwork network of which the minimum servicestation should be determined
   * @return List of Strings, with the names of the Service-points
   */
  public List<Station> getMinServiceStation(RailroadNetwork railroadNetwork) {

    List<Station> serviceStations = new ArrayList<>();

    List<Train> trains = railroadNetwork.getTrains();

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
}
