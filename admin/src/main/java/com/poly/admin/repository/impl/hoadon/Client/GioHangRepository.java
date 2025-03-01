package com.poly.BibiShop.repository.impl.hoadon.Client;

import com.poly.BibiShop.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Integer> {}