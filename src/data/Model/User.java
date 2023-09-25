package data.Model;

import java.util.ArrayList;

public class User {
    private String name;
    private byte [] passWord;
    private ArrayList<Customer> customers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPassWord() {
        return passWord;
    }

    public void setPassWord(byte []  passWord) {
        this.passWord = passWord;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", customers=" + customers +
                '}';
    }
}
