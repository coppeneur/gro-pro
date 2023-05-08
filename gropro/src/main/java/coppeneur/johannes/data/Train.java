package coppeneur.johannes.data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Johannes Coppeneur
 */
public class Train {

    private Set<Station> stations;

    public Train(HashSet<Station> stations) {
        this.stations = stations;
    }

    public Train(Set<String> stations) {
        this.stations = stations.stream().map(Station::new).collect(Collectors.toSet());
    }

    public Set<Station> getStations() {
        return stations;
    }

    public void setStations(HashSet<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Train{" + "\nStations=" + stations + "\n}";
    }

    public boolean contains(Set<Station> subset) {
        return subset.stream().allMatch(station -> this.stations.contains(station.getName()));
    }

//    public boolean contains(Set<Station> stationsToCompare) {
//
//        stationsToCompare.t
//
//    }
}
