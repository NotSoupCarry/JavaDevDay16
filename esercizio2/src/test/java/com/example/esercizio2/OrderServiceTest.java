package com.example.esercizio2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.esercizio2.Interfaces.IDiscountService;
import com.example.esercizio2.Interfaces.IShippingService;
import com.example.esercizio2.Services.ExpressDiscountService;
import com.example.esercizio2.Services.ExpressShippingService;
import com.example.esercizio2.Services.OrderService;
import com.example.esercizio2.Services.StandardDiscountService;
import com.example.esercizio2.Services.StandardShippingService;

public class OrderServiceTest {
    private final IShippingService standardShippingService = new StandardShippingService(); // Usiamo l'implementazione
                                                                                            // reale
    private final IShippingService expresShippingService = new ExpressShippingService();

    private final IDiscountService standardDiscountService = new StandardDiscountService();
    private final IDiscountService expresDiscountService = new ExpressDiscountService();

    @Test
    void testStandardShippingService() {
        double result = standardShippingService.calculateShippingCost("EUROPE", 10);
        assertEquals(35.0, result);
    }

    @Test
    void testExpressShippingService() {
        double result = expresShippingService.calculateShippingCost("EUROPE", 10);
        assertEquals(65.0, result);
    }

    @Test
    void testStandardDiscountService() {
        double result = standardDiscountService.applyDiscount(150);
        assertEquals(7.5, result);
    }

    @Test
    void testExpressDiscountService() {
        double result = expresDiscountService.applyDiscount(150);
        assertEquals(10.5, result);
    }

    private final OrderService orderService = new OrderService(standardShippingService, expresShippingService,
            standardDiscountService, expresDiscountService);

    @Test
    void testOrderService() {
        double[] result = orderService.getTotalOrderCost(150, "standard", "express", "USA", 30.50);
        // assertArrayEquals per confrontare i valori negli array
        assertArrayEquals(new double[] { 7.5, 116.5 }, result, 0.01); // 0.01 è la tolleranza per confronti con double

    }
}
