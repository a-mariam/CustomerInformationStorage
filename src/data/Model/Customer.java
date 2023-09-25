package data.Model;

import java.util.Arrays;

public class Customer {
    private byte [] FirstName;
    private byte [] lastName;
    private byte[] password;
    private byte [] Address;
    private char[] id;
    private byte [] email;

    public byte[] getFirstName() {
        return FirstName;
    }

    public void setFirstName(byte [] firstName) {
        FirstName = firstName;
    }

    public byte[] getLastName() {
        return lastName;
    }

    public void setLastName(byte [] lastName) {
        this.lastName = lastName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte [] password) {
        this.password = password;
    }

    public byte[] getAddress() {
        return Address;
    }

    public void setAddress(byte [] address) {
        Address = address;
    }

    public char[] getId() {
        return id;
    }

    public void setId(char [] id) {
        this.id = id;
    }

    public byte[] getEmail() {
        return email;
    }

    public void setEmail(byte [] email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "FirstName='" + FirstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password=" + Arrays.toString(password) +
                ", Address=" + Address +
                ", id=" + Arrays.toString(id) +
                ", email='" + email + '\'' +
                '}';
    }
}
