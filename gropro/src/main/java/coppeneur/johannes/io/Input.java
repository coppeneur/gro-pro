package coppeneur.johannes.io;

import coppeneur.johannes.data.Measurement;

import java.io.IOException;

/**
 * Interface for an input strategy.
 *
 * @author Johannes Coppeneur
 */
public interface Input {

  Measurement readInput() throws IOException;
}
