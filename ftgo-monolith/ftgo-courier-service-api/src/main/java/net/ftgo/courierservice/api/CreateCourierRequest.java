package main.java.net.ftgo.courierservice.api;

import main.java.net.ftgo.common.Address;
import main.java.net.ftgo.common.PersonName;

public class CreateCourierRequest {
    
    private PersonName name;
    private Address address;

    public CreateCourierRequest() {}

    public CreateCourierRequest(PersonName name, Address address) {
        this.name = name;
        this.address = address;
    }

    public PersonName getName() {
        return name;
    }
    
    public void setName(PersonName name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}