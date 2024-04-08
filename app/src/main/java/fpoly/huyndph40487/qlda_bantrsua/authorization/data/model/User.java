package fpoly.huyndph40487.qlda_bantrsua.authorization.data.model;

import java.io.Serializable;

import fpoly.huyndph40487.qlda_bantrsua.core.data.model.Person;

public class User extends Person implements Serializable {
    private String userName;
    private String address;

    public User() {
    }

    public User(String id, String name, String phoneNumber, String email, String avatar, String userName, String address) {
        super(id, name, phoneNumber, email, avatar);
        this.userName = userName;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
