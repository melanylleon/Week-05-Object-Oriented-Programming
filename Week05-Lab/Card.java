package week5;

/*
 * A class that creates playing cards and describes them. A card has a name (Two through Ace), a suit, and the value of the card.
 * The class also has getters and setters to get and set the values of the fields in the class.
 * 
 */

public class Card {
	
	String name;
	String suit;
	int value;
	
	//Constructor that initializes the fields of this class to create a card
	public Card(String name, String suit, int value) {
		this.name = name;
		this.suit = suit;
		this.value = value;
	}

	//Describes a card by it's name, suit and value
	public void describe() {
		System.out.println(this.name + " of " + this.suit + " - " + value);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
