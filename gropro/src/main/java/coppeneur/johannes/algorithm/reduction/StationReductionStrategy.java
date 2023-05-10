package coppeneur.johannes.algorithm.reduction;

import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;
import coppeneur.johannes.util.Util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Johannes Coppeneur
 * <p>
 * Strategy to Reduce the amount of stations in a List of train routes.
 * Rule: If train 1 stops at all stations where train 2 stops, then train 1 may be removed from the list of trains.
 */
public class StationReductionStrategy implements ReductionStrategy {
    @Override
    public List<Train> reduce(List<Train> trains) {

        List<Station> toRemove = new ArrayList<>();

        // unique stationen
        Set<Station> allUniqueStations = trains.stream()
                .flatMap(train -> train.getStations().stream())
                .collect(Collectors.toSet());

        for (Station station : allUniqueStations) {

            // Liste aller Trains von einer Station
            List<Train> trainsOfStation = new ArrayList<>();
            for (Train train : trains) {
                if (train.getStations().contains(station)) {
                    trainsOfStation.add(train);
                }
            }

            // alle stationen der Zuege der stationen
            List<Station> allStationsOfListOfTrains = trainsOfStation.stream()
                    .flatMap(train -> train.getStations().stream())
                    .toList();

            Map<Station, Integer> stationOccurences = Util.countFrequencies(allStationsOfListOfTrains);

//            // TODO

            // geht von der ursprungs station, die stationen aller züge und davon die occ durch
            // wenn die occ gleich oder größer sind dann ist loesch das ursprungs element
            // ABER NICHT WENN ES DIE GLEICHE STATION IST
            // ES MUSS DIE STATION GELOESCHT WERDEN DA DIE ANDEREN AUCH HAEUFIGER DRAN KOMMEN KOENNTEN

            for (Map.Entry<Station, Integer> entry : stationOccurences.entrySet()) {
                if (entry.getKey().equals(station)) {
                    continue;
                }
                if ((entry.getValue() >= trainsOfStation.size())) {
                    trainsOfStation.forEach(train -> train.removeStation(station));
                    toRemove.add(station);
                }
            }
//            trainsOfStation.clear();
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

//        System.out.println(res);
        return res;
    }


//    private static Map<String, Integer> countFrequencies(List<String> list) {
//        // hashmap to store the frequency of element
//        Map<String, Integer> hm = new HashMap<String, Integer>();
//
//        for (String i : list) {
//            Integer j = hm.get(i);
//            hm.put(i, (j == null) ? 1 : j + 1);
//        }
//
//        // displaying the occurrence of elements in the arraylist
////        for (Map.Entry<String, Integer> val : hm.entrySet()) {
////            System.out.println("Element " + val.getKey() + " "
////                    + "occurs"
////                    + ": " + val.getValue() + " times");
////        }
//
//        return hm;
//
//    }

}
