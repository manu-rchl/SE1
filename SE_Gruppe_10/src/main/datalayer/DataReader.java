package main.datalayer;

import java.util.ArrayList;

import main.Person;



public class DataReader {
	
	private static DataReader dr;
	private ArrayList<Person> people;
	private ArrayList<Person> dhbw;
	
	public static DataReader getInstance() {
		if(dr == null)
			dr = new DataReader();
		return dr;
	}
	
	public DataReader() {
		people = new ArrayList<>();
		dhbw = new ArrayList<>();
	}
	
	public int loadData(String path) {
		System.out.println("DR loadData");
		people.clear();
		Person p = new Person(1);
		p.setName("Relaxo");
		people.add(p);
		p = new Person(2);
		p.setName("Pikachu");
		people.add(p);
		p = new Person(3);
		p.setName("Enton");
		people.add(p);
		p = new Person(4);
		p.setName("Glumanda");
		people.add(p);
		return 0;
	}
	
	public int loadDataDHBW(String path) {
		System.out.println("DR loadDHBWData");
		dhbw.clear();
		Person p = new Person(1);
		p.setPosition('D');
		p.setArgument(10);
		dhbw.add(p);
		p = new Person(2);
		p.setPosition('S');
		p.setArgument(1.2);
		dhbw.add(p);
		p = new Person(4);
		p.setPosition('S');
		p.setArgument(3.0);
		dhbw.add(p);
		return 0;
	}
	
	public ArrayList<Person> readData() {
		System.out.println("DR readData");
		return people;
	}
	
	public ArrayList<Person> readDataDHBW() {
		System.out.println("DR readDataDHBW");
		return dhbw;
	}

}