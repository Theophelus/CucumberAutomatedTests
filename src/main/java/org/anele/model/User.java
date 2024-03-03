package org.anele.model;

public class User {
    private String username;
    private String password;

    // Default constructor
    public User(String username, String password) {
        // Initialize fields if necessary
        this.username = username;
        this.password = password;
    }

    public User(){

    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}
