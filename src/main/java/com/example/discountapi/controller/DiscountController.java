package com.example.discountapi.controller;

import com.example.discountapi.model.UserType;
import com.example.discountapi.service.DiscountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {
    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @PostMapping
    public double postDiscount(@Requestbody Discountdto ) {
        return discountService.calculateDiscount(productId, quantity, promoCode, userType);
    }
}