package coppeneur.johannes.util;

import coppeneur.johannes.data.Train;

import java.util.*;

/**
 * Class which contains a Method to find the minimum of Servicestations of a given List of Trains
 *
 * @author Johannes Coppeneur
 */
public class Solver {

    /**
     * Method to get the Minimum service-stations of a List of Train with a greedy approach
     *
     * @param trains List of trains
     * @return List of Strings, with the names of the Service-points
     */
    public List<String> getMinServiceStation(List<Train> trains) {

        List<String> serviceStations = new ArrayList<>();

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

        return serviceStations;
    }

}
