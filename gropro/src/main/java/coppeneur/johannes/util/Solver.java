package coppeneur.johannes.util;

import coppeneur.johannes.data.Train;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Johannes Coppeneur
 */
public class Solver {

    List<String> serviceStations = new ArrayList<>();

    public List<String> getMinServiceStation(List<Train> trains) {


        while (!trains.isEmpty()) {

            List<String> allStations = trains.stream()
                    .flatMap(train -> train.getStations().stream())
                    .toList();

            Optional<Map.Entry<String, Integer>> mostFrequentStation = Util.countFrequencies(allStations).entrySet().stream().max(Map.Entry.comparingByValue());

            if (mostFrequentStation.isEmpty()) {
                System.out.println("mostFrequentStation ist Empty. Kann das sein?");
            }

            String currenServiceStation;
            currenServiceStation = mostFrequentStation.map(Map.Entry::getKey).orElse(null);
            serviceStations.add(currenServiceStation);
            trains = trains.stream().filter(train -> !train.getStations().contains(currenServiceStation)).toList();
        }

        // alle stationen

//        Map<String, Long> stationCountMap = allStations.stream()
//                .collect(Collectors.groupingBy(station -> station, Collectors.counting()));
//
//        Optional<Map.Entry<String, Long>> mostFrequentStation =
//                stationCountMap.entrySet().stream()
//                        .max(Map.Entry.comparingByValue());
//
//
//        if (mostFrequentStation.isPresent()) {
//            List<Train> toRemove = new ArrayList<>();
//            for (Train train : trains) {
//
//                if (train.getStations().contains(mostFrequentStation.get())) {
//                    toRemove.add(train);
//                }
//
//            }
//            trains.removeAll(toRemove);
//        }
//
//        serviceStations.add(mostFrequentStation.get().getKey().toString());
//
//        // TODO wieder aufrufen?
        return serviceStations;
    }

}
