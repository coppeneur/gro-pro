package coppeneur.johannes.io;

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

    /**
     * //TODO DEFAULT? FILE NAME
     * Object of File to be read.
     */
    private static final String LINE_REGEX = "^(?:[a-zA-Z]+;)+[a-zA-Z]*$";
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
     * Returns a List of Trains which is located in the specified file.
     * Duplicate Stations of a train route will be removed.
     *
     * @return List of Trains
     * @throws IOException Throws an exception if the file cannot be found or opened
     */
    @Override
    public List<Train> readInput() throws IOException {

        List<Train> trains = new ArrayList<>();


        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.length() == 0) {
//                    System.out.println("Empty line: " + line);
                continue;
            }
            line = line.trim();
            // remove comment
            if (line.startsWith(COMMENT_PATTERN)) {
//                    System.out.println("Kommentar: " + line);
                continue;
            }
            if (line.matches(LINE_REGEX)) {
                String[] stationsArray = line.split(";");
                trains.add(new Train(new HashSet<>(Arrays.stream(stationsArray).collect(Collectors.toSet()))));
            }
        }
        if (trains.isEmpty()) {
            throw new IOException(String.format("No trains found in file: %s", file.getName()));
        }

        return trains;
    }
}
