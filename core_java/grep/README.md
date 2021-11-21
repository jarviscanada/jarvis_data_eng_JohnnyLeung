# Introduction
(50-100 words)
Discuss the design of each app. What does the app do? What technologies have you used? (e.g. core java, libraries, lambda, IDE, docker, etc..)


# Quick Start
How to use your apps? 

#Implemenation
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
(30-60 words)
Discuss the memory issue and how would you fix it

# Test
How did you test your application manually? (e.g. prepare sample data, run some test cases manually, compare result)

# Deployment
How you dockerize your app for easier distribution?

# Improvement
- Correct the performance issue, perhaps by using more memory-efficient methods and techniques, such as using loops instead of recursion
- Provide the ability to additionally specify and use `grep` options, such as `-i` (ignore case) and `-n` (precede each matching line with a line number)
- Since this is a single-threaded program, performance can be improved by implementing multithreading
