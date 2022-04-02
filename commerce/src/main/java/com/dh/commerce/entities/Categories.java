package com.dh.commerce.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table
public class Categories{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Categories() {
    }

    public Categories(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Categories(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
