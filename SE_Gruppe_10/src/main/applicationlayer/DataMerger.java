package main.applicationlayer;

import java.util.ArrayList;

import main.Main;
import main.Person;
import main.datalayer.DataReader;



public class DataMerger extends Main {
	
	private static DataMerger dm;
	private ArrayList<Person> people;
	private ArrayList<Person> dhbw;
	
	public static DataMerger getInstance() {
		if(dm == null)
			dm = new DataMerger();
		return dm;
	}

	public ArrayList<Person> readPeopleFile() {
		System.out.println("DM readPeopleFile");
		people = DataReader.getInstance().readData();
		System.out.println(people.size());
		for(Person p : people) {
			System.out.println(p.toString());
		}
		return people;
	}

	public int loadPeopleFile(String absolutePath) {
		System.out.println("DM loadPeopleFile");
		return DataReader.getInstance().loadData(absolutePath);
	}

	public ArrayList<Person> readDHBWFile() {
		System.out.println("DM readDHBWFile");
		dhbw = DataReader.getInstance().readDataDHBW();
		return mergeLists(people, dhbw);
	}

	public int loadDHBWFile(String absolutePath) {
		System.out.println("DM loadDHBWFile");
		return DataReader.getInstance().loadDataDHBW(absolutePath);
	}
	
	public ArrayList<Person> mergeLists(ArrayList<Person> allPeople, ArrayList<Person> DHBWData) {
		for(Person p : allPeople) {
			System.out.println(p.toString());
		}
		ArrayList<Person> dhbw = new ArrayList<>();
		System.out.println("Merge: People - "+allPeople.size()+", DHBW - "+DHBWData.size());
		for(Person d : DHBWData) {
			System.out.println("D= "+d.getID()+" "+d.getPosition()+" "+d.getArgument());
			for(Person p : people) {
				System.out.println("P= "+p.getID()+" "+p.getName());
				if(p.getID() == d.getID()) {
					System.out.println("Match gefunden:");
					System.out.println(d.toString());
					System.out.println(p.toString());
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