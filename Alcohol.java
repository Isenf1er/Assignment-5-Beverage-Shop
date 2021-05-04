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

public class Alcohol extends Beverage {
	private boolean isWeekend;
	private final double WEEKEND_FEE = 0.6;
	
	public Alcohol(String n, SIZE s, boolean iw) {
		super(n, TYPE.ALCOHOL, s);
		isWeekend = iw;
	}
	
	public double calcPrice() {
		double price = super.getSizePrice();
		
		if(super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		}
		else if(super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		if(isWeekend) {
			price += WEEKEND_FEE;
		}
		return price;
	}
	
	public String toString() {
		String description = getBevName() + ", " + getSize();
		
		if(isWeekend) {
			description += " Weekend";
		}
		description += ", $" + calcPrice();
		return description;
	}
	
	public boolean equals(Alcohol a) {
		if(super.equals(a) && isWeekend == a.getIsWeekend()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean getIsWeekend() {
		return isWeekend;
	}
	
	public double getWeekendFee() {
		return WEEKEND_FEE;
	}
	
	public void setIsWeekend(boolean i) {
		isWeekend = i;
	}
}

/*
 * Programmer Name: Nicholas Prakoso
 */