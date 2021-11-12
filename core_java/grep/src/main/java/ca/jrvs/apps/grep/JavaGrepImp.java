package ca.jrvs.apps.grep;

import java.io.*;
import java.util.*;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.*

public class JavaGrepImp implements JavaGrep {

  final Logger logger = LoggerFactory.getLogger(JavaGrep.class);

  private String regex;
  private String rootPath;
  private String outFile;

  @Override
  public String getRegex() {
    return regex;
  }

  @Override
  public void setRegex(String regex) {
    this.regex = regex;
  }

  @Override
  public String getRootPath() {
    return rootPath;
  }

  @Override
  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  @Override
  public String getOutFile() {
    return outFile;
  }

  @Override
  public void setOutFile(String outFile) {
    this.outFile = outFile;
  }

  public static void main(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException("Usage: JavaGrep regex rootPath outFile");
    }
    
    //Use default logger config
    BasicConfigurator.configure();

    JavaGrepImp javaGrepImp = new JavaGrepImp();
    javaGrepImp.setRegex(args[0]);
    javaGrepImp.setRootPath(args[1]);
    javaGrepImp.setOutFile(args[2]);

    try {
      javaGrepImp.process();
    } catch (Exception ex) {
      javaGrepImp.logger.error("Error: Unable to process", ex);
    }
  }

  /**
   * Top level search workflow
   * @throws IOException
   */
  @Override
  void process() throws IOException {
    List<String> matchedLines = new ArrayList<>();
    for (File file : listFiles(this.rootPath)) {
      for (String line : readLines(file)) {
        if (containsPattern(line)) {
          matchedLines.add(line);
        }
      }
    }
    writeToFile(matchedLines);
  }

  /**
   * Traverse a given directory and return all files
   * @param rootDir input directory
   * @return files under the rootDir
   */
  @Override
  List<File> listFiles(String rootDir) {
    List<File> files = new ArrayList<>();
    if (File(rootDir).listFiles() != null) {
      for (File file : File(rootDir).listFiles()) {
        if (file.isFile()) {
          files.add(file);
        } else if (file.isDirectory()) {
          files.addAll(listFiles(file.getAbsolutePath()));
        }
      }
    }
    return files;
  }

  /**
   * Read a file and return all lines
   * @param inputFile file to be read
   * @return lines
   * @throws IllegalArgumentException if a given inputFile is not a file
   */
  @Override
  List<String> readLines(File inputFile) throws IllegalArgumentException;

  /**
   * check if a line contains the regex pattern (passed by user)
   * @param line input string
   * @return true if there is a match
   */
  @Override
  boolean containsPattern(String line);

  /**
   * Write lines to a file
   * @param lines matched line
   * @throws IOException if write failed
   */
  @Override
  void writeToFile(List<String> lines) throws IOException;
}
