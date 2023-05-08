package coppeneur.johannes.util;

import coppeneur.johannes.data.Train;

import java.util.List;

/**
 * @author Johannes Coppeneur
 */
public interface ReductionStrategy {

    List<Train> reduce(List<Train> trains);
}
