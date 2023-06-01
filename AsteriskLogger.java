package week5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AsteriskLogger implements Logger{
	
	private BufferedWriter writeAsterisks;
	
	public AsteriskLogger() {
		
		//The try catch block tests if the code throws an exception and if it does, it prints out the Stack Trace
		try { 
			//Initializes the BufferedWriter and FileWriter objects and specifies that the data passed to the methods will be appended to the logAsterisk text file
			writeAsterisks = new BufferedWriter(new FileWriter("logAsterisk.txt")); 
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}

	@Override
	public void log(String log) { 
		
		//The String passed into the log method is appended to the logsAsterisk text file with 3 asterisks before and after the String
		try {
			writeAsterisks.append("***" + log + "***");
			writeAsterisks.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void error(String error) { 
		
		try {
			writeAsterisks.newLine();
			String string = "***Error: " + error + "***";
			
			//Appends Strings of asterisks that have the same length as the variable string to the logsAsterisk text file  
			for (int i = 0; i < string.length(); i++ ) {
				writeAsterisks.append("*");
			}
			
			//Appends the value of the string variable to the logsAsterisk text file in its own line
			writeAsterisks.newLine();
			writeAsterisks.append(string);
			writeAsterisks.newLine();
			
			//Appends Strings of asterisks that have the same length as the variable string to the logsAsterisk text file
			for (int i = 0; i < string.length(); i++ ) {
				writeAsterisks.append("*");
			} 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void close() {
		
		//Closes the writer on the logAsterisk text file
		try { 
			writeAsterisks.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
