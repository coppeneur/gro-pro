package coppeneur.johannes.algorithm.reduction;

import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;
import coppeneur.johannes.util.Util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Strategy to Reduce the amount of stations in a List of train routes. Rule: If train 1 * stops at
 * all stations where train 2 stops, then train 1 may be removed from the list of * trains.
 *
 * @author Johannes Coppeneur
 */
public class StationReductionStrategy implements ReductionStrategy {
  @Override
  public List<Train> reduce(List<Train> trains) {

    List<Station> toRemove = new ArrayList<>();
    Set<Station> allUniqueStations =
        trains.stream().flatMap(train -> train.getStations().stream()).collect(Collectors.toSet());

    for (Station station : allUniqueStations) {

      // Liste aller Trains von einer Station
      List<Train> trainsOfStation = new ArrayList<>();
      for (Train train : trains) {
        if (train.getStations().contains(station)) {
          trainsOfStation.add(train);
        }
      }

      // alle stationen der Zuege der stationen
      List<Station> allStationsOfListOfTrains =
          trainsOfStation.stream().flatMap(train -> train.getStations().stream()).toList();

      Map<Station, Integer> stationOccurences = Util.countFrequencies(allStationsOfListOfTrains);

      for (Map.Entry<Station, Integer> entry : stationOccurences.entrySet()) {
        if (entry.getKey().equals(station)) {
          continue;
        }
        if ((entry.getValue() >= trainsOfStation.size())) {
          trainsOfStation.forEach(train -> train.removeStation(station));
          toRemove.add(station);
        }
      }
      trainsOfStation.clear();
    }
    toRemove.forEach(allUniqueStations::remove);

    List<Train> res = new ArrayList<>();

    for (Train train : trains) {
      Set<Station> filteredStation = new HashSet<>();
      for (Station station : train.getStations()) {
        if (allUniqueStations.contains(station)) {
          filteredStation.add(station);
        }
      }

      Train newTrain = new Train(filteredStation);
      res.add(newTrain);
    }
    return res;
  }
}
