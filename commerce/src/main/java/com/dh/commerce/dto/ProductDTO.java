package com.dh.commerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private Double price;
    private String title;
    private String description;
    private String image;
    private Long category;

    public ProductDTO(Double price, String description, String image, Long category, String title) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }
}
