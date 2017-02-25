package genericDeser.util;

import genericDeser.fileOperations.FileProcessor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-12-10
 * 
 */
public class PopulateObjects {

	private Map<First, Integer> fMap;
	private Map<Second, Integer> sMap;
	private Map<String, Class<?>> map;
	private FileProcessor fp;
	
	/**
	 * Constructor of the PopulateObjects class
	 * @param fpIn The file processor object
	 */
	public PopulateObjects(FileProcessor fpIn) {
		fp = fpIn;
		fMap = new HashMap<First, Integer>();
		sMap = new HashMap<Second, Integer>();
		map = new HashMap<String, Class<?>>();
		initializeMap(map);
		
		Logger.writeMessage("Constructor of PopulateObjects class", DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Initializes the map with signatures and their types
	 * @param map The map to initialize
	 */
	private void initializeMap(Map<String, Class<?>> map) {
		map.put("int", Integer.TYPE);
		map.put("float", Float.TYPE);
		map.put("short", Short.TYPE);
		map.put("String", String.class);
		map.put("double", Double.TYPE);
		map.put("boolean", Boolean.TYPE);
	}

	/**
	 * Reads data member values from an inputFile and 
	 * accordingly creates instances of First and Second
	 */
	public void deserObjects() {
		String line = null;
		Class<?> cls = null;
		Object obj = null;
		
		// Read the file line by line
		while((line = fp.readInputFile()) != null) {
			if ((!isEmpty(line)) && (!isBlank(line))) {
					
				// Check if line has a fqn
				if (line.toLowerCase().matches("(?s).*\\bfqn\\b.*")) {
					String clsName = line.replaceAll("(\\s*)fqn(\\s*):(\\s*)","");
					try {
						obj = putObject(obj);
						
						// Get class name and create instance
						cls = Class.forName(clsName);
						obj = cls.newInstance();				
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						System.exit(1);
					} catch (InstantiationException e) {
						e.printStackTrace();
						System.exit(1);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
						System.exit(1);
					}
				} else if (line.toLowerCase().matches("(?s).*\\btype\\b.*\\bvar\\b.*\\bvalue\\b.*")) {
					obj = invokeMethod(line, cls, obj);					
				}
			}
		}
		// Put the last object in the map
		obj = putObject(obj);
	}

	/**
	 * Invokes specific methods on the current object.
	 * 
	 * @param line Current line
	 * @param cls Class name
	 * @param obj Current object
	 * @return obj
	 */
	private Object invokeMethod(String line, Class<?> cls, Object obj) {
		
		Object[] params = new Object[1];
		Method method = null;
		
		// Split the line to get type and var
		String[] token = line.split(",\\s+");
		String type = token[0].replaceAll("(\\s*)type(\\s*)=(\\s*)", "").trim();
		String var = token[1].replaceAll("(\\s*)var(\\s*)=(\\s*)", "").trim();
		
		// Get the method name and signature
		String methodName = "set" + var;
		Class<?>[] signature = new Class<?>[1]; 
		signature[0] = map.get(type);
		
		// Assign the value to appropriate type
		if (type.equalsIgnoreCase("int")) {
			params[0] = Integer.parseInt(token[2].replaceAll("(\\s*)value(\\s*)=(\\s*)", ""));	
		} else if (type.equalsIgnoreCase("float")) {
			params[0] = Float.parseFloat(token[2].replaceAll("(\\s*)value(\\s*)=(\\s*)", ""));
		} else if (type.equalsIgnoreCase("short")) {
			params[0] = Short.parseShort(token[2].replaceAll("(\\s*)value(\\s*)=(\\s*)", ""));
		} else if (type.equalsIgnoreCase("double")) {
			params[0] = Double.parseDouble(token[2].replaceAll("(\\s*)value(\\s*)=(\\s*)", ""));
		} else if (type.equalsIgnoreCase("boolean")) {
			params[0] = Boolean.parseBoolean(token[2].replaceAll("(\\s*)value(\\s*)=(\\s*)", ""));
		} else if (type.equalsIgnoreCase("String")) {
			params[0] = token[2].replaceAll("(\\s*)value(\\s*)=", "");
		}
		
		try {	
			// Get method and invoke the method
			method = cls.getMethod(methodName, signature);
			method.invoke(obj, params[0]);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SecurityException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			Logger.writeMessage("Method " + methodName + " invoked", DebugLevel.INVOKE);
		}
		return obj;
	}
	
	/**
	 * Puts an object in the HashMap
	 *  
	 * @param obj The object to be inserted
	 * @return obj
	 */
	private Object putObject(Object obj) {
		
		// Check if obj is instance of First
		if (obj instanceof First) {
			if(fMap.containsKey((First)obj)) {
				int fCount = fMap.get((First)obj);
				fMap.put((First)obj, fCount +1);
			} else {
				fMap.put((First) obj, 1);
				Logger.writeMessage("Entry added to data structure", DebugLevel.INSERT);
			}

		//	Check if obj is instance of Second
		} else if (obj instanceof Second) {
			if(sMap.containsKey((Second)obj)) {
				int sCount = sMap.get((Second)obj);
				sMap.put((Second)obj, sCount +1);
			} else {
				sMap.put((Second) obj, 1);
				Logger.writeMessage("Entry added to data structure", DebugLevel.INSERT);
			}
		}
		return obj;
	}
	
	/**
	 * Counts the total number of objects for each class
	 */
	public void countObjects() {
		
		int fCount = 0, sCount = 0;
		
		// Get total number of First objects
		for (Map.Entry<First, Integer> entry : fMap.entrySet()) {
			fCount += entry.getValue();
			Logger.writeMessage("Key = " + entry.getKey() + ", Value = " + entry.getValue(), DebugLevel.DISPLAY);
		}
		
		// Get total number of Second objects
		for (Map.Entry<Second, Integer> entry : sMap.entrySet()) {
			sCount += entry.getValue();
			Logger.writeMessage("Key = " + entry.getKey() + ", Value = " + entry.getValue(), DebugLevel.DISPLAY);
		}
		
		// Write output to screen
		Logger.writeMessage("Number of unique First objects: " + fMap.size(), DebugLevel.DEFAULT);
		Logger.writeMessage("Total Number of First objects: " + fCount, DebugLevel.DEFAULT);
		Logger.writeMessage("Number of unique Second objects: " + sMap.size(), DebugLevel.DEFAULT);
		Logger.writeMessage("Total Number of Second objects: " + sCount, DebugLevel.DEFAULT);
	}
	
	/**
	 * This method returns true if line is blank, else false.
	 * 
	 * @param line Current line
	 * @return line
	 */
	public boolean isBlank(String line) {
		return line.matches("\\s*");
	}

	/** 
	 * This method returns true if length() is 0, else false.
	 * 
	 * @param line Current line
	 * @return line
	 */
	public boolean isEmpty(String line) {
		return line.isEmpty();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PopulateObjects [fMap=" + fMap + ", sMap=" + sMap + ", map="
				+ map + ", fp=" + fp + "]";
	}
}