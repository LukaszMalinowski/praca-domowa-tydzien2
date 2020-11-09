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
@Profile("pro")
public class ShopServiceProImpl extends ShopServicePlusImpl{

    @Value("${product.discount}")
    private double discount;

    @Autowired
    public ShopServiceProImpl(RandomPriceGenerator priceGenerator,
                              CartRepository repository) {
        super(priceGenerator, repository);
    }

    @Override
    public void addFiveRandomProducts() {
        for (int i = 0; i < productsQuantity; i++) {
            BigDecimal randomPrice = priceGenerator.getRandomPrice();
            randomPrice = addVat(randomPrice);
            randomPrice = addDiscount(randomPrice);
            repository.addProduct(new Product("Product " + i, randomPrice));
        }
    }

    private BigDecimal addDiscount(BigDecimal randomPrice) {
        return randomPrice.subtract(BigDecimal.valueOf(discount/100).multiply(randomPrice)).setScale(2, RoundingMode.FLOOR);
    }
}
