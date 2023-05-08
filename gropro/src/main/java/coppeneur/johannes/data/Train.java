package coppeneur.johannes.data;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Johannes Coppeneur
 */
public class Train {

    private Set<String> stations;

    private String name;
    // TODO GEREON HELP PLS
//    private Set<Station> stations;

    public Train(TreeSet<String> stations) {
        this.stations = stations;
    }

    public Train(Set<String> stations, String name) {
        this.stations = stations.stream().map(String::new).collect(Collectors.toSet());
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getStations() {
        return stations;
    }

    public void setStations(HashSet<String> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Train{" + "\nStations=" + stations + "\n}";
    }

//    public boolean contains(Set<Station> subset) {
//        return subset.stream().allMatch(station -> this.stations.contains(station.getName()));
//    }

//    public boolean contains(Set<Station> stationsToCompare) {
//
//        stationsToCompare.t
//
//    }
}
