package Entities;

import Services.AccountBasics;

public class Account {
    private String name;
    private String email;
    private String login;
    private String password;

    private AccountBasics ab;

    public Account(String name, String email, String login, String password) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
            if (password.length() < 4 || password.length() >10) {
                this.password = password;
            } else {
                System.out.println("Password must have between 4 and 10 characters. ");
            }
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password=" + password +
                '}';
    }
}
