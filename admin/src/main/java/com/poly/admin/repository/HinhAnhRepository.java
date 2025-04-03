package com.poly.admin.repository;

import com.poly.admin.entity.HinhAnhEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnhEntity,Integer> {
}
