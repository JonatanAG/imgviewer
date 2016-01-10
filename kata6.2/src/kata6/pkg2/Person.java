
package kata62;

public class Person {
    private final Integer id;
    private final String mail;
    private final String gender;
    private final float weight;
    
    public Person(Integer id, String mail, String gender, float weight) {
        this.id = id;
        this.mail = mail;
        this.gender = gender;
        this.weight = weight;
    }
    
    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getGender() {
        return gender;
    }

    public float getWeight() {
        return weight;
    }
}
