package br.com.dh.ctd.ecommerce.dto;

import br.com.dh.ctd.ecommerce.model.Categories;
import br.com.dh.ctd.ecommerce.model.Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDTO implements Serializable {
    private static final Long SERIAL_VERSION_UID = 1L;

    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String image;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String title, String description, Double price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public ProductDTO(Products products) {
        id = products.getId();
        title = products.getTitle();
        description = products.getDescription();
        price = products.getPrice();
        image = products.getImage();
        categories = products.getCategories().stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());

    }

    public ProductDTO(Products products, Set<Categories> categoriesSet){
        this(products);
        categoriesSet.forEach(categorie -> this.categories.add(new CategoryDTO(categorie)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

}
