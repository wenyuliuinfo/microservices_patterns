package main.java.net.ftgo.common;

import javax.persistence.Embeddable;

@Embeddable
public class PersonName {

    private String firstName;
    private String lastName;

    private PersonName() {}

    public PersonName(String firsName, String lastName) {
        this.firstName = firsName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
