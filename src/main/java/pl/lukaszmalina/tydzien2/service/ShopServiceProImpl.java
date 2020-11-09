package pl.lukaszmalina.tydzien2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.tydzien2.entity.Product;
import pl.lukaszmalina.tydzien2.repository.CartRepository;

import java.util.List;

@Service
@Profile("pro")
public class ShopServiceProImpl implements ShopService{

    @Value ("${product.vat}")
    private double vat;

    @Value("${product.discount}")
    private int discount;

    private RandomPriceGenerator priceGenerator;

    private CartRepository repository;

    @Autowired
    public ShopServiceProImpl(RandomPriceGenerator priceGenerator, CartRepository repository) {
        this.priceGenerator = priceGenerator;
        this.repository = repository;
    }

    @Override
    public List<Product> getCart() {
        return repository.getCart();
    }

    @Override
    public void addFiveRandomProducts() {

    }
}
