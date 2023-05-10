package coppeneur.johannes.util;

import coppeneur.johannes.data.Station;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johannes Coppeneur
 *     <p>Utility Class
 */
public class Util {

  // private constructor to hide the real
  private Util(){

}

  /**
   * Method to count the frequencies of all Strings in a List.
   *
   * @param list of Strings to be counted
   * @return returns HashMap of Strings and their frequencies
   */
  public static Map<Station, Integer> countFrequencies(List<Station> list) {
    // hashmap to store the frequency of element
    Map<Station, Integer> hm = new HashMap<>();

    for (Station i : list) {
      Integer j = hm.get(i);
      hm.put(i, (j == null) ? 1 : j + 1);
    }

    return hm;
  }
}
