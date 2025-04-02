package com.poly.client.repository;


import com.poly.client.entity.KichCoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichCoRepository extends JpaRepository<KichCoEntity, UUID> {
}
