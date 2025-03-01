package com.poly.BibiShop.repository.impl.hoadon.Server;

import com.poly.BibiShop.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface khachHangRepository extends JpaRepository<KhachHang,Long> {

}
