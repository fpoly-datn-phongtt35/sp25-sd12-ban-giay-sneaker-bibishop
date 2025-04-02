package com.poly.client.repository;


import com.poly.client.entity.ChatLieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChatLieuRepository extends JpaRepository<ChatLieuEntity, UUID> {

  @Query("SELECT cl FROM ChatLieuEntity cl WHERE cl.trangThai = 1")
  List<ChatLieuEntity> findAllActive();

}
