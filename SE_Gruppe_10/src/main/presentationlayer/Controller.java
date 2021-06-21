package main.presentationlayer;

import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Person;
import main.applicationlayer.DataMerger;

public class Controller {

	private View view;
	private Model model;
	private static Controller controller;
	
	private Controller() {
		model = Model.getInstance();
	}

	public static Controller getInstance() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	
	public View getView() {
		return view;
	} 
	 
	public Model getModel() {
		return model;
	}
	
	public void startApplication() {
		view = new View(this);
		view.setVisible(true);
//		test();
	}
	
	public void printError(int i) {
		if(i == 1) {
			view.showErrorPopup("Die Datei beinhaltet falsche Werte!");
		} else if(i == 2) {
			view.showErrorPopup("Die Datei konnte nicht geöffnet werden!");
		} else if(i == 3) {
			view.showErrorPopup("Die Datei konnte nicht gefunden werden!");
		} else if(i == 4) {
			view.showErrorPopup("Keine Personenkartei geladen. Bitte wähle erst eine Personenkartei aus!");
		} 
	}
	
//	public void test() {
//		DataMerger.getInstance().loadPeopleFile("");
//		model.readPeopleData(DataMerger.getInstance().readPeopleFile());
//		view.printPeople(model.getPeopleData());
//		DataMerger.getInstance().loadDHBWFile("");
//		model.readDHBWData(DataMerger.getInstance().readDHBWFile());
//		ArrayList<Person> people = model.getDHBWData();
//		System.out.println("Fertige DHBW Daten ("+people.size()+")");
//		for(Person p : people) {
//			System.out.println(p.toString());
//		}
//		view.printDHBW(model.getDHBWData());
//	}
	
	public class LoadPersonData implements ActionListener{
		
		public LoadPersonData() {}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			chooser.showDialog(null, ".csv Datei auswählen");
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setAcceptAllFileFilterUsed(false);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.addChoosableFileFilter(new FileNameExtensionFilter(".csv", "csv", "CSV Datei", "CSV File"));
			int rueckgabeWert = chooser.showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				int success = DataMerger.getInstance().loadPeopleFile(chooser.getSelectedFile().getAbsolutePath());
				printError(success);
				model.readPeopleData(DataMerger.getInstance().readPeopleFile());
				view.printPeople(model.getPeopleData());
			}
			
		}
	}
	
	public class LoadDHBWData implements ActionListener{
		
		public LoadDHBWData() {}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			chooser.showDialog(null, ".csv Datei auswählen");
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setAcceptAllFileFilterUsed(false);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.addChoosableFileFilter(new FileNameExtensionFilter(".csv", "csv", "CSV Datei", "CSV File"));
			int rueckgabeWert = chooser.showOpenDialog(null);
			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
				int success = DataMerger.getInstance().loadDHBWFile(chooser.getSelectedFile().getAbsolutePath());
				printError(success);
				if(success != 4) {
					model.readDHBWData(DataMerger.getInstance().readDHBWFile());
					view.printDHBW(model.getDHBWData());
				}
			}
			
			
		}
	}

}