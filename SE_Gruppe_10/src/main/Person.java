package main;

public class Person {

	private int id;
	private String name;
	private char position;
	private double arg;
	
	public Person(int id) {
		this.id = id;
		name = null;
		position = ' ';
		arg = 0;
	}
	
	public void setPosition(char position) {
		this.position = position;
	}
	
	public char getPosition() {
		return position;
	}
	
	public void setArgument(double arg) {
		this.arg = arg;
	}
	
	public double getArgument() {
		return arg;
	}
	
	public int getID() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return this.id + " - " + this.getName() + " | Position: " + this.getPosition() + ", Arg: " + this.getArgument();
	}
	
}