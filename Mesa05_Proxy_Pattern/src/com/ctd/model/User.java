package com.ctd.model;

public class User {

    private Integer id;
    private String typeUser;

    public User(Integer id, String typeUser) {
        this.id = id;
        this.typeUser = typeUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "User: " + id + " Acess: " + typeUser;
    }
}
