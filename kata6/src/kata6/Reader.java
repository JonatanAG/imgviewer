package kata6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    
    public static ArrayList <Person> read (String name) throws FileNotFoundException, IOException{
        ArrayList <Person> people = new ArrayList<>();
        final File file = new File(name);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String mail;
        Integer id = 0;
        while ((mail = reader.readLine()) != null){
            if(!mail.contains("@")) continue;
            people.add(new Person(id++,mail));
        }
        reader.close();
        return people;
    }
}