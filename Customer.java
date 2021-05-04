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

public class Customer {
	private String name;
	private int age;
	
	public Customer(String n, int a) {
		name = n;
		age = a;
	}
	
	public Customer(Customer c) {
		name = c.getName();
		age = c.getAge();
	}
	
	public String toString() {
		return name + ", " + age + "y/o";
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setAge(int a) {
		age = a;
	}
}

/*
 * Programmer Name: Nicholas Prakoso
 */