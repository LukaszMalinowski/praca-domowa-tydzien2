package pl.lukaszmalina.tydzien2.repository;

import org.springframework.stereotype.Repository;
import pl.lukaszmalina.tydzien2.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepository {

    private List<Product> cart;

    public CartRepository() {
        cart = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
