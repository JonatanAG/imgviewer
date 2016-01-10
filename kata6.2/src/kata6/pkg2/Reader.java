package kata62;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Reader {
    
    public static ArrayList <Person> read () throws FileNotFoundException, IOException, SQLException, ClassNotFoundException{
        ArrayList <Person> people = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from PEOPLE");

        while (rs.next()) {
            int id = rs.getInt("id");
            String mail = rs.getString("mail");
            String gender = rs.getString("genero");
            Float weight = rs.getFloat("peso");
            people.add(new Person(id,mail,gender,weight));
        }
        return people;
    }
}