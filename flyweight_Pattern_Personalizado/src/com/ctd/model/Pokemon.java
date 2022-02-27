package com.ctd.model;

public class Pokemon {

    private String name;
    private boolean envolved;

    public Pokemon() {
    }

    public Pokemon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnvolved() {
        return envolved;
    }

    public void setEnvolved(boolean envolved) {
        this.envolved = envolved;
    }

    @Override
    public String toString() {
        return "Pokemon name : " + name +
                "\nEnvolved: " + envolved;
    }
}
