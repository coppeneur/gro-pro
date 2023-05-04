package coppeneur.johannes.io;

import coppeneur.johannes.data.Measurement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Johannes Coppeneur
 */
public class WriteFile implements Output {

  private static final String FILE_HEADER = "HEADER";

  @Override
  public void writeFile(Measurement measurement) {
    String output = getOutputString(measurement);
    String filename = "out{0}.txt";

    try {
      File file = new File("out/" + filename);
      file.getParentFile().mkdirs();
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writer.write(output);
      writer.close();
    } catch (IOException e) {
      System.out.println(e.toString());
      throw new RuntimeException(e);
    }
  }

  private String getOutputString(Measurement measurement) {
    StringBuilder outputString = new StringBuilder(FILE_HEADER);

    return outputString.append("\n\n").append(measurement.toString()).toString();
  }
}
