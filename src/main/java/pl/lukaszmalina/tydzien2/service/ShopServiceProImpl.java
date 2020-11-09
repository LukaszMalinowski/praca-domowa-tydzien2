package pl.lukaszmalina.tydzien2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.lukaszmalina.tydzien2.entity.Product;

import java.util.List;

@Service
@Profile("pro")
public class ShopServiceProImpl implements ShopService{

    @Value ("${product.vat}")
    private int vat;

    @Value("${product.discount}")
    private int discount;

    private RandomPriceGenerator randomPriceGenerator;

    @Autowired
    public ShopServiceProImpl(RandomPriceGenerator randomPriceGenerator) {
        this.randomPriceGenerator = randomPriceGenerator;
    }

    @Override
    public List<Product> getCart() {
        return null;
    }

    @Override
    public void addFiveRandomProducts() {

    }

    @EventListener (ApplicationReadyEvent.class)
    public void get() {
        System.out.println(vat);
        System.out.println(discount);
    }
}
