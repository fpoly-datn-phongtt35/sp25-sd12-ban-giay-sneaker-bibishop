package com.poly.BibiShop.repository;

import com.poly.BibiShop.entity.HinhAnhEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnhEntity,UUID> {
}
