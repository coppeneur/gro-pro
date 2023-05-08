package coppeneur.johannes.util;

import coppeneur.johannes.data.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Johannes Coppeneur
 */
public class Solver {

    List<String> serviceStations = new ArrayList<>();

    public List<String> getServiceStation(List<Train> trains) {

        if (trains.isEmpty()) {
            return serviceStations;
        }

        // alle stationen
        List<String> allStations = trains.stream()
                .flatMap(train -> train.getStations().stream())
                .toList();

        Map<String, Long> stationCountMap = allStations.stream()
                .collect(Collectors.groupingBy(station -> station, Collectors.counting()));

        Optional<Map.Entry<String, Long>> mostFrequentStation =
                stationCountMap.entrySet().stream()
                        .max(Map.Entry.comparingByValue());


        if (mostFrequentStation.isPresent()) {
            List<Train> toRemove = new ArrayList<>();
            for (Train train : trains) {

                if (train.getStations().contains(mostFrequentStation.get())) {
                    toRemove.add(train);
                }

            }
            trains.removeAll(toRemove);
        }

        serviceStations.add(mostFrequentStation.get().getKey().toString());

        // TODO wieder aufrufen?

    }

}
