package pl.lukaszmalina.tydzien2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.tydzien2.entity.Product;
import pl.lukaszmalina.tydzien2.repository.CartRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Profile("plus")
public class ShopServicePlusImpl implements ShopService {

    @Value("${product.vat}")
    private double vat;

    @Value("${cart.products-quantity}")
    private int productsQuantity;

    private RandomPriceGenerator priceGenerator;

    private CartRepository repository;

    @Autowired
    public ShopServicePlusImpl(RandomPriceGenerator priceGenerator, CartRepository repository) {
        this.priceGenerator = priceGenerator;
        this.repository = repository;
    }

    @Override
    public List<Product> getCart() {
        return repository.getCart();
    }

    @Override
    public void addFiveRandomProducts() {
        for (int i = 0; i < productsQuantity; i++) {
            BigDecimal randomPrice = priceGenerator.getRandomPrice();
            randomPrice = addVat(randomPrice);
            repository.addProduct(new Product(null, randomPrice));
        }
    }

    private BigDecimal addVat(BigDecimal randomPrice) {
        return randomPrice.add(BigDecimal.valueOf(vat/100).multiply(randomPrice)).setScale(2, RoundingMode.FLOOR);
    }
}
