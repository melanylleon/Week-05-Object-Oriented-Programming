package week5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SpacedLogger implements Logger{
	
	private BufferedWriter writeSpaced;
	
	public SpacedLogger() {
		
		//The try catch block tests if the code throws an exception and if it does it prints out the Stack Trace
		try {
			//Initializes the BufferedWriter and FileWriter objects and specifies that the data passed to the methods will be appended to the logSpaced text file
			writeSpaced = new BufferedWriter(new FileWriter("logSpaced.txt"));  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void log(String write) {
		
		//Saves each character of the String write to the array of characters
		char[] stringToChar = write.toCharArray();
				
		//Concatenates each character of the array of characters along with a space in between each one and saves the concatenated String to the write variable
		write = "";
		for (char c : stringToChar) {
			write = write.concat(c + " ");
		}
				
		//Appends the concatenated String to the logSpaced text file
		try {
			writeSpaced.append(write);
			writeSpaced.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void error(String error) {
		
		//Appends the String "Error: " to the logSpaced text file
		try {
			writeSpaced.append("Error: ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
	 	//Calls the log() method and passes the String error to it. The log method appends the String with spaces in between each character to the logSpaced text file
		log(error); 
		
	}
	
	@Override
	public void close() {
		
		//Closes the writer on the logSpaced text file
		try {
			writeSpaced.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
