package coppeneur.johannes.io;


import java.util.List;

/**
 * Interface for an output strategie
 */
public interface Output {
  void writeFile(List<String>  list);
}
