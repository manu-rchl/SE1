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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class View extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Controller c;
	private List list;
	
	public View(Controller c) {
		
		this.c = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadPeople = new JButton("Personenkartei laden");
		btnLoadPeople.setBounds(10, 90, 220, 38);
		btnLoadPeople.addActionListener(c.new LoadPersonData());
		contentPane.add(btnLoadPeople);
		
		JButton btnLoadDHBW = new JButton("DHBW-Kartei laden");
		btnLoadDHBW.setBounds(235, 90, 220, 38);
		btnLoadDHBW.addActionListener(c.new LoadDHBWData());
		contentPane.add(btnLoadDHBW);
		
		list = new List();
		list.setBounds(10, 134, 445, 360);
		contentPane.add(list);
		
		JLabel lblNewLabel = new JLabel("DHBW-Personen-Kartei");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 445, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bitte erst eine Personenkartei ausw\u00E4hlen, dann eine DHBW-Kartei");
		lblNewLabel_1.setBounds(10, 47, 377, 32);
		contentPane.add(lblNewLabel_1);
		
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
		JOptionPane.showMessageDialog(this,s);
		
	}
}