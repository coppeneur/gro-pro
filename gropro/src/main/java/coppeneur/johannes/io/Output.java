package coppeneur.johannes.io;

import coppeneur.johannes.data.Measurement;

public interface Output {
  void writeFile(Measurement measurement);
}
