package com.poly.BibiShop.repository.impl;


import com.poly.BibiShop.entity.KichCoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichCoRepository extends JpaRepository<KichCoEntity, UUID> {
}
