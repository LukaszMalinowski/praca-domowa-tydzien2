package pl.lukaszmalina.tydzien2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.tydzien2.entity.Product;
import pl.lukaszmalina.tydzien2.repository.CartRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@Profile("start")
public class ShopServiceImpl implements ShopService {

    @Value("${cart.products-quantity}")
    protected int productsQuantity;

    protected RandomPriceGenerator priceGenerator;

    protected CartRepository repository;

    @Autowired
    public ShopServiceImpl(RandomPriceGenerator priceGenerator, CartRepository repository) {
        this.priceGenerator = priceGenerator;
        this.repository = repository;
    }

    @Override
    public List<Product> getCart() {
        return repository.getCart();
    }

    @Override
    public void addRandomProducts() {
        for (int i = 0; i < productsQuantity; i++) {
            repository.addProduct(new Product("Product " + i, priceGenerator.getRandomPrice()));
        }
    }

    @Override
    public BigDecimal getTotalPrice() {
        List<Product> cart = repository.getCart();

        BigDecimal totalPrice = new BigDecimal(0);

//        final BigDecimal[] totalPrice = {new BigDecimal(0)};
//        cart.forEach(product -> totalPrice[0] = totalPrice[0].add(product.getPrice()));

        for (Product product : cart) {
            totalPrice = totalPrice.add(product.getPrice());
        }

        return totalPrice;
    }
}
