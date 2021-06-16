package main.presentationlayer;

import java.util.ArrayList;

import main.Person;



public class Model {

	public static Model model;
	private ArrayList<Person> people;
	private ArrayList<Person> dhbw;

	public static Model getInstance() {
		if(model == null) {
			model = new Model();
		} 
		return model;
	}

	public void readPeopleData(ArrayList<Person> readPeopleFile) {
		people = readPeopleFile;
		System.out.println("Read People Data "+people.size());
	}
	
	public ArrayList<Person> getPeopleData() {
		System.out.println("Get People Data "+people.size());
		return people;
	}

	public void readDHBWData(ArrayList<Person> readDHBWFile) {
		dhbw = readDHBWFile;
		System.out.println("Read DHBW Data "+dhbw.size());
	}
	
	public ArrayList<Person> getDHBWData() {
		System.out.println("Get DHBW Data "+dhbw.size());
		return dhbw;
	}
	
}