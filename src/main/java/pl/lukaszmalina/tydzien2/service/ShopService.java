package pl.lukaszmalina.tydzien2.service;

import pl.lukaszmalina.tydzien2.entity.Product;

import java.util.List;

public interface ShopService {

    List<Product> getCart();

    void addRandomProducts();
}
