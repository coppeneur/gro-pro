package coppeneur.johannes.util;

import coppeneur.johannes.data.Train;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Johannes Coppeneur
 * <p>
 * Represents reduction technique 2
 */
public class StationReductionStrategy implements ReductionStrategy {
    @Override
    public List<Train> reduce(List<Train> trains) {

        // alle stationen
        List<String> allStations = trains.stream()
                .flatMap(train -> train.getStations().stream())
                .toList();

        List<String> toRemove = new ArrayList<>();

        // unique stationen
        Set<String> allUniqueStations = trains.stream()
                .flatMap(train -> train.getStations().stream())
                .collect(Collectors.toSet());

        for (String station : allUniqueStations) {

            // Liste aller Trains von einer Station
            List<Train> trainsOfStation = new ArrayList<>();
            for (Train train : trains) {
                if (train.getStations().contains(station)) {
                    trainsOfStation.add(train);
                }
            }

            // alle stationen der Zuege der stationen
            List<String> allStationsOfListOfTrains = trainsOfStation.stream()
                    .flatMap(train -> train.getStations().stream())
                    .toList();

            Map<String, Integer> stationOccurences = Util.countFrequencies(allStationsOfListOfTrains);

// RICHTIG ???
//            System.out.println(station);
//            System.out.println(trainsOfStation);
//            System.out.println(stationOccurences.entrySet().stream().filter(e -> e.getValue() >= trainsOfStation.size()).toList());
//            long count = stationOccurences.entrySet().stream().filter(e -> e.getValue() >= trainsOfStation.size()).count();
//            System.out.println("Count: " + count + " bool " + String.valueOf(count != 1));
//            boolean remove =  count != 1;
//            if (remove) {
//                trainsOfStation.forEach(train -> train.removeStation(station));
//                toRemove.add(station);
//            }

//            // TODO

            // geht von der ursprungs station, die stationen aller züge und davon die occ durch
            // wenn die occ gleich oder größer sind dann ist loesch das ursprungs element
            // ABER NICHT WENN ES DIE GLEICHE STATION IST
            // ES MUSS DIE STATION GELOESCHT WERDEN DA DIE ANDEREN AUCH HAEUFIGER DRAN KOMMEN KOENNTEN

            for (Map.Entry<String, Integer> entry : stationOccurences.entrySet()) {
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

            Set<String> filteredStation = new HashSet<>();

            for (String station : train.getStations()) {
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
