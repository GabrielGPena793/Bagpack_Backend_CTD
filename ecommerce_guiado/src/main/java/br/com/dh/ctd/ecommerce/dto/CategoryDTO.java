package br.com.dh.ctd.ecommerce.dto;


import br.com.dh.ctd.ecommerce.model.Categories;

public class CategoryDTO {

    private Integer id;
    private String nome;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoryDTO(Categories categories) {
        id = categories.getId();
        nome = categories.getNome();
    }


    public CategoryDTO(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
