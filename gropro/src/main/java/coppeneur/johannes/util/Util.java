package coppeneur.johannes.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Johannes Coppeneur
 */
public class Util{

    public static Map<String, Integer> countFrequencies(List<String> list) {
        // hashmap to store the frequency of element
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for (String i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }

        // displaying the occurrence of elements in the arraylist
//        for (Map.Entry<String, Integer> val : hm.entrySet()) {
//            System.out.println("Element " + val.getKey() + " "
//                    + "occurs"
//                    + ": " + val.getValue() + " times");
//        }

        return hm;

    }

}
