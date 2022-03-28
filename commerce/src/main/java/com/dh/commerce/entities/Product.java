package com.dh.commerce.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    private String description;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categories category;

    public Product() {
    }

    public Product(Double price, String description, String image, Categories category) {
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public Product(Long id, Double price, String description, String image, Categories category) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

}
