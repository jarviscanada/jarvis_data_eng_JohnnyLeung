package ca.jrvs.apps.grep;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.log4j.BasicConfigurator;

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

    // Use default logger config
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
   * 
   * @throws IOException
   */
  @Override
  public void process() throws IOException {
    List<String> matchedLines = new ArrayList<>();
    for (File file : listFiles(getRootPath())) {
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
   * 
   * @param rootDir input directory
   * @return files under the rootDir
   */
  @Override
  public List<File> listFiles(String rootDir) {
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
  public List<String> readLines(File inputFile) {
    List<String> lines = new ArrayList<String>();
    if (!inputFile.exists()) {
      throw new IllegalArgumentException("inputFile is not a file");
    }
    try {
      BufferedReader br = new BufferedReader(new FileReader(inputFile));
      String line;
      while ((line = br.readLine()) != null) {
	lines.add(line);
      }
      br.close();
    } catch (FileNotFoundException e) {
      logger.error(e.getMessage(), e)
    } catch (IOException e) {
      logger.error(e.getMessage(), e)
    }
    return lines;
  }

  /**
   * check if a line contains the regex pattern (passed by user)
   * 
   * @param line input string
   * @return true if there is a match
   */
  @Override
  public boolean containsPattern(String line) {
    return Pattern.matches(getRegex(), line);
  }

  /**
   * Write lines to a file
   * @param lines matched line
   * @throws IOException if write failed
   */
  @Override
  public void writeToFile(List<String> lines) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(getOutFile()));
    for (String line : lines) {
      bw.write(line);
      bw.newLine();
    }
    bw.close();
  }
}
