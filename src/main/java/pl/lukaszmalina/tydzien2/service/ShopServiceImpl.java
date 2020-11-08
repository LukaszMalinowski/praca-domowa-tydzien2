package pl.lukaszmalina.tydzien2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.tydzien2.entity.Product;

import java.util.List;

@Service
@Profile("start")
public class ShopServiceImpl implements ShopService {

    @Override
    public List<Product> getCart() {
        return null;
    }

    @Override
    public void addFiveRandomProducts() {

    }
}
