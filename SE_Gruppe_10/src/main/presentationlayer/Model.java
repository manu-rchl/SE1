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
	}
	
	public ArrayList<Person> getPeopleData() {
		return people;
	}

	public void readDHBWData(ArrayList<Person> readDHBWFile) {
		dhbw = readDHBWFile;
	}
	
	public ArrayList<Person> getDHBWData() {
		return dhbw;
	}
	
}