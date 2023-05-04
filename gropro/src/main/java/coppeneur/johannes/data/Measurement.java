package coppeneur.johannes.data;

import java.util.List;

/**
 * @author Johannes Coppeneur
 */
public class Measurement {

  private final List<ExampleData> measurementData;

  public Measurement(List<ExampleData> measurementData) {
    this.measurementData = measurementData;
  }

  public List<ExampleData> getData() {
    return measurementData;
  }

  @Override
  public String toString() {
    return "Measurement{" + "measurementData=" + measurementData + '}';
  }
}
