package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        String pathName = "/Users/Indra/Desktop/email.txt";
        ArrayList<Person> people = Reader.read(pathName);
        HistogramBuilder<Person> builder = new HistogramBuilder<>(people);
        Histogram<String> domains = builder.build(new Atribute <Person,String>() {
            @Override
            public String get(Person person) {
                return person.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder.build(new Atribute<Person,Character>() {
            @Override
            public Character get(Person person) {
                return person.getMail().charAt(0);
            }
        });
       new HistogramDisplay(domains).execute();
       new HistogramDisplay(letters).execute();
    }
}
