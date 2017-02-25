# Java-Reflection-And-Object-Comparison

o Review the sample input file below to determine the data members and design a Java class, First, in the following way:

    	data members
    	double DoubleValue;
    	int IntValue;
    	... // similarly for the other data members
    	empty constructor
    	define the public method void setIntValue(int iIn) {... }
    	define the public method void setDoubleValue(double dIn) {... }
    	... // similarly for the other data members
o Review the sample input file below to determine the data members and design a Java class, Second, in the following way:
	  
    	data members
    	double DoubleValue;
    	int IntValue;
    	... // similarly for the other data members
    	empty constructor
    	define the public method void setIntValue(int iIn) {... }
    	define the public method void setDoubleValue(double dIn) {... }
    	... // similarly for the other data members

o Define a class PopulateObjects that has data structures (as data members) to store instances of First and Second. Choose the data structure(s) that are efficient to determine the total number of non-duplicate object instances, and the total number of object instances (includes duplicates).

o PopulateObjects should have a method deserObjects(...) to read data member values from an inputFile and accordingly create instances of First and Second. Decide the appropriate return value and parameters for the method deserObjects

o In First and Second, override equals and hashCode, with annotation, appropriately.

o You can design additional methods in PopulateObjects as needed.

o The class FileProcessor should be used to read one line at a time from the file.

o The input file will have data in the following format (note that the order of first and second is random. So, you have to read the fqn value to determine if what follows is a serialized format of first or second

       fqn:genericDeser.util.First
       type=int, var=IntValue, value=17
    	type=float, var=FloatValue, value=19.3
    	type=short, var=ShortValue, value=9
    	type=String, var=StringValue, value=abc
    	fqn:genericDeser.util.Second
    	type=int, var=IntValue, value=19
    	type=double, var=DoubleValue, value=3.14
    	type=boolean, var=BooleanValue, value=false
    	fqn:genericDeser.util.Second
    	type=int, var=IntValue, value=199
    	type=double, var=DoubleValue, value=33.14
    	type=boolean, var=BooleanValue, value=false
  
o Use java reflection ( newInstance method) to create an object using the value given for fqn. Please note that fqn is an abbreviation for Fully Quallified Class Name.

o Populate the data structures with instances of First and Second.

o Read the following link about boxed primitives, Integer.TYPE, and Integer.class in the context of Java reflection.
o Generalize the above code so it works for both First and Second objects. For example, you need to set signature[0] value by looking up a map that returns "Integer.TYPE" for the key "int".

o Populate the data structure in PopulateObjects class withe instances of First and Second that are read from the file.

o Design and implement methods in the PopulateObjects class to return the number of non-duplicate instances of First and Second.

o Design and implement methods in the PopulateObjects class to return the total number of instances of First and Second.

o The Driver code should call the PopulateObjects class to populate the data structures and print output on the number of objects.

o So, your final output will be 4 lines:

    	Number of unique First objects: 17
    	Total Number of First objects: 29
    	Number of unique Second objects: 19
    	Total Number of Second objects: 31

• The following should be read from command line (in this order): input file name, the value of NUM_ITERATIONS, and DEBUG_VALUE. The input file should be read from the same folder as "build.xml".

• Your code should work when run in the following way. So, do NOT use hardcoded arguments in the build.xml file.

• ant run -Darg0=input.txt -Darg1=iterations -Darg2=0

• Use the Logger class along with your own debug scheme. The DEBUG_VALUE=0 should be reserved for just printing the 5 output lines shown above.
