package main.presentationlayer;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Person;
import main.NameComparator;
import main.DHBWComparator;


@SuppressWarnings("deprecation")
public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Controller c;
	private List list;
	
	public View(Controller c) {
		
		this.c = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadPeople = new JButton("Personenkartei laden");
		btnLoadPeople.setBounds(10, 11, 150, 23);
		btnLoadPeople.addActionListener(c.new LoadPersonData());
		contentPane.add(btnLoadPeople);
		
		JButton btnLoadDHBW = new JButton("DHBW-Kartei laden");
		btnLoadDHBW.setBounds(170, 11, 150, 23);
		btnLoadDHBW.addActionListener(c.new LoadDHBWData());
		contentPane.add(btnLoadDHBW);
		
		list = new List();
		list.setBounds(10, 40, 308, 255);
		contentPane.add(list);
		
	}
	
	
	public void printPeople(ArrayList<Person> list) {
		list.sort(new NameComparator());
		this.list.removeAll();
		for(Person p : list) {
			this.list.add(p.toString());
		}
	}
	
	public void printDHBW(ArrayList<Person> list) {
		list.sort(new DHBWComparator());
		this.list.removeAll();
		for(Person p : list) {
			this.list.add(p.toString());
		}
	}

	public void showErrorPopup(String s) {
		JOptionPane.showInternalMessageDialog(this,s);
		
	}
	

}