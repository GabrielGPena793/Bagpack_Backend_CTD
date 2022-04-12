package br.com.dh.ctd.ecommerce.dto;

import br.com.dh.ctd.ecommerce.model.Categories;

public class CategoryDTO {

    private Integer id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Categories categories) {
        id = categories.getId();
        name = categories.getName();
    }


    public CategoryDTO(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
