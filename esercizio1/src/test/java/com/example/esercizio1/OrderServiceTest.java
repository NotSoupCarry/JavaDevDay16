package com.example.esercizio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.esercizio1.Interfaces.IShippingService;
import com.example.esercizio1.Services.ExpressShippingService;
import com.example.esercizio1.Services.OrderService;
import com.example.esercizio1.Services.StandardShippingService;

public class OrderServiceTest {
    private final IShippingService standardShippingService = new StandardShippingService(); // Usiamo l'implementazione reale
    private final IShippingService expresShippingService = new ExpressShippingService();

    @Test
    void testStandardShippingService() {
        double result = standardShippingService.calculateShipping("EUROPE", 10);
        assertEquals(35.0, result);
        System.err.println("testStandardShippingService" + result);
    }

    @Test
    void testExpressShippingService() {
        double result = expresShippingService.calculateShipping("EUROPE", 10);
        assertEquals(65.0, result);
    }
    
    private final OrderService orderService = new OrderService(standardShippingService, expresShippingService);

    @Test
    void testOrderService() {
        double result = orderService.getTotalShippingCost("standard","EUROPE", 10);
        assertEquals(35.0, result);
    }
}
