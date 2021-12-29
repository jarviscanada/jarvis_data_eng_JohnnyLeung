# Introduction
The purpose of this application is to replicate the Linux `grep` command, which recursively searches for a specified text pattern in files in a given directory and outputs matched lines to a file.

There are two different implementations:
1. `JavaGrepImp` uses loops, BufferedReader, and BufferedWritter to read and write files
2. `JavaGrepLambdaImp` uses lambda expressions and Stream APIs to achieve the same functionality

Technology used:
- IntelliJ IDE with JUnit testing
- Regex
- List and ArrayList
- BufferedReader and BufferedWriter
- Lambda expressions
- Stream APIs
- Maven was used for packaging the application into a JAR file
- A Docker image of the application was made and is available on Docker Hub

# Quick Start
The application takes three arguments:
- `regex`: a special text string for describing a search pattern
- `rootPath`: the root directory path
- `outFile`: the output file

There are two different ways to run this application:
1. Using the JAR file:
```
#Package the java app
mvn clean package
#Run the JAR file
java -jar target/grep-1.0-SNAPSHOT.jar regex rootPath outFile
```
2. Using the Docker image on Docker Hub:
```
#Pulls the Docker image from Docker Hub
docker pull johnnyleung/grep
#Runs local Docker container
docker run --rm -v `pwd`/data:/data -v `pwd`/out:/out johnnyleung/grep regex rootPath outFile
```

# Implemenation
## Pseudocode
```
matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
writeToFile(matchedLines)
```

## Performance Issue
The Java heap is the area of memory used to store objects instantiated by applications running on the JVM. An `OutOfMemoryError` exception occurs when the heap size is smaller than the size of the root directory. 

The List data structure can get very large in this application if a file has many lines. Since the application first stores text from files as a List before processing, the problem can be fixed by using Stream APIs to process files instead of a List. Streams help fix the memory issue because they allow elements to be computed on demand and do not store data.

Another option is to incrase the maximum heap size by using the `-Xmx` option.

# Test
Sample data was generated and inputted as arguments into the application manually. This data included different root directory paths, file names, and regex strings. The final version was was tested using a directory with many files and nested subdirectories that also contained many files. By comparing the application's generated results with the results of the actual `grep` command, verifying correctness was straightforward.

# Deployment
In order to make distribution easier, the application was packaged into a Docker image before being uploaded to Docker Hub. A Dockerfile was used to build the image from the openjdk:8-jdk-alpine image and copy over the compiled jar file.

# Improvement
- Provide the ability to omit certain files or certain subdirectories, for example, files/directories that are larger than a certain size, or that contain certain words in their name
- Provide the ability to additionally specify and use `grep` options, such as `-i` (ignore case) and `-n` (precede each matching line with a line number)
- Since this is a single-threaded program, performance can be improved by implementing multithreading
