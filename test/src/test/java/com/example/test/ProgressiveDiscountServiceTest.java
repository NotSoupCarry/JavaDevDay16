package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class) // ✅ Correct way to exclude DB auto-config
public class ProgressiveDiscountServiceTest {

    private final DiscountService discountService = new ProgressiveDiscountService(); // Usiamo l'implementazione reale

    @Test
    void testProgressiveDiscountBelow100() {
        double result = discountService.applyDiscount(80); // 5% di sconto su 80 → 76.0
        assertEquals(76.0, result);
    }

    @Test
    void testProgressiveDiscountAbove100() {
        double result = discountService.applyDiscount(200); // 15% di sconto su 200 → 170.0
        assertEquals(170.0, result);
    }
}