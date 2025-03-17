package com.example.discountapi.service;

import com.example.discountapi.model.*;
import com.example.discountapi.repository.*;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    private final ProductRepository productRepository;
    private final PromoCodeRepository promoCodeRepository;

    public DiscountService(ProductRepository productRepository, PromoCodeRepository promoCodeRepository) {
        this.productRepository = productRepository;
        this.promoCodeRepository = promoCodeRepository;
    }

    public double calculateDiscount(Long productId, int quantity, String promoCode, UserType userType) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        double basePrice = product.getPrice() * quantity;
        double discount = 0.0;

        if (promoCode != null) {
            PromoCode code = promoCodeRepository.findByCode(promoCode);
            if (code != null) {
                discount += basePrice * (code.getDiscountPercentage() / 100);
            }
        }

        if (userType == UserType.PREMIUM) {
            discount += basePrice * 0.10; // 10% off for premium users
        }

        return basePrice - discount;
    }
}