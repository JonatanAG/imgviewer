package kata62;

import java.util.Arrays;

public class Mail{
    private final String mail;
    
    public Mail(String mail) {
        this.mail = mail;
    }
    
    public String getMail(){
        return mail;
    }
    
    public String getDomain (){
        final String[] split = mail.split("@");
        return split[1];
    }
}