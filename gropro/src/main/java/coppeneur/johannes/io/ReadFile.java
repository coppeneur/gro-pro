package coppeneur.johannes.io;

import coppeneur.johannes.data.Station;
import coppeneur.johannes.data.Train;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Johannes Coppeneur
 */
public class ReadFile implements Input {

    private File file;

    public ReadFile(String filename) throws FileNotFoundException {
        this.file = new File(filename);
        System.out.println(file.getPath());
        if (!this.file.isFile()) {
            throw new FileNotFoundException(String.format("file: %s not found", filename));
        }
        // TODO no write accessx
//    if(!this.file.canRead()){
//      throw new File
//    }
    }

    @Override
    public List<Train> readInput() throws IOException {

        List<Train> trains = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int trainCount = 1;

            while ((line = reader.readLine()) != null) {
                if (line.length() == 0) {
//                    System.out.println("Empty line: " + line);
                    continue;
                }
                // remove comment
                if (line.startsWith("#")) {
//                    System.out.println("Kommentar: " + line);
                    continue;
                }
                String[] stationsArray = line.split(";");
                trains.add(new Train(new HashSet<>(Arrays.stream(stationsArray).collect(Collectors.toSet())), String.valueOf(trainCount)));
                trainCount++;
            }
            // mach etwas mit dem file name
            // int measurementNum = Integer.parseInt(filename.substring(0, filename.indexOf(".txt")));

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return trains;
    }
}
