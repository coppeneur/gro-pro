package coppeneur.johannes.io;

import coppeneur.johannes.data.Station;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 * Writes all desired output into an output file with a certain format.
 *
 * @author Johannes Coppeneur
 */
public class WriteFile implements Output {

  /** File to be written to. */
  private final File file;

  @Override
  public void writeFile(String error) {
    try {
      this.file.getParentFile().mkdirs();
      BufferedWriter writer = new BufferedWriter(new FileWriter(this.file));
      writer.write(error);
      writer.close();
    } catch (IOException e) {
      System.out.println(e.toString());
      throw new RuntimeException(e);
    }
  }

  /**
   * Constructor.
   *
   * @param path path of the file to be written to.
   * @throws IOException Throws an exception if the file cannot be opened.
   */
  public WriteFile(String path) throws IOException {
    this.file = new File(path);

    file.getParentFile().mkdirs();
    file.createNewFile();
    if (!file.isFile()) {
      throw new IOException(String.format("%s is not a file", this.file.getPath()));
    }
    if (!file.canWrite()) {
      throw new IOException(String.format("Denied write access to %s", this.file.getPath()));
    }
  }

  /**
   * Writes all service-points to an output file
   *
   * @param serviceStations List of Station, which contain the name of the service-points
   */
  @Override
  public void writeFile(Set<Station> serviceStations) {
    String output = getOutputString(serviceStations);
    try {
      this.file.getParentFile().mkdirs();
      BufferedWriter writer = new BufferedWriter(new FileWriter(this.file));
      writer.write(output);
      writer.close();
    } catch (IOException e) {
      System.out.println(e.toString());
      throw new RuntimeException(e);
    }
  }

  private String getOutputString(Set<Station> serviceStations) {
    StringBuilder outputString = new StringBuilder();
    outputString
        .append("Anzahl an Servicestationen: ")
        .append(serviceStations.size())
        .append("\n")
        .append("Servicestationen in: ");
    for (Station station : serviceStations) {
      outputString.append(station.getName()).append(";");
    }
    outputString.deleteCharAt(outputString.length() - 1);
    System.out.println(outputString);
    return outputString.toString();
  }
}
