package com.poly.BibiShop.repository.impl.hoadon.Client;

import com.poly.BibiShop.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, Integer> {}
