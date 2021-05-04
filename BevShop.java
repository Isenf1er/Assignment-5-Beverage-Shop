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

public class BevShop implements BevShopInterfce {
	private int numOfAlcoholInOrder;
	private int currentOrderId;
	private ArrayList<Order> orders;
	
	public BevShop() {
		orders = new ArrayList<>();
	}
	
	public String toString() {
		String sentence = "Monthly Orders\n";
		for(Order o : orders) {
			sentence += o.toString();
		}
		sentence += "Total Sale: " + totalMonthlySale();
		return sentence;
	}
	
	public boolean validTime(int time) {
		if(time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean validAge(int age) {
		if(age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean eligibleForMore() {
		if(numOfAlcoholInOrder < 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isMaxFruit(int num) {
		if(num > MAX_FRUIT) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrderId = orders.indexOf(order);
		numOfAlcoholInOrder = 0;
	}
	
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		orders.get(currentOrderId).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrderId).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentOrderId).addNewBeverage(bevName, size);
		numOfAlcoholInOrder++;
	}
	
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}
	
	public double totalOrderPrice(int orderNo) {
		double orderSale = 0;
		for(Order o : orders) {
			if(o.getOrderNo() == orderNo) {
				for(Beverage b : o.getBeverages()) {
					orderSale += b.calcPrice();
				}
			}
		}
		return orderSale;
	}
	
	public double totalMonthlySale() {
		double totalSale = 0;
		for(Order o : orders) {
			for(Beverage b : o.getBeverages()) {
				totalSale += b.calcPrice();
			}
		}
		return totalSale;
	}
	
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	public void sortOrders() {
		for(int i = 0; i < orders.size() - 1; i++) {
			int minOrderNumId = i;
			for(int k = i + 1; k < orders.size(); k++) {
				if(orders.get(k).getOrderNo() < orders.get(minOrderNumId).getOrderNo()) {
					minOrderNumId = k;
				}
			}
			Order temp = orders.get(minOrderNumId);
			orders.set(minOrderNumId, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	public Order getCurrentOrder() {
		return orders.get(currentOrderId);
	}
	
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholInOrder;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
}

/*
 * Programmer Name: Nicholas Prakoso
 */