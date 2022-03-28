package com.dh.commerce.dto;

import com.dh.commerce.entities.Categories;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private Double price;
    private String description;
    private String image;
    private Categories category;

    public ProductDTO(Double price, String description, String image, Categories category) {
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }
}
