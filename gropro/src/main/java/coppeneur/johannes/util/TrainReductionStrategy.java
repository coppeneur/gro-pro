package coppeneur.johannes.util;

import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author Johannes Coppeneur
 * <p>
 * Represents reduction technique 3
 */
public class TrainReductionStrategy implements ReductionStrategy {
    @Override
    public List<Train> reduce(List<Train> trains) {

        List<Train> toRemove = new ArrayList<>();

        for (int i = 0; i < trains.size(); i++) {
            Train trainA = trains.get(i);
            for (int j = i + 1; j < trains.size(); j++) {
                Train trainB = trains.get(j);

//                if (trains.get(i) == trains.get(j)) {
//                    continue;
//                }

                if (trains.get(i).getStations().size() > trains.get(j).getStations().size()) {

//                    if (trainA.contains(trainB.getStations())) {
//                        int here = 1
//                    }

                    if (trains.get(i).getStations().containsAll(trains.get(j).getStations())) {
                        toRemove.add(trains.get(i));
                    }
                } else {
//                    if (trains.get(i).getStations().size() < trains.get(j).getStations().size()) {

                    if (trains.get(j).getStations().containsAll(trains.get(i).getStations())) {
                        toRemove.add(trains.get(j));
                    }

                }
            }
        }

        trains.removeAll(toRemove);
//        System.out.println("after " + trains);

        return trains;
    }
}
