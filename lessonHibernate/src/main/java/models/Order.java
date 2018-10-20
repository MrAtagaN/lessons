package models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by AtagaN on 14.05.2018.
 */
@Entity
@Table(name = "[order]")
public class Order extends Model {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "Id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "Id")
    private Product product;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private boolean status;

    public Order() {
    }

    public Order(long id) {
        super(id);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
