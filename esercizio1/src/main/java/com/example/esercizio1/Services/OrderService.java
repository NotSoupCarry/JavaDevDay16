package com.example.esercizio1.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.esercizio1.Interfaces.IShippingService;

@Service
public class OrderService {
    private final IShippingService standardShippingService;
    private final IShippingService expressShippingService;

    // qualifier associa alle interfaccie le classi corrispettive
    public OrderService(@Qualifier("standardShippingService") IShippingService standardShippingService,
            @Qualifier("expressShippingService") IShippingService expressShippingService) {
        this.standardShippingService = standardShippingService;
        this.expressShippingService = expressShippingService;
    }

    public double getTotalShippingCost(String shipmentType, String country, double weight) {
        if (shipmentType.equalsIgnoreCase("standard")) { // se è standard usa standardService
            return standardShippingService.calculateShipping(country, weight);
        } else if (shipmentType.equalsIgnoreCase("express")) { // se è express usa expressService
            return expressShippingService.calculateShipping(country, weight);
        } else {
            return 0; // error
        }
    }

}
