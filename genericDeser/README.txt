CS542 Design Patterns
Fall 2016
PROJECT <5> README FILE

Due Date: <PROJECT DUE DATE, IN FORMAT: Thursday, December 15, 2016>
Submission Date: <DATE YOU SUBMIT, IN FORMAT: Thursday, December 15, 2016>
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <ABHISHEK NIRANJAN UPASANI>
e-mail(s): <aupasan1@binghamton.edu>

PURPOSE:

[
  The purpose of this project is to understand and implement the Reflection and Object Comparision
  in Java.
  
]

PERCENT COMPLETE:

[
  "I believe I have completed 100% of this project."
]

PARTS THAT ARE NOT COMPLETE:

[
  None
]

BUGS:

[
  None
]

FILES:

[
  Included with this project are 9 files:

  Driver.java, the main file associated with the program
  PopulateObjects.java, the file associated with implementing actual reflection algorithm
  First.java, the file associated with the First Class
  Second.java, the file associated with the Second Class
  DebugLevel.java, the file associated with Logger values
  Logger.java, the file associated with debugging
  FileProcessor.java, the file associated with file reading and writing
  build.xml, the file associated with cleaning, compiling and running the code
  README.txt the text file you are presently reading
]

SAMPLE OUTPUT:

[
  [java] Number of unique First objects: 4952
  [java] Total Number of First objects: 4952
  [java] Number of unique Second objects: 5018
  [java] Total Number of Second objects: 5048
]

TO UNTAR:
[
  tar -xvf upasani_abhishek_assign5.tar.gz
]

TO COMPILE:

[
  ant -buildfile build.xml all
]

TO RUN:

[
  ant -buildfile build.xml run  -Darg0=<input_file> -Darg1=<DEBUG_VALUE>
]

TO GENERATE JAVADOCS:

[
  ant -buildfile build.xml docs
]

CHOICE OF DATA STRUCTURES:

[
  HashMap with keys as objects and their corresponding values as the object counts. Preferred HashMap as 
  we do not need any sorted order and HashMap does not allow duplicates. 
  
  Iterating over a HashMap requires O(n) time where n is the number of unique objects stored in HashMap.
]

EXTRA CREDIT:

[
  "N/A" 
]


BIBLIOGRAPHY:

[
  For exception handling in reading and writing files
  https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
  
  For generating Javadocs using ANT
  http://javabeat.net/javadoc-ant-task/
  
  For serializing the input
  https://www.tutorialspoint.com/java/java_string_replaceall.htm
  https://www.tutorialspoint.com/java/java_string_matches.htm 
]

ACKNOWLEDGEMENT:

[
  None
]