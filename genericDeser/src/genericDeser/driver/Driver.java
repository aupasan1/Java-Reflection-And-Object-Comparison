package genericDeser.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-12-10
 * 
 */
public class Driver {
	
	private static String inputFile;
	private static int DEBUG_VALUE;
	
	/**
	 * Driver code to run the program
	 * @param args the argument set
	 */
	public static void main(String[] args) {

		//Validate the arguments
		if(!validate(args)) {
			System.err.println("Usage: java Driver input.txt DEBUG_VALUE");
			System.exit(1);
		} else {
			FileReader fr = null;
			FileProcessor fp = null;
			
			try {
				
				// Instantiate the file processor
				fr = new FileReader(inputFile);
				fp = new FileProcessor(fr);
				
				// Populate the data structures with instances of First and Second
				PopulateObjects pObj = new PopulateObjects(fp);
				pObj.deserObjects();
				pObj.countObjects();
			} catch (FileNotFoundException e) {
				System.err.println("Unable to open file '" + inputFile + "'");
				System.exit(1);
			} finally {
				fp.closeFile();
			}			
		}
	}
	
	/**
	 * 
	 * This function validates the command line arguments
	 * 
	 * @param args
	 * @return flag
	 */
	private static boolean validate(String[] args) {
		boolean flag = true;
		
		//Validate the command line arguments
		if(args.length != 2) {
			flag = false;
		} else {
			
			//Read the command line arguments
			inputFile = args[0];
			DEBUG_VALUE = Integer.parseInt(args[1]);

			//Validate number of iterations
			if (DEBUG_VALUE < 0) {
				System.err.println("Invalid debug value !!");
				System.exit(1);
			}			
			Logger.setDebugValue(DEBUG_VALUE);
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Driver []";
	}
}