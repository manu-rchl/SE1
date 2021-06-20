package main;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		if(p1.getName().compareTo(p2.getName()) != 0){
		return p1.getName().compareTo(p2.getName());
		}
		if(p1.getID() - p2.getID() !=0) {
			return p1.getID() - p2.getID();
		}
		return 0;
	}
	
}
