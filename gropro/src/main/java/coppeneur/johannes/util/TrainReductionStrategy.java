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

        System.out.println(trains);
        List<Train> toRemove = new ArrayList<>();

//        System.out.println(trains);

        HashSet<Station> set1 = new HashSet<Station>();
        // Use add() method
        set1.add(new Station("M"));
        set1.add(new Station("DA"));
        set1.add(new Station("H"));
        set1.add(new Station("S"));
        set1.add(new Station("K"));
        System.out.println("HashSet 1: "
                + set1);

        HashSet<Station> set2 = new HashSet<Station>();
        // Use add() method
        set2.add(new Station("DA"));
        set2.add(new Station("H"));
        System.out.println("HashSet 2: "
                + set2);
        //use hashset.containsAll method
        System.out.println("\nDoes set 1 contain set 2: "
                + set1.containsAll(set2));

        for (int i = 0; i < trains.size(); i++) {
            Train trainA = trains.get(i);
            for (int j = i + 1; j < trains.size(); j++) {
                Train trainB = trains.get(j);

                if (trainB.getStations() instanceof HashSet<String>) {
                    int hier = 1;
                }
                if (trains.get(i) == trains.get(j)) {
                    continue;
                }

                if (trains.get(i).getStations().size() > trains.get(j).getStations().size()) {

//                    if (trainA.contains(trainB.getStations())) {
//                        int here = 1
//                    }

                    if (trains.get(i).getStations().containsAll(trains.get(j).getStations())) {
                        toRemove.add(trains.get(i));
                    }
                } else if (trains.get(i).getStations().size() < trains.get(j).getStations().size()) {

                    if (trains.get(j).getStations().containsAll(trains.get(i).getStations())) {
                        toRemove.add(trains.get(j));
                    }

                } else {
                    // bei gleicher länge müssen sie identisch sein sonst ist es quatsch
                }
            }
        }

        trains.removeAll(toRemove);

        return trains;
    }
}
