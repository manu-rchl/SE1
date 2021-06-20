package main.datalayer;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
// File Reader implementieren + Buffered Reader und String.split()
//Neu
public class DataReaderEigens {
    char[] array = new char [100];

	try {
        Reader input = new FileReader ("input.txt");

        System.out.println("Is there data in the stream?" + input.ready());)

        input.read(array);
        System.out.println("Data in the stream:");
        System.out.println(array);
        input.close();
    }

	catch(Exception e) {
        e.getStackTrace();

        Reader input = new FileReader("input.txt");
        //manu
        input.read();
        input.close();


    }
    BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        while ((row = csvReader.readLine()) != null) {
        String[] data = row.split(",");
        // do something with the data
    }
        csvReader.close();

    File csvFile = new File(pathToCsv);
        if (csvFile.isFile()) {
        // create BufferedReader and read data from csv
    }



}
