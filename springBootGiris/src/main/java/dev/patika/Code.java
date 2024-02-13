package dev.patika;

import jakarta.persistence.*;

@Entity
@Table(name="codes")
public class Code{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id", columnDefinition = "serial")
    private int id;

    @Column(name = "code_group", nullable = false)
    private String group;

    @OneToOne(mappedBy = "code")
    private Product product;

    public Code() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}