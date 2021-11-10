package com.company;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String post;
    private final String login;
    private final String password;
    public Employee (int id, String lastName, String firstName, String middleName, String post, String login, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.post = post;
        this.login = login;
        this.password = password;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getShortFirstName() {
        return firstName.charAt(0) + ".";
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getShortMiddleName() {
        return middleName.charAt(0) + ".";
    }
    public String getPost() {
        return post;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }

}
