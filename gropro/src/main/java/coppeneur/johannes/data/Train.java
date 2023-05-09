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

    // TODO Erweiterbarkeit ist besser gegeben wenn Station eine Klasse wird
    // TODO HashFunktion überschreiben damit compare klappt
    // TODO Liste von Map von String zu Station

    private String name;
    // TODO GEREON HELP PLS
//    private Set<Station> stations;

    public Train(Set<String> stations) {
        this.stations = stations;
    }

    public Train(Set<String> stations, String name) {
//        this.stations = stations.stream().map(String::new).collect(Collectors.toSet());
        this.stations = new HashSet<>(stations);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getStations() {
        return stations;
    }

    public void setStations(Set<String> stations) {
        this.stations = stations;
    }

    public void removeStation(String station) {
        this.stations.remove(station);
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
