package main.datalayer;

import java.util.ArrayList;

import main.Person;



public class DataReader {
	
	private static DataReader dr;
	private ArrayList<Person> dhbw;
	
	public static DataReader getInstance() {
		if(dr == null)
			dr = new DataReader();
		return dr;
	}
	
	public DataReader() {
		dhbw = new ArrayList<>();
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
		p = new Person(5);
		p.setPosition('S');
		p.setArgument(3.4);
		dhbw.add(p);
		p = new Person(6);
		p.setPosition('S');
		p.setArgument(5.0);
		dhbw.add(p);
		p = new Person(7);
		p.setPosition('D');
		p.setArgument(80);
		dhbw.add(p);
		p = new Person(8);
		p.setPosition('D');
		p.setArgument(1);
		dhbw.add(p);
		p = new Person(9);
		p.setPosition('D');
		p.setArgument(10);
		dhbw.add(p);
		return 0;
	}
	

	public ArrayList<Person> readDataDHBW() {
		System.out.println("DR readDataDHBW");
		return dhbw;
	}

}