package main.presentationlayer;

import java.util.ArrayList;

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
		test();
	}
	
	public void test() {
		DataMerger.getInstance().loadPeopleFile("");
		model.readPeopleData(DataMerger.getInstance().readPeopleFile());
		view.printPeople(model.getPeopleData());
		DataMerger.getInstance().loadDHBWFile("");
		model.readDHBWData(DataMerger.getInstance().readDHBWFile());
		ArrayList<Person> people = model.getDHBWData();
		System.out.println("Fertige DHBW Daten ("+people.size()+")");
		for(Person p : people) {
			System.out.println(p.toString());
		}
		view.printDHBW(model.getDHBWData());
	}
//	
//    public class LoadPeopleData implements ActionListener {
//	   
//	   public LoadPeopleData() { }
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			JFileChooser chooser = new JFileChooser();
//			chooser.setCurrentDirectory(new java.io.File("."));
//			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//			chooser.setAcceptAllFileFilterUsed(false);
//			/*
//			 * HIER EINFÜGEN, NUR CSV DATEIEN LESEN
//			 */
//			int rueckgabeWert = chooser.showOpenDialog(null);
//			if(rueckgabeWert == JFileChooser.APPROVE_OPTION){
////				view.printLog("Wahlverzeichnis geladen: '"+chooser.getSelectedFile().getName()+"'.");
//				int i = DataMerger.getInstance().loadPeopleFile(chooser.getSelectedFile().getAbsolutePath());
////				convertLogMessageFromReader(i);
//				model.readPeopleData(DataMerger.getInstance().readPeopleFile());
////				view.loadComboBoxContent(model.getDistrictNames());
////				if(i != 0) {
////					view.clear();
////				} else {
////					loadData();
////					printData();
////				}
//			}
		
//		}
 
//    }

}