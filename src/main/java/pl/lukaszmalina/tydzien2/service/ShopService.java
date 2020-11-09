package pl.lukaszmalina.tydzien2.service;

import pl.lukaszmalina.tydzien2.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ShopService {

    List<Product> getCart();

    void addRandomProducts();

    BigDecimal getTotalPrice();
}
