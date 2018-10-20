package models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AtagaN on 13.05.2018.
 */

@Entity
@Table(name = "productCategory")
public class ProductCategory extends Model {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_product_category", referencedColumnName = "Id")
    private ProductCategory parentProductCategory;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products = new HashSet<Product>();


    public ProductCategory() {
    }

    public ProductCategory(long id) {
        super(id);
    }


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public ProductCategory getParentProductCategory() {
        return parentProductCategory;
    }

    public void setParentProductCategory(ProductCategory parentProductCategory) {
        this.parentProductCategory = parentProductCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
