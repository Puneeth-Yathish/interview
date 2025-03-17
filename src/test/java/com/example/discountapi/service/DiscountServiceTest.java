package com.example.discountapi.service;

import com.example.discountapi.model.UserType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {
    @Test
    void testCalculateDiscount() {
        DiscountService discountService = new DiscountService(null, null);
        double discount = discountService.calculateDiscount(1L, 5, "SPRING25", UserType.PREMIUM);
        assertTrue(discount > 0);
    }
}