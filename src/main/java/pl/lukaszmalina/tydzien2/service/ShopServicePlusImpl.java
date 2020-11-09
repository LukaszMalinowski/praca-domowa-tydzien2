package pl.lukaszmalina.tydzien2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.tydzien2.entity.Product;
import pl.lukaszmalina.tydzien2.repository.CartRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Profile("plus")
public class ShopServicePlusImpl extends ShopServiceImpl {

    @Value("${product.vat}")
    protected double vat;

    @Autowired
    public ShopServicePlusImpl(RandomPriceGenerator priceGenerator,
                               CartRepository repository) {
        super(priceGenerator, repository);
    }


    @Override
    public void addRandomProducts() {
        for (int i = 0; i < productsQuantity; i++) {
            BigDecimal randomPrice = priceGenerator.getRandomPrice();
            randomPrice = addVat(randomPrice);
            repository.addProduct(new Product("Product " + i, randomPrice));
        }
    }

    protected BigDecimal addVat(BigDecimal randomPrice) {
        return randomPrice.add(BigDecimal.valueOf(vat/100).multiply(randomPrice)).setScale(2, RoundingMode.FLOOR);
    }
}
