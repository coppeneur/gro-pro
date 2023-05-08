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
                .collect(Collectors.toList());

        // unique stationen
        Set<String> allUniqueStations = trains.stream()
                .flatMap(train -> train.getStations().stream())
                .collect(Collectors.toSet());

        for (String station : allUniqueStations) {

            List<String> zuege = new ArrayList<>();
            for (Train train : trains) {
                if (train.getStations().contains(station)) {
                    zuege.add(train.toString());
                }
            }

            HashMap<String, List<String>> stationTrain = new HashMap<>();

        }

        for (int i = 0; i < allUniqueStations.size(); i++) {

            List<String> stationAtrains = sta

            for (int j = i + 1; j < allUniqueStations.size(); j++) {

                if()

            }

        }


        int count = Collections.frequency(allStations, "apple");
        System.out.println(count);

//        allStations.stream().

        System.out.println(allStations);

        for (String station : allStations) {

            int stationCount = 0;

            for (Train train : trains) {

                if (train.getStations().contains(station)) {
                    stationCount++;
                }

            }

        }

//        System.out.println("Lösung gefunden");

        return null;
    }
}
