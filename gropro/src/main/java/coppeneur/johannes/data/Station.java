package coppeneur.johannes.data;

import java.util.Objects;

public class Station {

    // TODO MAYBE RECORD ?

  private final String name;

    public Station(String name){
    this.name = name;
}

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station station)) return false;
        return Objects.equals(getName(), station.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

}
