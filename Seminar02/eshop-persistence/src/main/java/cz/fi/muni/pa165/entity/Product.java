package cz.fi.muni.pa165.entity;

import cz.fi.muni.pa165.enums.Color;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ESHOP_PRODUCTS")
public class Product {
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable=false,unique=true)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date addedDate;

    private Color color;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {

        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ! (o instanceof Product)) return false;

        Product product = (Product) o;

        return name != null ? name.equals(product.getName()) : product.getName() == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
