package week5;

import java.util.List;  
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashMap;

public class Week5OOPLab {

	// This Lab will give you a basic look at creating an Object Oriented Card Game.  
		//		The idea here is to prepare you for your Week 6 Unit Final Project.
		//		There are many ways to implement this Lab, please use the tools that you know,
		//		and go from there.
		// These exercises are intended to be coded in order 1 through 5.
			
		
		public static void main(String[] args) {
		
			
			// A standard deck of playing cards has 52 cards as specified below 
			//		i. There are 4 suits:  Clubs, Diamonds, Hearts, & Spades
			//				
			//	   ii. Each suit has 13 cards:  Two, Three, Four, Five, Six, Seven, 
			//									 Eight, Nine, Ten, Jack, Queen, King & Ace
			//
			//	  iii. Comparing Cards:  When comparing two cards, Ace is high and Two is low.
			//							 to make this easy, a Two will have a value of 2, a
			//							 Three will have a value of 3, ... and an Ace will have
			//							 a value of 14.
			//
		
			
			// 1. Card Class:
			//		Create a class called Card to represent a standard playing card. 
			//		Fields:   The Card class should have the following fields:
			// 			a. name field
			//			b. suit field
			//			c. value field for comparing against other cards.
			//
			//		Methods:  This class can have any useful method.
			//			a. describe() to display the card information to the Console.
			//			b. Getters & Setters 
			//
			System.out.println("\nQuestion 1: Card Class");
			// Add your code here to instantiate a Card
				Card card = new Card("Nine", "Diamonds", 9);
			
			// Call the describe method on the newly instantiated card.
				card.describe(); //Prints the card description
			
			
			
			

			// 2. Deck Class:
			//		Create a class called Deck.
			//		Fields:  This class should have a list of Card field called cards 
			//				 that will hold all the cards in the deck. 
			//			List<Card> cards = new ArrayList<Card>(); 
			//
			//		Constructor: The constructor for the Deck Class should
			// 			instantiate all 52 standard playing cards and add them to the cards list.
			//
			//		Methods:  
			//			a.  describe() to describe the deck to the Console -- 
			//					print out all of the cards in the deck.
			//
			System.out.println("\nQuestion 2: Deck Class");
		    // Add your code here to instantiate a Deck	
		    	Deck deck = new Deck();
		    
		    // Call the describe method on the newly instantiated deck.
		    	deck.describe(); //Prints the descriptions of the 52 cards in the deck
		    
		    
		    
		    
			
			
			// 3. Deck shuffle() Method:
			//		Add a shuffle method within the Deck Class
			System.out.println("\nQuestion 3: Deck shuffle() method");
			// Test your method here
				deck.shuffle(); //Shuffles the cards in the deck
			
			
			// Call the describe method on the newly shuffled deck.
				deck.describe(); //Prints the descriptions of the shuffled cards in the deck 
			
			
			
			// 4. Deck draw() Method:
			//		Add a draw method within the Deck Class
			System.out.println("\nQuestion 4: Deck draw() method");
			// Test your method here
				Card c = deck.draw(); //Draws a card from the deck
				c.describe(); //Describes the card drawn from the deck
			
			
			
			
			
			
			// 5. Create Game Board:
			//		Create and test a method that takes an int as a parameter (representing the
			// 			number of players for a game) and returns a Map<String, List<Card>>
			// 			that represents each player (i.e. "Player 1", "Player 2", etc..) 
			//			and their cards.
			//
			// 			The method should create a new instance of Deck, shuffle it,
			// 			and deal the cards out to the "players" in the Map.
			System.out.println("\nQuestion 5: Create Game");
			// Call your method here

			Map<String, List<Card>> dealCards = dealEachPlayersCards(5);
			Set<String> keys = dealCards.keySet();
			List<String> k = new ArrayList<>(keys);
			int i = 0;
			
			//Prints each player's name and the cards that were dealt to each one of them
			while (i < k.size()) {
				for (List<Card> list : dealCards.values()) { 
						System.out.println(k.get(i) + ": ");  //Prints the player name
						for (Card cards : list) { 
							cards.describe(); //Prints the player's cards
						}
						System.out.println();
						i++;
				}
			}
		}	
			

			
			
	
		
		// Method 5:
		public static Map<String, List<Card>> dealEachPlayersCards(int numOfPlayers) {
			Deck newCardDeck = new Deck();
			Map<String, List<Card>> playersAndCards = new LinkedHashMap<>();
			List<List<Card>> cards = new ArrayList<List<Card>>();
			List<String> players = new ArrayList<>();
			String eachPlayer;

			//Shuffles the cards in the deck
			newCardDeck.shuffle();
			
			//Creates the names of the players and adds them to the players list. Example: "Player 1", "Player 2", ...
			for (int i = 1; i <= numOfPlayers; i++ ) {
				eachPlayer = "Player";
				String p = eachPlayer.concat(" " + Integer.toString(i));
				players.add(p);
				
				cards.add(new ArrayList<Card>());
			}
				
			//Deals the cards to each player
			for (int index = 0; index < 52 / numOfPlayers; index++) {
				for (int indexLists = 0; indexLists < numOfPlayers; indexLists++) {
					cards.get(indexLists).add(newCardDeck.draw());
				}
			}
			
			//Adds the player names and their cards to the Map
			for (int i = 0; i < players.size(); i++) {
					playersAndCards.put(players.get(i), cards.get(i));
			}
			
			//If there are extra cards left over after they have been dealt to the players, it prints the amount left over
			if (52 % numOfPlayers != 0) {
				System.out.println ("There are " + numOfPlayers + " players in the game. After the cards were dealt, there were " + 52 % numOfPlayers + " cards left over in the deck.\n");
			//If there are no cards left over after being dealt to the players, it prints that all cards were dealt
			}else {
				System.out.println("All of the cards have been dealt. \n");
			}
				
			
			return playersAndCards;
		}
}
