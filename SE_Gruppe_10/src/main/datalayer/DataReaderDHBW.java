package main.datalayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import main.Person;

public class DataReaderDHBW {
	
	private static DataReaderDHBW dr;
	private ArrayList<Person> dhbw;
	
	public static DataReaderDHBW getInstance() {
		if(dr == null)
			dr = new DataReaderDHBW();
		return dr;
	}
	
	public DataReaderDHBW() {
		dhbw = new ArrayList<>();
	}
	
	public int loadDataDHBW(boolean peopleDataExists, String path) {
		if(!peopleDataExists) {
			return 4;
		}
		Person p = null;
		dhbw.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			if(path.endsWith(".csv")) {
				String line = null;
				String[] values = new String[3];
				while( (line = br.readLine()) != null) {
					values    = line.split(";");
				    p = new Person(Integer.parseInt(values[0]));
				    p.setPosition(values[1].charAt(0));
				    p.setArgument(Double.parseDouble(values[2]));
					
					dhbw.add(p);
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
	
	public ArrayList<Person> readDataDHBW() {
		return dhbw;
	}

}