package coppeneur.johannes.io;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Johannes Coppeneur
 */
public class WriteFile implements Output {

  private static final String FILE_HEADER = "HEADER";
  private final File file;

  public WriteFile(String path) throws IOException {
    this.file = new File(path);
    // create output dir
    // if(new File("out"))
    if (file.getParentFile() == null) {

    }
    file.getParentFile().mkdirs();
    file.createNewFile();
//    if (!file.isFile()) {
//      throw new IOException(String.format("%s is not a file", this.file.getPath()));
//    }
    if (!file.canWrite()) {
      throw new IOException(String.format("Denied write access to %s", this.file.getPath()));
    }
  }

  @Override
  public void writeFile(List<String> strings) {
//    String output = getOutputString(measurement);
    String filename = "out{0}.txt";

//    try {
//      this.file.getParentFile().mkdirs();
//      BufferedWriter writer = new BufferedWriter(new FileWriter(this.file));
//      writer.write(strings.size());
//      writer.close();
//    } catch (IOException e) {
//      System.out.println(e.toString());
//      throw new RuntimeException(e);
//    }
  }

//  private String getOutputString(Measurement measurement) {
//    StringBuilder outputString = new StringBuilder(FILE_HEADER);
//
//    return outputString.append("\n\n").append(measurement.toString()).toString();
//  }
}
