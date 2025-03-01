package com.poly.BibiShop.repository.impl;


import com.poly.BibiShop.entity.DanhMucEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMucEntity, UUID> {
}
