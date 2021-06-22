package main.datalayer;


import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class CSVFile {

   public static void main(String[]args)  {


   		try
		(PrintWriter pw= new PrintWriter(new File("Test.csv"))){
		StringBuilder sb= new StringBuilder();
		sb.append("id");
		sb.append(",");
		sb.append("name");
		sb.append(",");
		sb.append("Position");
		sb.append(",");
		sb.append("Durschnittsnote");
		sb.append("\n");

		sb.append("1");
		sb.append(",");
		sb.append("Colin Moisel");
		sb.append(",");
		sb.append("S");
		sb.append(",");
		sb.append("3,1");
		sb.append("\n");

		sb.append("2");
		sb.append(",");
		sb.append("Ahmet");
		sb.append(",");
		sb.append("S");
		sb.append(",");
		sb.append("1,0");
		sb.append("\n");

		sb.append("3");
		sb.append(",");
		sb.append("Flauschii");
		sb.append(",");
		sb.append("S");
		sb.append(",");
		sb.append("0,99");
		sb.append("\n");

		pw.write(sb.toString());
		pw.close();
		System.out.println("finished");

	} catch ( FileNotFoundException e) {
		System.out.println(e.getMessage());
	}


   }
}