package coppeneur.johannes.algorithm.reduction;

import coppeneur.johannes.data.Train;

import java.util.ArrayList;
import java.util.List;

/**
 *     <p>Strategy to reduce the amount of stations Rule: If all trains stopping at station A also
 *     stop at station B, then station A may be removed from the set of stations (and from the list
 *     of all train stops). We note that all trains stopping at DA also stop at H. According to the
 *     rule for data reduction technique 2 we are allowed to remove DA from all train connections.
 *     However, the statement cannot be reversed. That all trains stopping in H also stop in DA does
 *     not apply here. Accordingly, only station DA (and not H) may be removed.
 */
public class TrainReductionStrategy implements ReductionStrategy {
  @Override
  public List<Train> reduce(List<Train> trains) {

    List<Train> toRemove = new ArrayList<>();
    for (int i = 0; i < trains.size(); i++) {
      for (int j = i + 1; j < trains.size(); j++) {

        if (trains.get(i).getStations().size() > trains.get(j).getStations().size()) {
          if (trains.get(i).getStations().containsAll(trains.get(j).getStations())) {
            toRemove.add(trains.get(i));
          }
        } else {
          if (trains.get(j).getStations().containsAll(trains.get(i).getStations())) {
            toRemove.add(trains.get(j));
          }
        }
      }
    }
    trains.removeAll(toRemove);
    return trains;
  }
}
