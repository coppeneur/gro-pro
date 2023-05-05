package coppeneur.johannes.io;

import coppeneur.johannes.data.ExampleData;
import coppeneur.johannes.data.Measurement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Coppeneur
 */
public class ReadFile implements Input {

  private String filename;

  public ReadFile(String filename) {
    this.filename = filename;
  }

  @Override
  public Measurement readInput(String filename) throws IOException {

    List<ExampleData> exampleData = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;

      while ((line = reader.readLine()) != null) {
        if (line.length()==0){
          System.out.println("Empty line: " + line);
          continue;
        }
        // remove comment
        if (line.startsWith("#")) {
          System.out.println("Kommentar: " + line);

          continue;
        }
        String[] yx = line.split("\\s+");
        exampleData.add(new ExampleData(Integer.parseInt(yx[1]), Integer.parseInt(yx[0])));
      }
      // mach etwas mit dem file name
      //int measurementNum = Integer.parseInt(filename.substring(0, filename.indexOf(".txt")));

    } catch (IOException e) {
      System.out.println(e.toString());
    }

    return new Measurement(exampleData);
  }
}
