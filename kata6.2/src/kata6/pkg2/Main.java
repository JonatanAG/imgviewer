package kata62;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, SQLException, ClassNotFoundException {
        ArrayList<Person> people = Reader.read();
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
        
        Histogram<String> genders = builder.build(new Atribute <Person,String>() {
            @Override
            public String get(Person person) {
                return person.getGender();
            }
        });
        
        Histogram<Float> weights = builder.build(new Atribute <Person,Float>() {
            @Override
            public Float get(Person person) {
                return person.getWeight();
            }
        });
        
       new HistogramDisplay(domains,"Dominios").execute();
       new HistogramDisplay(letters,"Letras").execute();
       new HistogramDisplay(genders,"Géneros").execute();
       new HistogramDisplay(weights,"Pesos").execute();
    }
}
