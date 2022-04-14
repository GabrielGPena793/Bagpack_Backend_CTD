package br.com.dh.ctd.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Entity
@Table
public class Products implements Serializable {
    private static final Long SERIAL_VERSION_UID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String image;

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

    @ManyToMany
    @JoinTable(name = "product_category",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn( name = "category_id"))
    private Set<Categories> categories;

    public Products() {
    }

    public Products(Integer id, String title, String description, Double price, String image, Set<Categories> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.categories = categories;
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

    public Set<Categories> getCategories() {
        return categories;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }
}
