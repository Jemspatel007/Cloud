package com.example.A2.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "products")
@ToString
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    public Products() {}

    public Products(String name, String price, boolean availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
