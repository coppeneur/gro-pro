package coppeneur.johannes.util;

import coppeneur.johannes.data.Train;

import java.util.List;

/**
 * Interface of a strategy to reduce the give train data.
 * Redundant data will be removed with the given strategy.
 *
 * @author Johannes Coppeneur
 */
public interface ReductionStrategy {
    // TODO FASSADE - MUSTER ???

    /**
     * Removes redundant data from the List of Trains
     *
     * @param trains List of Trains, Data to be reduced
     * @return Reduced List of Trains
     */
    List<Train> reduce(List<Train> trains);
}
