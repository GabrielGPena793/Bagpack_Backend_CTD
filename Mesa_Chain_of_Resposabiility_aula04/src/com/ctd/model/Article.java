package com.ctd.model;

public class Article {

    private String name;
    private int batch;
    private int weight;
    private String packaging;

    public Article() {
    }

    public Article(String name, int batch, int weight, String packaging) {
        this.name = name;
        this.batch = batch;
        this.weight = weight;
        this.packaging = packaging;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }
}
