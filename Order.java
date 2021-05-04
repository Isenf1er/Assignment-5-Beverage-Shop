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

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderNo;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	
	public Order(int time, DAY od, Customer c) {
		orderNo = genOrderNum();
		orderTime = time;
		orderDay = od;
		customer = c;
		beverages = new ArrayList<>();
	}
	
	public int genOrderNum() {
		Random rand = new Random();
		int rn = rand.nextInt(90_000-10_000) + 10_000;
		return rn;
	}
	
	public String toString() {
		String orderDetails = "____________________________" + orderDay.toString() + ", " + orderNo;
		for(Beverage b : beverages) {
			orderDetails += "\n" + b.toString();
		}
		orderDetails += "\n Order Total: " + calcOrderTotal();
		return orderDetails;
	}
	
	public boolean isWeekend() {
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Beverage getBeverage(int itemNum) {
		return beverages.get(itemNum);
	}
	
	public int compareTo(Order o) {
		if(orderNo == o.getOrderNo()) {
			return 0;
		}
		else if(orderNo > o.getOrderNo()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public double calcOrderTotal() {
		double orderTotal = 0;
		for(Beverage b : beverages) {
			orderTotal += b.calcPrice();
		}
		return orderTotal;
	}
	
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		for(Beverage b : beverages) {
			if(b.getType() == type) {
				count++;
			}
		}
		return count;
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	
	public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean proteinPowder) {
		Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);
		beverages.add(s);
	}
	
	public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(name, size, extraShot, extraSyrup);
		beverages.add(c);
	}
	
	public void addNewBeverage(String name, SIZE size) {
		boolean isWeekend = false;
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			isWeekend = true;
		}
		Alcohol a = new Alcohol(name, size, isWeekend);
		beverages.add(a);
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public DAY getOrderDay() {
		return orderDay;
	}
	
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	public ArrayList<Beverage>getBeverages(){
		return beverages;
	}
	
	public void setOrderTime(int time) {
		orderTime = time;
	}
	
	public void setOrderDay(DAY od) {
		orderDay = od;
	}
	
	public void setOrderNum(int no) {
		orderNo = no;
	}
	
	public void setCustomer(Customer c) {
		customer = c;
	}
}

/*
 * Programmer Name: Nicholas Prakoso
 */