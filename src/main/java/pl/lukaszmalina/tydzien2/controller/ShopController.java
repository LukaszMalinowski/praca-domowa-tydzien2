package pl.lukaszmalina.tydzien2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszmalina.tydzien2.service.ShopService;

@RestController
public class ShopController {

    ShopService service;

    @Autowired
    ShopController(ShopService service) {
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addFiveRandomProducts() {
        System.out.println(service.getClass().getName());
        //TODO wywolaj metode z service'u
    }

    public void showCart() {
        //TODO wyswietlenie koszyka
    }
}
