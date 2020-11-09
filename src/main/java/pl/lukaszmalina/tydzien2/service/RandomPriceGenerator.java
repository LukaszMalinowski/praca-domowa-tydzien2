package pl.lukaszmalina.tydzien2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@Component
public class RandomPriceGenerator {

    @Value("${product.min-price}")
    private BigDecimal minPrice;

    @Value("${product.max-price}")
    private BigDecimal maxPrice;

    private Random random;

    public RandomPriceGenerator() {
        random = new Random();
    }

    @EventListener(ApplicationReadyEvent.class)
    public BigDecimal getRandomPrice() {
        BigDecimal randomPrice = BigDecimal.valueOf(random.nextDouble() * (maxPrice.doubleValue() - minPrice.doubleValue()) + minPrice.doubleValue());
        randomPrice = randomPrice.setScale(2, RoundingMode.FLOOR);
        return randomPrice;
    }
}
