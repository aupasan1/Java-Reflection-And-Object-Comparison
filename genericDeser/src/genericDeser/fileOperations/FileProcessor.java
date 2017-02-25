package genericDeser.fileOperations;

import genericDeser.util.DebugLevel;
import genericDeser.util.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Abhishek Niranjan Upasani
 * @version 1.0
 * @since 2016-12-10
 * 
 */
public class FileProcessor {

	private FileReader fr;
	private BufferedReader br;

	/**
	 * Constructor of the File processor class
	 * @param frIn FileReader object
	 */
	public FileProcessor(FileReader frIn) {

		fr = frIn;
		br = new BufferedReader(fr);

		Logger.writeMessage("Constructor of FileProcessor class", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This method reads a single line from a file
	 * @return line
	 */
	public String readInputFile(){

		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			
		}
		
		return line;
	}
	
	
	/**
	 * This method closes any open files 
	 */
	public void closeFile() {
		try {
			if (br != null) {
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileProcessor [fr=" + fr + ", br=" + br + "]";
	}
}