package com.poly.admin.repository.impl;


import com.poly.admin.entity.MauSacEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSacEntity, UUID> {
}
