package main.datalayer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.Person;

public class DataReaderPeople {
	
	private static DataReaderPeople dr;
	private ArrayList<Person> people;
	
	public static DataReaderPeople getInstance() {
		if(dr == null)
			dr = new DataReaderPeople();
		return dr;
	}
	
	public DataReaderPeople() {
		people = new ArrayList<>();
	}
	
	public int loadData(String path) {
		Person p = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			if(path.endsWith(".csv")) {
				String line = null;
				String[] values = new String[2];
				while( (line = br.readLine()) != null) {
					values    = line.split(";");
				    p = new Person(Integer.parseInt(values[0]));
				    p.setName(values[1]);
					
					people.add(p);
				}
			}
		} catch (NumberFormatException e) {
			return 1;
		} catch (IOException e) {
			return 2;
		} catch (Exception e) {
			return 3;
		}
			
		return 0;
	}
	
	public ArrayList<Person> readData() {
		return people;
	}

}
