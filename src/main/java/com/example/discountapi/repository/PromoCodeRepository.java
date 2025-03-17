package com.example.discountapi.repository;

import com.example.discountapi.model.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {
    PromoCode findByCode(String code);
}