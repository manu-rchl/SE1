package main;

import java.util.Comparator;

public class DHBWComparator implements Comparator<Person>{
	
	@Override
	public int compare(Person p1, Person p2) {
		if(Character.getNumericValue(p1.getPosition()) - Character.getNumericValue(p2.getPosition()) != 0) {
			if(p1.getPosition() == 'S')
				return -1;
			else 
				return 1;
			
		}
		if(p1.getPosition() == 'S') {
			if(p1.getArgument() < p2.getArgument()) {
				return -1;
			}else if(p1.getArgument() > p2.getArgument()) {
				return 1;				
			}
			if(p1.getName().compareTo(p2.getName()) != 0) {
				return p1.getName().compareTo(p2.getName());
			}
			if(p1.getID() - p2.getID() != 0) {
				return p1.getID() - p2.getID();
			}
		
		}else if(p1.getPosition() == 'D')
			if(p1.getArgument() - p2.getArgument() != 0) {
				return (int) (p2.getArgument() - p1.getArgument());
			}
			if(p1.getName().compareTo(p2.getName()) != 0) {
				return p1.getName().compareTo(p2.getName());
			}
			if(p1.getID() - p2.getID() != 0) {
				return p1.getID() - p2.getID();
			}
		
		return 0;
	}
	
}
