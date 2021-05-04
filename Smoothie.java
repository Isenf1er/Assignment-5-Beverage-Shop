/* 
* Class: CMSC203 
* Instructor: Ahmed Tarek
* Description: A program that tests order activities for one month for the Bradley Beverage Shop.
* Due: 5/3/2021
* Platform/compiler: Eclipse
* I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Nicholas Prakoso
*/

public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean addProtein;
	private final double FRUIT_COST = 0.5;
	private double PROTEIN_COST = 1.5;
	
	public Smoothie(String n, SIZE s, int fruits, boolean protein) {
		super(n, TYPE.SMOOTHIE, s);
		numOfFruits = fruits;
		addProtein = protein;
	}
	
	public double calcPrice() {
		double price = super.getBasePrice();
		if(super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		}
		else if(super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		price += numOfFruits * FRUIT_COST;
		if(addProtein) {
			price += PROTEIN_COST;
		}
		return price;
	}
	
	public String toString() {
		String description = getBevName() + ", " + getSize() + " " + numOfFruits + " Fruits";
		if(addProtein) {
			description += " Protein powder";
		}
		description += ", $" + calcPrice();
		return description;
	}
	
	public boolean equals(Smoothie s) {
		if(super.equals(s) && numOfFruits == s.getNumOfFruits() && addProtein == s.getAddProtein()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	public double getFruitCost() {
		return FRUIT_COST;
	}
	
	public double getProteinCost() {
		return PROTEIN_COST;
	}
	
	public void setNumOfFruits(int fruits) {
		numOfFruits = fruits;
	}
	
	public void setProteinPowder(boolean protein) {
		addProtein = protein;
	}
}

/*
 * Programmer Name: Nicholas Prakoso
 */