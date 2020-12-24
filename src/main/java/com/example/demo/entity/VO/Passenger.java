package com.example.demo.entity.VO;

import java.util.Objects;

public class Passenger {
    private String username;
    private int userID;
    private String contact;

    public Passenger(String username, int userID, String contact) {
        this.username = username;
        this.userID = userID;
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return userID == passenger.userID &&
                Objects.equals(username, passenger.username) &&
                Objects.equals(contact, passenger.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, userID, contact);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "username='" + username + '\'' +
                ", userID=" + userID +
                ", contact='" + contact + '\'' +
                '}';
    }
}
