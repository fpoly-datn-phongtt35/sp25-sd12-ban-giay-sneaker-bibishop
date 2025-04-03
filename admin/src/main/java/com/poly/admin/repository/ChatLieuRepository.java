package com.poly.admin.repository;


import com.poly.admin.entity.ChatLieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatLieuRepository extends JpaRepository<ChatLieuEntity, Integer> {

}
