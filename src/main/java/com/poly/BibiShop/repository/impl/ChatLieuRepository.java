package com.poly.BibiShop.repository.impl;


import com.poly.BibiShop.entity.ChatLieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatLieuRepository extends JpaRepository<ChatLieuEntity, UUID> {

}
