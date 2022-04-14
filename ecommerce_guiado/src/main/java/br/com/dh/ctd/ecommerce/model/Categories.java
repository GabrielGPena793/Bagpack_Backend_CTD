package br.com.dh.ctd.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table
public class Categories implements Serializable {
    private static final Long SERIAL_VERSION_UID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE" )
    private Instant created;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE" )
    private Instant updated;


    @PrePersist
    public void savingCategory(){
        created = Instant.now();
    }

    @PreUpdate
    public void updateCategory(){
        updated = Instant.now();
    }


    public Categories() {
    }

    public Categories(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Categories(String name) {
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

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

}
