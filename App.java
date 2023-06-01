package week5;

public class App {

	public static void main(String[] args) {
		Logger asterisks = new AsteriskLogger();
		Logger spaces = new SpacedLogger();
		
		asterisks.log("Today");
		asterisks.error("Asterisks");
		asterisks.close();

		spaces.log("Tomorrow");
		spaces.error("Spaced");
		spaces.close();


		
		
		

	}

}
