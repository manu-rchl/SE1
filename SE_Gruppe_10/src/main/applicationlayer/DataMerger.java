package main.applicationlayer;

import java.util.ArrayList;

import main.Person;
import main.datalayer.DataReaderPeople;
import main.datalayer.DataReaderDHBW;

public class DataMerger {
	
	private static DataMerger dm;
	private ArrayList<Person> people;
	private ArrayList<Person> dhbw;
	
	public static DataMerger getInstance() {
		if(dm == null)
			dm = new DataMerger();
		return dm;
	}

	public ArrayList<Person> readPeopleFile() {
		people = DataReaderPeople.getInstance().readData();
		return people;
	}

	public int loadPeopleFile(String absolutePath) {
		return DataReaderPeople.getInstance().loadData(absolutePath);
	}

	public ArrayList<Person> readDHBWFile() {
		dhbw = DataReaderDHBW.getInstance().readDataDHBW();
		return mergeLists(people, dhbw);
	}

	public int loadDHBWFile(String absolutePath) {
		boolean peopleDataExists = false;
		if(people != null)
			peopleDataExists = true;
		return DataReaderDHBW.getInstance().loadDataDHBW(peopleDataExists, absolutePath);
	}
	
	public ArrayList<Person> mergeLists(ArrayList<Person> allPeople, ArrayList<Person> DHBWData) {
		ArrayList<Person> dhbw = new ArrayList<>();
		for(Person d : DHBWData) {
			for(Person p : people) {
				if(p.getID() == d.getID()) {
					Person dhbwPerson = new Person(p.getID());
					dhbwPerson.setName(p.getName());
					dhbwPerson.setPosition(d.getPosition());
					dhbwPerson.setArgument(d.getArgument());
					dhbw.add(dhbwPerson);
				}
			}
		}
		return dhbw;
	}

}