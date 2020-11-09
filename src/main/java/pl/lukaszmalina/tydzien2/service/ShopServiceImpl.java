package pl.lukaszmalina.tydzien2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.tydzien2.entity.Product;

import java.util.List;

@Service
@Profile("start")
public class ShopServiceImpl implements ShopService {

    private RandomPriceGenerator randomPriceGenerator;

    @Autowired
    public ShopServiceImpl(RandomPriceGenerator randomPriceGenerator) {
        this.randomPriceGenerator = randomPriceGenerator;
    }

    @Override
    public List<Product> getCart() {
        return null;
    }

    @Override
    public void addFiveRandomProducts() {

    }
}
