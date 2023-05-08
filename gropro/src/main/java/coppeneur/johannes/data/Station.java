package coppeneur.johannes.data;

import java.util.Objects;

/**
 * @author Johannes Coppeneur
 */
public class Station {

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Station: %s", this.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Station)) {
            return false;
        }
        Station otherObject = (Station) obj;
        return Objects.equals(this.getName(), otherObject.getName());
    }

}
