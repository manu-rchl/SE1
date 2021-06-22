package main.datalayer;
//Reader(liest immer nur einen character,
//BufferedReader, ließt einen größeren Block (array) auf einmal
//dient als Subklasse zu dem Java Reader
//IOException: wird geworfen wenn Input oder Output Fehler auftretten
// FileReader: ließt charactere, in einem Fluss aus dem Dokument
import main.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DHBWFileReader {

        private static DHBWFileReader dr;
        private ArrayList <Person> dhbw;

        public static DHBWFileReader getInstance() {
            if(dr == null)
                dr = new DHBWFileReader();
            return dr;
        }
        public DHBWFileReader(){
            dhbw= new ArrayList<>();
        }
    public int loadDataDHBW(boolean peopleDataExists, String path) {
        if(!peopleDataExists) {
            return 4;
        }
        Person p = null;
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


