package coppeneur.johannes.io;

import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;

import java.io.IOException;
import java.util.List;

/**
 * Interface for an input strategy.
 *
 * @author Johannes Coppeneur
 */
public interface Input {

  List<Train> readInput() throws IOException;
}
