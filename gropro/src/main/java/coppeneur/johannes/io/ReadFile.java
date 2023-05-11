package coppeneur.johannes.io;

import coppeneur.johannes.data.RailroadNetwork;
import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Reads text files and passes the List of Trains.
 *
 * @author Johannes Coppeneur
 */
public class ReadFile implements Input {

  /** //TODO DEFAULT? FILE NAME Object of File to be read. */

  /**
   * Regex der Zeilen mit gewollten Pattern erkennt
   */
  private static final String LINE_REGEX = "^[a-zA-ZÄÖÜäöüß]+(\\s*;\\s*[a-zA-ZÄÖÜäöüß]+)+\\s*;?$";

  private static final String COMMENT_PATTERN = "#";
  private File file;

  /**
   * Constructor.
   *
   * @param filename Name of the file to be read
   * @throws FileNotFoundException if the File is not Found
   */
  public ReadFile(String filename) throws IOException {
    this.file = new File(filename);
    System.out.println(file.getPath());
    if (!this.file.isFile()) {
      throw new FileNotFoundException(String.format("file: %s not found", filename));
    }
    if (!this.file.canRead()) {
      throw new IOException(String.format("Can't access file: %s", filename));
    }
  }

  /**
   * Returns a List of Trains which is located in the specified file. Duplicate Stations of a train
   * route will be removed.
   *
   * @return List of Trains
   * @throws IOException Throws an exception if the file cannot be found or opened
   */
  @Override
  public RailroadNetwork readInput() throws IOException {

    List<Train> trains = new ArrayList<>();

    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;

    while ((line = reader.readLine()) != null) {
      line = line.strip();
      if (line.isBlank()) {
        //                    System.out.println("Empty line: " + line);
        continue;
      }
      // remove comment
      if (line.startsWith(COMMENT_PATTERN)) {
        //                    System.out.println("Kommentar: " + line);
        continue;
      }
      if (line.matches(LINE_REGEX)) {
        String[] stationsArray = line.split(";");

        trains.add(new Train(Arrays.stream(stationsArray).map(String::strip).map(Station::new).collect(Collectors.toCollection(HashSet::new))));
      } else {
        throw new IOException(
            String.format("Wrong format in line: %s and file %s", line, file.getName()));
      }
    }
    if (trains.isEmpty()) {
      throw new IOException(String.format("No trains found in file: %s", file.getName()));
    }

    return new RailroadNetwork(trains);
  }
}
