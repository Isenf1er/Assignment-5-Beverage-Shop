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

public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double SYRUP_COST = 0.5;
	private final double SHOT_COST = 0.5;
	
	public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
		super(n, TYPE.COFFEE, s);
		extraShot = shot;
		extraSyrup = syrup;
	}
	
	public double calcPrice() {
		double price = super.getBasePrice();
		if(super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		}
			else if(super.getSize() == SIZE.LARGE) {
				price += 2 * super.getSizePrice();
			}
		if(extraShot) {
			price += SHOT_COST;
		}
		if(extraSyrup) {
			price += SYRUP_COST;
		}
		return price;
	}
	
	public boolean equals(Coffee c) {
		if(super.equals(c) && extraShot == c.getExtraShot() && extraSyrup == c.getExtraSyrup()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String description = getBevName() + ", " + getSize();
		if(extraShot) {
			description += " Extra shot";
		}
		description += ", $" + calcPrice();
		return description;
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public double getShotCost() {
		return SHOT_COST;
	}
	
	public double getSyrupCost() {
		return SYRUP_COST;
	}
	
	public void setExtraShot(boolean shot) {
		extraShot = shot;
	}
	
	public void setExtraSyrup(boolean syrup) {
		extraSyrup = syrup;
	}
}

/*
 * Programmer Name: Nicholas Prakoso
 */