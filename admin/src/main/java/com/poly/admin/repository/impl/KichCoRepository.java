package com.poly.admin.repository.impl;


import com.poly.admin.entity.KichCoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichCoRepository extends JpaRepository<KichCoEntity, UUID> {
}
