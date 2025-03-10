package com.example.esercizio2.Services;

import org.springframework.stereotype.Service;

import com.example.esercizio2.Interfaces.IDiscountService;
import com.example.esercizio2.Interfaces.IShippingService;

import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class OrderService {
    private final IShippingService standardShippingService;
    private final IShippingService expressShippingService;
    private final IDiscountService standardDiscountService;
    private final IDiscountService expresDiscountService;

    // qualifier associa alle interfaccie le classi corrispettive
    public OrderService(@Qualifier("standardShippingService") IShippingService standardShippingService,
            @Qualifier("expressShippingService") IShippingService expressShippingService,
            @Qualifier("standardDiscountService") IDiscountService standardDiscountService,
            @Qualifier("expressDiscountService") IDiscountService expresDiscountService) {
        this.standardShippingService = standardShippingService;
        this.expressShippingService = expressShippingService;
        this.standardDiscountService = standardDiscountService;
        this.expresDiscountService = expresDiscountService;
    }

    public double[] getTotalOrderCost(double orderTotal, String discountType, String shippingType, String country,
            double weight) {
        double shipmentResult;
        double orderResult;
        if (shippingType.equalsIgnoreCase("standard")) { // se è standard usa standardService
            shipmentResult = standardShippingService.calculateShippingCost(country, weight);
        } else if (shippingType.equalsIgnoreCase("express")) { // se è express usa expressService
            shipmentResult = expressShippingService.calculateShippingCost(country, weight);
        } else {
            shipmentResult = 0; // error
        }

        if (discountType.equalsIgnoreCase("standard")) {
            orderResult = standardDiscountService.applyDiscount(orderTotal);
        } else if (discountType.equalsIgnoreCase("express")) { // se è express usa expressService
            orderResult = expresDiscountService.applyDiscount(orderTotal);
        } else {
            orderResult = 0; // error
        }

        return new double[]{orderResult, shipmentResult};
    }

}
