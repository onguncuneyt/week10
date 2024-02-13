package dev.patika;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id",columnDefinition = "serial")
    private int id;

    @Column(name = "color_name",nullable = false)
    private String colorName;

    @OneToMany(mappedBy = "colorList")
    private List<Product> productList;

    public Colors() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
