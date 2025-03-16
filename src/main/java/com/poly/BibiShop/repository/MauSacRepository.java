package com.poly.BibiShop.repository;


import com.poly.BibiShop.entity.MauSacEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSacEntity, UUID> {
}
