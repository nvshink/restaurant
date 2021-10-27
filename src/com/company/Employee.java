package com.company;

public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String post;
    private String login;
    private String password;
    public Employee (int id, String lastName, String firstName, String middleName, String post, String login, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.post = post;
        this.login = login;
        this.password = password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setFirstName(String firstName) {
        this.lastName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setMiddleName(String middleName) {
        this.lastName = middleName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setPost(String post) {
        this.lastName = post;
    }
    public String getPost() {
        return post;
    }
    public void setLogin(String login) {
        this.lastName = login;
    }
    public String getLogin() {
        return login;
    }
    public void setPassword(String password) {
        this.lastName = password;
    }
    public String getPassword() {
        return password;
    }

}
