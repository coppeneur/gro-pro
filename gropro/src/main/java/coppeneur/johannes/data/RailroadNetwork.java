package coppeneur.johannes.data;

import java.util.List;

/**
 * The RailroadNetwork class represents List of Trains.
 * Stations are Strings.
 *
 * @author Johannes Coppeneur
 */
@Deprecated
public class RailroadNetwork {

    List<Train> trains;

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public RailroadNetwork(List<Train> trains) {
        this.trains = trains;
    }
}
