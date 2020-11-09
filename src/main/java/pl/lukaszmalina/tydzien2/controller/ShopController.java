package pl.lukaszmalina.tydzien2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszmalina.tydzien2.entity.Product;
import pl.lukaszmalina.tydzien2.service.ShopService;

import java.util.List;

@RestController
public class ShopController {

    private ShopService service;

    @Autowired
    ShopController(ShopService service) {
        this.service = service;
    }

    public void addFiveRandomProducts() {
        service.addFiveRandomProducts();
    }

    public void showCart() {
        List<Product> cart = service.getCart();

        cart.forEach(System.out::println);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        addFiveRandomProducts();
        showCart();
    }
}
