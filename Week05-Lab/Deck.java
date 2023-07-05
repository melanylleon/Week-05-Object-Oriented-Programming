package week5;

import java.util.List; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * A class used to create a deck of cards, describe the deck, shuffle the cards, and draw a card from the top of the deck.
 */

public class Deck {
	
	//Represents the deck of cards
	List<Card> cards = new ArrayList<Card>();
	
	List<String> suits = Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades");
	List<String> names = Arrays.asList("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace");
	
	
	//Constructor that instantiates 52 cards using the suits and names lists and adds them to the cards list
	public Deck() {
		for (int suitsCounter = 0; suitsCounter < suits.size(); suitsCounter++) {  
				int valueCounter = 2;
				while (valueCounter < 15) {
					//Adds the cards to the cards list. It creates a deck of 52 cards.
					cards.add(new Card(names.get(valueCounter - 2), suits.get(suitsCounter), valueCounter));
					valueCounter++;
				}
		}
	}
	
	//Prints the description of the 52 cards in the deck
	public void describe() {
		for (Card card : this.cards) {
			card.describe();
		}
	}
	
	//Shuffles the cards in the deck
	public void shuffle() {
		Collections.shuffle(this.cards);
		
	}
	
	//Removes the top card in the deck
	public Card draw() {
		Card card = this.cards.remove(0);
		return card;
	}
}
