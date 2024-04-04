package com.hyquangcuong.commicapp.Model;

public class User {
    private int Id;
    private String Name;
    private String Pass;
    private String Email;
    private int Role;

    public User(String name, String pass, String email, int role) {
        Name = name;
        Pass = pass;
        Email = email;
        Role = role;
    }

    public User(String name, String email) {
        Name = name;
        Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
        Role = role;
    }
}
