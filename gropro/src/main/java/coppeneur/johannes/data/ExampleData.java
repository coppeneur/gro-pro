package coppeneur.johannes.data;
/**
 * @author Johannes Coppeneur
 */
public class ExampleData {

  private final double x;
  private final double y;

  public ExampleData(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public String toString() {
    return "data.ExampleData{" + "x=" + x + ", y=" + y + "}";
  }
}
