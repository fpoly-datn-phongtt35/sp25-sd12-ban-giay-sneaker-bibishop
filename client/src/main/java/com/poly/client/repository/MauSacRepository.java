package com.poly.client.repository;


import com.poly.client.entity.MauSacEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSacEntity, UUID> {

  @Query("SELECT ms FROM MauSacEntity ms WHERE ms.trangThai = 1")
  List<MauSacEntity> findAllActive();

}
