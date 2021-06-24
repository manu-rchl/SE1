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
		String p = null;
		String a = null;
		if(this.position == 'S') {
			p = "Student:in";
			a = "Notendurchschnitt";
		} else {
			p = "Dozent:in";
			a = "Anzahl Vorlesungen";
		}
		if(this.arg == 0)
			return this.id + "\t - "+this.getName();
		else if(this.name == null){
			return this.id + "\t"+" - "+p+":\t"+a+": "+this.arg; 
		} else {
			return this.id + "\t"+" - "+this.getName()+"\t | "+p+" - \t"+a+": "+this.arg; 
		}
	}
	
}